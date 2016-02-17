package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WedgeDown extends Command {
	
	public WedgeDown() {
		requires(Robot.wedge);
	}

	protected void initialize() {
		Robot.wedge.moveDown();
	}

	protected void execute() {

	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.wedge.stop();
	}

	protected void interrupted() {
		end();
	}

}
