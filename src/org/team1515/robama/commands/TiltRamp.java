package org.team1515.robama.commands;

import org.team1515.robama.Robot;

public class TiltRamp extends ActionCommand {	
	public TiltRamp() {
		super(() -> {
			Robot.ramp.tilt();
			System.out.println("tilt");
		}, Robot.ramp);
	}
}
