package org.team1515.robama.commands.align;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GyroAlign extends AlignCommand {
	
	static final double SPEED = 0.3;
	
	double gyroStartAngle;
	
	public GyroAlign(double targetAngle) {
		super(targetAngle);
	}

	@Override
	protected void initialize() {
		double sign = Math.signum(targetAngle);
		Robot.driveTrain.setSpeed(sign * SPEED, -sign * SPEED); // this was wrong
		gyroStartAngle = Robot.gyro.getAngle();
		SmartDashboard.putBoolean("aligning", true);
	}
	
	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(Robot.gyro.getAngle() - gyroStartAngle) >= Math.abs(targetAngle);
	}

	@Override
	protected void end() {
		Robot.driveTrain.stop();
		SmartDashboard.putBoolean("aligning", false);
	}

}
