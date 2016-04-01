package org.team1515.robama.vision;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public abstract class VisionModule {
	
	// Load opencv library once
	static {
		System.load("/usr/local/lib/libopencv_java310.so");
	}
	
	VideoCapture camera;
	
	public VisionModule(int index) {
		camera = new VideoCapture(index);
	}
	
	public Mat getFrame() {
		
	}
}
