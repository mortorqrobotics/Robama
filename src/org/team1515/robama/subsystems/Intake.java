package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	private MotorModule intakeMotor;
	
	public Intake() {
		intakeMotor = new MotorModule(RobotMap.INTAKE_ENCODER, RobotMap.INTAKE_MOTORS);
	}
	
	public void setSpeed(double speed) {
		intakeMotor.setSpeed(speed);
	}
	
	public void stop() {
		setSpeed(0);
	}
	
	protected void initDefaultCommand() {
		
	}

}
