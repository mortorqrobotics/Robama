package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Center extends Command {
	
	double startAngle;
	double direction;
	
	static final double SPEED = 0.3;

	public Center() {
		requires(Robot.driveTrain);
	}
	
	@Override
	protected void initialize() {
		startAngle = Robot.gyro.getAngle();
		direction = Math.signum((startAngle + 360) % 360 - 180);
		Robot.driveTrain.setSpeed(direction * SPEED, -direction * SPEED);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() {
		return Math.signum(Robot.gyro.getAngle()) != direction;
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
