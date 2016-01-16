package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	
	private MotorModule leftMotor;
	private MotorModule rightMotor;
	
	public Shooter() {
		leftMotor = new MotorModule(RobotMap.LEFT_SHOOTER_ECODER, RobotMap.LEFT_SHOOTER_MOTORS, false);
		rightMotor = new MotorModule(RobotMap.RIGHT_SHOOTER_ENCODER, RobotMap.RIGHT_DRIVE_MOTORS, false);
	}
	
	public void setSpeed(double speed) {
		leftMotor.setSpeed(speed);
		rightMotor.setSpeed(-speed);
	}
	
	public void stop() {
		setSpeed(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
