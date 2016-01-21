package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DropBoulderRamp extends Command {
	
	double dropSpeed;
	int dropTime; //in milliseconds
	
	public DropBoulderRamp(double dropSpeed, int dropTime) {
		requires(Robot.shooter);
		this.dropSpeed = dropSpeed;
		this.dropTime = dropTime;
		setTimeout(dropTime);
	}

	@Override
	protected void initialize() {
		Robot.shooter.setDropSpeed(dropSpeed);
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
		Robot.shooter.stopDrop();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
