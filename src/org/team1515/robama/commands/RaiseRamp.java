package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseRamp extends Command {
	
	//temporary values
	final double SPEED = 0.5;
	final int TIME = 500; //in milliseconds
	
	public RaiseRamp() {
		requires(Robot.ramp);
		setTimeout(TIME);
	}

	@Override
	protected void initialize() {
		Robot.ramp.raise(SPEED);
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
