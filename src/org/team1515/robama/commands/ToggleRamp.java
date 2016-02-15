package org.team1515.robama.commands;

import org.team1515.robama.Robot;

public class ToggleRamp extends ActionCommand {	
	public ToggleRamp() {
		super(() -> {
			Robot.ramp.toggle();
		}, Robot.ramp);
	}
}
