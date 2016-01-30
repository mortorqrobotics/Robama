package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BoulderRamp extends Subsystem {
	
	private MotorModule rampMotor;
	
	private static final double DROP_SPEED = 1;
	private static final double RAISE_SPEED = 1;
	
	private final int MAX_RAMP_DROP = 100; //temp
	
	public BoulderRamp() {
		rampMotor = new MotorModule(RobotMap.RAMP_ENCODER, RobotMap.RAMP_MOTORS);
	}
	
	public void drop() {
		rampMotor.setSpeed(DROP_SPEED);
	}
	
	public void raise() {
		rampMotor.setSpeed(-RAISE_SPEED);
	}
	
	public void stop() {
		rampMotor.setSpeed(0);
	}
	
	protected void initDefaultCommand() {
		
	}

}
