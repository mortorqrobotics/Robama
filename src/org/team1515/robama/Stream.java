package org.team1515.robama;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ImageInfo;
import com.ni.vision.NIVision.ScalingMode;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

public class Stream extends Command {
	
	// see example: Intermediate Vision
	
	int session;
	Image frame;
	Map<Integer, Color> lines;
	
	static final int TICK_HEIGHT = 2;
	static final int TICK_PERIOD = 6;
	
	final int DELAY = 100; // DELAY = 1000 / FPS
	final int SCALE = 8; // sizes of both axes are divided by this
	
	long lastUpdate;
	
	public Stream() {
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        
        lines = new HashMap<Integer, Color>();
        lines.put(10, Color.RED);
	}

	@Override
	protected void initialize() {
        session = NIVision.IMAQdxOpenCamera("cam0",
        		NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
        lastUpdate = System.currentTimeMillis();
	}

	@Override
	protected void execute() {
		long now = System.currentTimeMillis();
		if (now - lastUpdate >= DELAY) {
			lastUpdate += DELAY;
            NIVision.IMAQdxGrab(session, frame, 1);
            ImageInfo info = NIVision.imaqGetImageInfo(frame);
            int width = info.xRes;
            int height = info.yRes;
            
            NIVision.Rect rect = new NIVision.Rect(0, 0, info.xRes, info.yRes);
            NIVision.imaqScale(frame, frame, SCALE, SCALE, ScalingMode.SCALE_SMALLER, rect);
            
            for (Integer x : lines.keySet()) {
            	for (int i = 0; i < height / TICK_PERIOD; i++) {
            		int y = i * TICK_PERIOD;
            		NIVision.Rect rect1 = new NIVision.Rect(x, y, x + 1, y + TICK_HEIGHT);
            		NIVision.Rect rect2 = new NIVision.Rect(width - x - 1, y, width - x, y + TICK_HEIGHT);
            		NIVision.imaqDrawShapeOnImage(frame, frame, rect1,
            				DrawMode.DRAW_VALUE, ShapeMode.SHAPE_RECT, lines.get(x).getRGB());
            		NIVision.imaqDrawShapeOnImage(frame, frame, rect2,
            				DrawMode.DRAW_VALUE, ShapeMode.SHAPE_RECT, lines.get(x).getRGB());
            	}
            }
            
            CameraServer.getInstance().setImage(frame);
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
        NIVision.IMAQdxStopAcquisition(session);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
