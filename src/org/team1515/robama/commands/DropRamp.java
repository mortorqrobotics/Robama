package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DropRamp extends Command {
	
	//temporary values
	final double SPEED = 0.5;
	final int TIME = 500; //in milliseconds
	
	public DropRamp() {
		requires(Robot.ramp);
		setTimeout(TIME);
	}

	@Override
	protected void initialize() {
		Robot.ramp.drop(SPEED);
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		Robot.ramp.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
