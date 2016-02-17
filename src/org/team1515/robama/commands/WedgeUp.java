package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WedgeUp extends Command {
	
	public WedgeUp() {
		requires(Robot.wedge);
	}

	protected void initialize() {
		Robot.wedge.moveUp();
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
