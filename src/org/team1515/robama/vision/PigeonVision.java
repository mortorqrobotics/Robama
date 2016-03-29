package org.team1515.robama.vision;

public class PigeonVision {
	
//	final static double VERT_FOV = Math.toRadians(44.44);
//	final static double REAL_TAPE_HEIGHT = 14; // inches of real tape height
//	final static double IMG_HEIGHT = 480; // pixels of image resolution
//	final static double IMG_WIDTH = 640; // pixels of image resolution
//	
//	VideoCapture camera;
//	
//	public PigeonVision() {
//		System.load("/usr/local/lib/libopencv_java310.so");
//		System.out.println("Welcome to OpenCV " + Core.VERSION);
//		camera = new VideoCapture();
//		camera.open(0);
//	}
//	
//	private Mat getImg() {
//		Mat frame = new Mat();
//		camera.read(frame);
//		return frame;
//	}
//	
//	public Mat getDriverStationImg() {
//		Mat resized = new Mat();
//		Imgproc.resize(getImg(), resized, new Size(IMG_WIDTH/2, IMG_HEIGHT/2));
//		Imgproc.cvtColor(resized, resized, Imgproc.COLOR_BGR2GRAY);
//		return resized;
//	}
//	
//	public void findGoal() {
//		long time = System.currentTimeMillis();
////		Mat frame = getImg();
//		Mat frame = Imgcodecs.imread("/goal.png");
//		
//		BGR2HSV(frame);
//		reduceNoise(frame);
////		Imgcodecs.imwrite("converted.png", frame);
//		
//		tapeHSVThreshold(frame);
////		Imgcodecs.imwrite("cancelcolors.png", frame);
//		
//		List<MatOfPoint> contours = findContours(frame);
//		contours = filterContours(contours);
//		
//		if(contours.size() > 0) {
//			MatOfPoint goalContour = findGoalContour(contours);
//			Rect goalRect = Imgproc.boundingRect(goalContour);
//			MatOfPoint2f points2f = approxPoly(goalContour);
//			Point[] bottomY = findBottomY(points2f.toArray());
//			Point[] topY = findTopY(points2f.toArray());
//			
//			double distToGoal = findDistToGoal(goalRect.width, 31);
//			System.out.println("dist: " + distToGoal);
//			
//			if(isFacingForward(bottomY)) {
//				System.out.println("facing forward");
//			} else {
//				System.out.println("isFacingLeft: " + isFacingLeft(bottomY));
//				System.out.println("lat angle: " + findLateralAngle(bottomY));
//			}
//			
//			if(isOnMidline(goalRect)) {
//				System.out.println("on midline");
//			} else {
//				 System.out.println("isOnRight: " + isOnRight(goalRect));
//				 System.out.println("distFromMidline: " + distFromMidline(bottomY, topY, distToGoal));
//			}
//		}
//		System.out.println(System.currentTimeMillis() - time);
//	}
//	
//	private void BGR2HSV(Mat input) {
//		Imgproc.cvtColor(input, input, Imgproc.COLOR_BGR2HSV);
//	}
//	
//	private void BGR2HLS(Mat input) {
//		Imgproc.cvtColor(input, input, Imgproc.COLOR_BGR2HLS);
//	}
//	
//	private void reduceNoise(Mat input) {
//		Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(5, 5));
//		
//		Imgproc.erode(input, input, element);
//		Imgproc.dilate(input, input, element);
//		Imgproc.blur(input, input, new Size(5,5));
//	}
//	
//	// scalar params: H(0-180), S(0-255), V(0-255)
//	private void tapeHSVThreshold(Mat input) {
//		Core.inRange(input, new Scalar(60, 0, 240), new Scalar(95, 255, 255), input);
//	}
//	
//	// scalar params: H(0-180), L(0-255), S(0-255)
//	private void tapeHLSThreshold(Mat input) {
//		//For Hue, 60 - 95 is the green range
//		//For Luminance, 140 - 255 should be the range if a flashlight is flashing on the tape
//		Core.inRange(input, new Scalar(60, 140, 170), new Scalar(95, 255, 255), input);
//	}
//	
//	private List<MatOfPoint> findContours(Mat image) {
//		List<MatOfPoint> contours = new ArrayList<>();
//		Imgproc.findContours(image, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
//		return contours;
//	}
//	
//	private List<MatOfPoint> filterContours(List<MatOfPoint> contours) {
//		List<MatOfPoint> newContours = new ArrayList<MatOfPoint>();
//		for(int i = 0; i < contours.size(); i++) {
//			Rect rect = Imgproc.boundingRect(contours.get(i));
//			if(rect.width > 80 && rect.width < 200 
//					&& rect.height > 30 && rect.height < 100
//					&& rect.y < 400) {
////				MatOfPoint2f point2f = approxPoly(contours.get(i));
////				if(point2f.toList().size() >= 7 && point2f.toList().size() <= 9) {
//					newContours.add(contours.get(i));
////				}
//			}
//		}
//		return newContours;
//	}
//	
//	private MatOfPoint findGoalContour(List<MatOfPoint> contours) {
//		List<Rect> rects = new ArrayList<Rect>();
//		rects.add(Imgproc.boundingRect(contours.get(0)));
//		int lrgstRectIndx = 0;
//		for(int i = 1; i < contours.size(); i++) {
//			Rect rect = Imgproc.boundingRect(contours.get(i));
//			rects.add(rect);
//			if(rect.width > rects.get(lrgstRectIndx).width) {
//				lrgstRectIndx = i;
//			}
//		}
//		return contours.get(lrgstRectIndx);
//	}
//	
//	// find approximate point vertices of contoured goal tape
//	private MatOfPoint2f approxPoly(MatOfPoint contour) {
//		MatOfPoint2f point2f = new MatOfPoint2f();
//		point2f.fromList(contour.toList());
//		Imgproc.approxPolyDP(point2f, point2f, 5.0, true); //third parameter: smaller->more points
//		return point2f;
//	} 
//	
//	// finds bottom vertices of goal tape
//	private Point[] findBottomY(Point[] points) {
//		Point highestY = points[0];
//		Point secondHighestY = points[1];
//		for(int i = 2; i < points.length; i++) {
//			if(points[i].y > highestY.y) {
//				secondHighestY = highestY;
//				highestY = points[i];
//			}
//			else if(points[i].y > secondHighestY.y) {
//				secondHighestY = points[i];
//			}
//		}
//		Point[] highestYCoords = {highestY, secondHighestY};
//		return highestYCoords;
//	}
//	
//	private Point[] findTopY(Point[] points) {
//		Point lowestY = points[0];
//		Point secondLowestY = points[1];
//		for(int i = 2; i < points.length; i++) {
//			if(points[i].y < lowestY.y) {
//				secondLowestY = lowestY;
//				lowestY = points[i];
//			}
//			else if(points[i].y < secondLowestY.y) {
//				secondLowestY = points[i];
//			}
//		}
//		Point[] lowestYCoords = {lowestY, secondLowestY};
//		return lowestYCoords;
//	}
//	
//	private double pointDist(Point[] points) {
//		double dist = Math.sqrt((points[0].x - points[1].x)*(points[0].x - points[1].x) + (points[0].y - points[1].y)*(points[0].y - points[1].y));
//		return dist;
//	}
//	
//	private double findDistToGoal(double tapeWidth, double camAngle) {
//		camAngle = Math.toRadians(camAngle);
//		double tapeHeight = tapeWidth * 0.7; //ratio from height to width is 14/20 (0.7)
//		double distance = (REAL_TAPE_HEIGHT * ((IMG_HEIGHT/2)/(tapeHeight))) / Math.tan(VERT_FOV/2.0); //Dylan's first dist formula
////		double distance = (REAL_TAPE_HEIGHT * ((((VERT_FOV/2 + camAngle)/VERT_FOV) * IMG_HEIGHT)/tapeHeight)) / Math.tan(VERT_FOV/2 + camAngle); //our dist formula
//		double distError = Math.log10(distance/61.223) / Math.log10(1.0056); //power function of error of first distance formula
//		return distError;
//	}
//	
//	// facing forward relative to closest goal
//	private boolean isFacingForward(Point[] points) {
//		return Math.abs(points[0].y - points[1].y) < 5;
//	}
//	
//	// if true then robot turns right to face goal straight on
//	private boolean isFacingLeft(Point[] points) {
//		if(points[0].y > points[1].y) {
//			return points[0].x < points[1].x;
//		}
//		return points[0].x > points[1].x;
//	}
//	
//	// finds angle at which camera is facing the goal
//	private double findLateralAngle(Point[] points) {
//		double angle = Math.toDegrees(Math.asin(Math.abs(points[0].y - points[1].y)/pointDist(points)));
//		return angle;
//	}
//	
//	// midline of the closest goal
//	private boolean isOnMidline(Rect rect) {
//		return Math.abs(IMG_WIDTH/2 - (rect.x + rect.width/2)) < 10;
//	}
//	
//	// if true then robot is on right of midline
//	private boolean isOnRight(Rect rect) {
//		return (rect.x + rect.width/2) < IMG_WIDTH/2;
//	}
//	
//	private double distFromMidline(Point[] bottomY, Point[] topY, double dist) {
//		Point bottomLeft = bottomY[0];
//		if(bottomY[1].x < bottomY[0].x) {
//			bottomLeft = bottomY[1];
//		}
//		Point topLeft = topY[0];
//		if(topY[1].x < topY[0].x) {
//			topLeft = topY[1];
//		}
//		return dist * (Math.abs(bottomLeft.x - topLeft.x) / Math.abs(bottomLeft.y - topLeft.y));
//	}
}
