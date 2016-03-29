package org.team1515.robama;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ImageInfo;
import com.ni.vision.NIVision.ScalingMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

public class Stream extends Command {
	
	// see example: Intermediate Vision
	
	int session;
	Image frame;
	
	final int DELAY = 100; // DELAY = 1000 / FPS
	final int SCALE = 8; // sizes of both axes are divided by this
	
	long lastUpdate;
	
	public Stream() {
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
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
		if(now - lastUpdate >= DELAY) {
			lastUpdate += DELAY;
            NIVision.IMAQdxGrab(session, frame, 1);
            ImageInfo info = NIVision.imaqGetImageInfo(frame);
            NIVision.Rect rect = new NIVision.Rect(0, 0, info.xRes, info.yRes);
            NIVision.imaqScale(frame, frame, SCALE, SCALE, ScalingMode.SCALE_SMALLER, rect);
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
