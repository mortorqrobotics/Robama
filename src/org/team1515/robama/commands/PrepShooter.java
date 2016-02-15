package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PrepShooter extends Command {

	private double speed;
	
	public PrepShooter(double speed) {
		this.speed = speed;
		requires(Robot.shooter);
	}
	
	@Override
	protected void initialize() {
		Robot.shooter.setTop(speed);
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
		Robot.shooter.stopTop();
	}

	@Override
	protected void interrupted() {
		end();		
	}

}
