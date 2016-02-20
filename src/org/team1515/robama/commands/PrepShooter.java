package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PrepShooter extends Command {

	private double speed;
	
	public PrepShooter(double speed) {
		this.speed = speed;
		requires(Robot.topShooter);
	}
	
	@Override
	protected void initialize() {
		Robot.topShooter.setSpeed(speed);
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
		Robot.topShooter.stop();
	}

	@Override
	protected void interrupted() {
//		end();		
	}

}
