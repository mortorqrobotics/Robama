package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	private MotorModule motor; // positive out, negative in
	
	private final double SPEED = 1;
	
	public Intake() {
		motor = new MotorModule(RobotMap.INTAKE_MOTORS);
	}
	
	private void setMotor(double speed) {
		motor.setSpeed(speed);
	}
	
	public void intake() {
		setMotor(-SPEED);
	}
	
	public void purge(double speed) {
		setMotor(speed);
	}
	
	public void purge() {
		purge(SPEED);
	}
	
	public void stop() {
		setMotor(0);
	}
	
	protected void initDefaultCommand() {
		
	}

}
