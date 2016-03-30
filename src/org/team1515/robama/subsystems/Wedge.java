package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Wedge extends Subsystem {
	
	MotorModule motor;
//	DigitalInput highLimitSwitch; // false when down
//	DigitalInput lowLimitSwitch; // true when up
	
	final double SPEED_UP = 0.3;
	final double SPEED_DOWN = 0.3;
	
	public Wedge() {
		motor = new MotorModule(RobotMap.WEDGE_MOTORS);
//		highLimitSwitch = new DigitalInput(RobotMap.WEDGE_HIGH_LIMIT_SWITCH);
//		lowLimitSwitch = new DigitalInput(RobotMap.WEDGE_LOW_LIMIT_SWITCH);
	}
	
	public void moveDown() {
//		if(!lowLimitSwitch.get()) {
			motor.setSpeed(-SPEED_DOWN);
//		}
	}
	
	public void moveUp() {
//		if(highLimitSwitch.get()) {
			motor.setSpeed(SPEED_UP);
//		}
	}
	
	public void stop() {
		motor.stop();
	}

	protected void initDefaultCommand() {

	}

}
