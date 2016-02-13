package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DropRamp extends Command {
	
	//temporary values
	static final int TIME = 500; //in milliseconds
	
	public DropRamp() {
		setTimeout(TIME);
		requires(Robot.ramp);
	}

	protected void initialize() {
		Robot.ramp.drop();
	}

	protected void execute() {

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
