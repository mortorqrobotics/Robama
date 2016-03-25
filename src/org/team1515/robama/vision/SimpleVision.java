package org.team1515.robama.vision;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

public class SimpleVision {
	
	final static double HORIZONTAL_FOV = Math.toRadians(53 * 2);
	final static double IMG_WIDTH = 640;
	final static double IMG_HEIGHT = 480;
	
	VideoCapture camera;
	
	public SimpleVision() {
		System.load("/usr/local/lib/libopencv_java310.so");
		System.out.println("Welcome to OpenCV " + Core.VERSION);
		camera = new VideoCapture();
		camera.set(15, -24); // 15 should be exposure
		camera.open(0);
	}
	
	public double getAngle() {
		Mat frame = new Mat();
		camera.read(frame);
		Scalar minColor = new Scalar(0, 100, 0);
		Scalar maxColor = new Scalar(255, 255, 255);
		Core.inRange(frame, minColor, maxColor, frame);
		List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
		Imgproc.findContours(frame, contours, new Mat(), Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_SIMPLE);
		
		Rect goal = Imgproc.boundingRect(contours.get(0));
		for(int i = 1; i < contours.size(); i++) {
			Rect bounds = Imgproc.boundingRect(contours.get(i));
			if(bounds.width > goal.width) {
				goal = bounds;
			}
		}
		
		double middleX = goal.x + goal.width / 2.0;
		double xChange = middleX - IMG_WIDTH / 2.0;
		double angle = Math.atan(xChange / IMG_WIDTH * 2.0 * Math.tan(HORIZONTAL_FOV / 2));
		
		return angle;
	}

}
