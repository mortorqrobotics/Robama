package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardAuto extends Command {
	
	double speed;
	private static final double SPEED = 1;
	
	public DriveForwardAuto(double speed) {
		requires(Robot.driveTrain);
		this.speed = speed;
	}
	
	public DriveForwardAuto(double speed, double time) {
		this(speed);
		setTimeout(time);
	}

	protected void initialize() {
		Robot.driveTrain.setSpeed(speed, speed);
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