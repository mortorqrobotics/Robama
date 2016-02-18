package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	private MotorModule intakeMotor;
	private final double SPEED = 1;
	
	public Intake() {
		intakeMotor = new MotorModule(RobotMap.INTAKE_MOTORS);
	}
	
	public void intake() {
		intakeMotor.setSpeed(-SPEED);
	}
	
	public void reverse() {
		intakeMotor.setSpeed(SPEED);
	}
	
	public void stop() {
		intakeMotor.setSpeed(0);
	}
	
	protected void initDefaultCommand() {
		
	}

}
