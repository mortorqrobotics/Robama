package org.team1515.robama.commands;

import org.team1515.robama.Robot;

public class ReverseDrive extends ActionCommand {	
	
	public ReverseDrive() {
		super(() -> {
			Robot.driveTrain.reverse();
		});
	}
	
}