package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
	
	private double speed;

	public Shoot(double speed) {
		requires(Robot.topShooter);
		requires(Robot.bottomShooter);
		requires(Robot.intake);
		this.speed = speed;
	}
	
	@Override
	protected void initialize() {
		Robot.topShooter.setSpeed(speed);
		Robot.bottomShooter.setSpeed(speed);
		Robot.intake.intake();		
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
		Robot.bottomShooter.stop();
		Robot.intake.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
