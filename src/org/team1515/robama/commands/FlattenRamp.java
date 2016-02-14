package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class FlattenRamp extends ActionCommand {
	public FlattenRamp() {
		super(() -> {
			Robot.ramp.flatten();
		}, Robot.ramp);
	}
}
