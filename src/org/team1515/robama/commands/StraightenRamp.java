package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StraightenRamp extends Command {
	
	public StraightenRamp() {
		requires(Robot.ramp);
	}

	protected void initialize() {
		
	}

	protected void execute() {
		Robot.ramp.straighten();
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.ramp.stop();
	}

	protected void interrupted() {
		end();
	}
	
}
