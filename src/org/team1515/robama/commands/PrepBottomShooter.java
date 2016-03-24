package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PrepBottomShooter extends Command {
	
	double speed;
	
	public PrepBottomShooter(double speed) {
		this.speed = speed;
		requires(Robot.bottomShooter);
	}

	@Override
	protected void initialize() {
		Robot.bottomShooter.setSpeed(speed);
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
		
	}

	@Override
	protected void interrupted() {
		end();
	}

}
