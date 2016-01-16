package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
	
	private double speed;

	public Shoot(double speed) {
		this.speed = speed;
	}
	
	@Override
	protected void initialize() {
		requires(Robot.shooter);
	}

	@Override
	protected void execute() {
		Robot.shooter.setSpeed(speed);
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.shooter.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
