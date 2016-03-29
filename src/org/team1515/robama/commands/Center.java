package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		direction = getDirection(startAngle); // -1 right, 1 left
		Robot.driveTrain.setSpeed(direction * SPEED, -direction * SPEED);
		SmartDashboard.putBoolean("aligning", true);
	}

	@Override
	protected void execute() {
		System.out.println(Robot.gyro.getAngle() + " " + ((Robot.gyro.getAngle() + 360 * 100) % 360));
	}

	@Override
	protected boolean isFinished() {
		return getDirection(Robot.gyro.getAngle()) != direction;
	}

	@Override
	protected void end() {
		Robot.driveTrain.stop();
		SmartDashboard.putBoolean("aligning", false);
	}

	@Override
	protected void interrupted() {
		end();
	}
	
	private double getDirection(double angle) {
		return Math.signum((angle % 360 + 360) % 360 - 180);
	}

}
