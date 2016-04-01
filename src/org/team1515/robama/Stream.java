package org.team1515.robama;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ScalingMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

public class Stream extends Command {
	
	// see example: Intermediate Vision
	
	int session;
	Image frame;
	Map<Integer, List<Integer>> lines;
	
	static final int WIDTH = 640;
	static final int HEIGHT = 480;
	
	static final int TICK_HEIGHT = 2;
	static final int TICK_PERIOD = 6;
	
	final int DELAY = 100; // DELAY = 1000 / FPS
	final int SCALE = 8; // sizes of both axes are divided by this
	
	long lastUpdate;
	
	public Stream() {
		try {
	        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	        session = NIVision.IMAQdxOpenCamera("cam0",
	        		NIVision.IMAQdxCameraControlMode.CameraControlModeController);
	        NIVision.IMAQdxConfigureGrab(session);
	        
	        lines = new HashMap<Integer, List<Integer>>();
	        lines.put(10, Arrays.asList(255, 0, 0));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	protected void initialize() {
		try {
	        NIVision.IMAQdxStartAcquisition(session);
	        lastUpdate = System.currentTimeMillis();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	protected void execute() {
		try {
			long now = System.currentTimeMillis();
			if (now - lastUpdate >= DELAY) {
				lastUpdate += DELAY;
	            NIVision.IMAQdxGrab(session, frame, 1);
	            
	            NIVision.Rect rect = new NIVision.Rect(0, 0, HEIGHT, WIDTH);
	            NIVision.imaqScale(frame, frame, SCALE, SCALE, ScalingMode.SCALE_SMALLER, rect);
	            
//	            int width = WIDTH / SCALE;
//	            int height = HEIGHT / SCALE;
//	            
//	            for (Integer x : lines.keySet()) {
//	            	for (int i = 0; i < height / TICK_PERIOD; i++) {
//	            		int y = i * TICK_PERIOD;
//	            		NIVision.Rect rect1 = new NIVision.Rect(y, x, TICK_HEIGHT, 1);
//	            		NIVision.Rect rect2 = new NIVision.Rect(y, width - x - 1, TICK_HEIGHT, 1);
//	            		NIVision.imaqDrawShapeOnImage(frame, frame, rect1,
//	            				DrawMode.DRAW_VALUE, ShapeMode.SHAPE_RECT, getColor(lines.get(x)));
//	            		NIVision.imaqDrawShapeOnImage(frame, frame, rect2,
//	            				DrawMode.DRAW_VALUE, ShapeMode.SHAPE_RECT, getColor(lines.get(x)));
//	            	}
//	            }
	            
	            CameraServer.getInstance().setImage(frame);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		try {
			NIVision.IMAQdxStopAcquisition(session);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	protected void interrupted() {
		end();
	}
	
//	private int getColor(List<Integer> nums) {
//		return nums.get(0) * 256 * 256 + nums.get(1) * 256 + nums.get(2);
//	}

}
