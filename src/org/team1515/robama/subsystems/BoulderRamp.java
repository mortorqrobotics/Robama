package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BoulderRamp extends Subsystem {
	
	private MotorModule rampMotor;
	
	private final int MAX_RAMP_DROP = 100; //temp
	
	public BoulderRamp() {
		rampMotor = new MotorModule(RobotMap.RAMP_ENCODER, RobotMap.RAMP_MOTORS);
	}
	
	private void setSpeed(double speed) {
		rampMotor.setSpeed(speed);
	}
	
	public void drop(double speed) {
		setSpeed(speed);
	}
	
	public void raise(double speed) {
		setSpeed(-speed);
	}
	
	public void stop() {
		setSpeed(0);
	}
	
	protected void initDefaultCommand() {
		
	}

}
