package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardAuto extends Command {
	
	private static final double SPEED = 1;
	
	public DriveForwardAuto() {
		requires(Robot.driveTrain);
		setTimeout(2);
	}

	protected void initialize() {
		Robot.driveTrain.setSpeed(SPEED, SPEED);
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
		Robot.driveTrain.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}