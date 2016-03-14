import cv2 as cv
import math
import numpy as np

VERT_FOV = math.radians(44.44) 
REAL_TAPE_HEIGHT = 14 # inches of real tape height
IMG_HEIGHT = 480; # pixels of image resolution
IMG_WIDTH = 640

camera = cv.VideoCapture(0)
	
def findGoal():
	#frame = camera.read
	frame = cv.imread("images/goal.png")
	
	frame = BGR2HSV(frame)
	frame = reduceNoise(frame)
	frame = tapeHSVThreshhold(frame)
	
	image,contours,hierarchy = findContours(frame)
	contours = filterContours(contours)

	if len(contours) > 0:
		goalContour = findGoalContour(contours)
		rectX, rectY, rectWidth, rectHeight = cv.boundingRect(goalContour)
		angle = cv.minAreaRect(goalContour)[2] # rotatedRect = ((centerX,centerY),(width,height),angleOfRotation)
		goalVertices = approxPoly(goalContour)
		bottomY1, bottomY2 = findBottomY(goalVertices)
		topY1, topY2 = findTopY(goalVertices) 
		
		distToGoal = findDistToGoal(rectWidth)
		print "dist: " + str(distToGoal)
		
		if isFacingForward(bottomY1, bottomY2):
			print "facing forward"
		else:
			print "isFacingLeft: " + str(isFacingLeft(bottomY1, bottomY2))
			print "lat angle: " + str(findLateralAngle(bottomY1, bottomY2)) #both lat angles get the same thing, decide which one to use
			print "lat angle2: " + str(math.fabs(angle))
		
		if isOnMidline(rectX, rectWidth):
			print "on midline"
		else: 
			print "isOnRight: " + str(isOnRight(rectX, rectWidth))
			print "distFromMidline: " + str(distFromMidline(bottomY1, bottomY2, topY1, topY2, distToGoal))
		
def BGR2HSV(input):
	return cv.cvtColor(input, cv.COLOR_BGR2HSV)

def reduceNoise(input):
	element = cv.getStructuringElement(cv.MORPH_ELLIPSE,(5,5))
	input = cv.erode(input, element, iterations=1)
	input = cv.dilate(input, element, iterations=1)
	return input
	
# scalar params: H(0-180), S(0-255), V(0-255)	
def tapeHSVThreshhold(input):
	input = cv.inRange(input, np.array([60,0,240]), np.array([95,255,255]), input)
	return input
	
def findContours(input):
	return cv.findContours(input, cv.RETR_LIST, cv.CHAIN_APPROX_NONE)
	
def filterContours(contours): 
	filteredContours = []
	for contour in contours:
		x,y,width,height = cv.boundingRect(contour)
		if(width > 80 and width < 200
			and height > 30 and height < 100
			and y < 400):
			filteredContours.append(contour)	
	return filteredContours

def findGoalContour(contours):
	rectWidths = []
	rectWidths.append(cv.boundingRect(contours[0])[2]) # width is index 2 of rect tuple
	lrgstRectIndx = 0
	for i in range(0,len(contours)):
		width = cv.boundingRect(contours[i])[2]
		rectWidths.append(width)
		if width > rectWidths[lrgstRectIndx]:
			lrgstRectIndx = i
	return contours[lrgstRectIndx]		

# finds vertices of goal
def approxPoly(contour):
	 contour = cv.convexHull(contour)
	 return cv.approxPolyDP(contour,5,True)

# finds bottom vertices	 
def findBottomY(points):
	highestY = points[0][0]
	secondHighestY = points[1][0] # [0] at end needed to unpack point
	for point in points:
		point = point[0] # for unpacking point
		if point[1] > highestY[1]:
			secondHighestY = highestY
			highestY = point
		elif point[1] > secondHighestY[1]:
			secondHighestY = point
	return (highestY, secondHighestY)

# finds top vertices	
def findTopY(points):
	lowestY = points[0][0]
	secondLowestY = points[1][0]
	for point in points:
		point = point[0]
		if point[1] < lowestY[1]:
			secondLowestY = lowestY
			lowestY = point
		elif point[1] < secondLowestY[1]:
			secondLowestY = point
	return (lowestY, secondLowestY)
	
def pointDist(point1, point2):
	x1,y1 = point1
	x2,y2 = point2
	return math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2))

def findDistToGoal(tapeWidth):
	tapeHeight = tapeWidth * 0.7 # ratio from height to width is 14/20 (0.7)
	distance  = (REAL_TAPE_HEIGHT * ((IMG_HEIGHT/2)/(tapeHeight))) / math.tan(VERT_FOV/2.0)
	return math.log10(distance/61.223) / math.log10(1.0056) # function of error of dist formula

# true if facing forward relative to goal
def isFacingForward(bottomY1, bottomY2):
	return math.fabs(bottomY1[1] - bottomY2[1]) < 5;

# true if facing left relative to goal (robot needs to turn right to face goal)	
def isFacingLeft(bottomY1, bottomY2):
	if bottomY1[1] > bottomY2[1]:
		return bottomY1[0] < bottomY2[0]
	return bottomY1[0] > bottomY2[0]

# angle at which camera is facing goal	
def findLateralAngle(bottomY1, bottomY2):
	return math.degrees(math.asin(math.fabs(bottomY1[1] - bottomY2[1])/pointDist(bottomY1, bottomY2)))

# true if on midline of goal
def isOnMidline(rectX, rectWidth):
	return math.fabs(IMG_WIDTH/2 - (rectX + rectWidth/2)) < 10

# true if on right of midline	
def isOnRight(rectX, rectWidth):
	return (rectX + rectWidth/2) < IMG_WIDTH/2
	
def distFromMidline(bottomY1, bottomY2, topY1, topY2, dist):
	bottomLeft = bottomY1
	if bottomY2[0] < bottomY1[0]:
		bottomLeft = bottomY2
	topLeft = topY1
	if topY2[0] < topY1[0]:
		topLeft = topY2
	return dist * (math.fabs(bottomLeft[0] - topLeft[0]) / math.fabs(bottomLeft[1] - topLeft[1]))
		
findGoal()