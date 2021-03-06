package org.team1515.robama.subsystems;

import org.team1515.robama.Config;
import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Wedge extends Subsystem {
	
	MotorModule motor; // positive up, negative down
//	DigitalInput highLimitSwitch; // false when down
//	DigitalInput lowLimitSwitch; // true when up
	
	public Wedge() {
		motor = new MotorModule(RobotMap.WEDGE_MOTORS);
//		highLimitSwitch = new DigitalInput(RobotMap.WEDGE_HIGH_LIMIT_SWITCH);
//		lowLimitSwitch = new DigitalInput(RobotMap.WEDGE_LOW_LIMIT_SWITCH);
		Config.setDefault("wedgePower", 0.5);
	}
	
	private void setMotor(double speed) {
		motor.setSpeed(speed);
	}
	
	public void moveDown() {
//		if(!lowLimitSwitch.get()) {
			setMotor(-Config.getDouble("wedgePower"));
//		}
	}
	
	public void moveUp() {
//		if(highLimitSwitch.get()) {
			setMotor(Config.getDouble("wedgePower"));
//		}
	}
	
	public void stop() {
		motor.stop();
	}
	
	public void increasePower(double amount) {
		Config.setDouble("wedgePower", Config.getDouble("wedgePower") + amount);
	}

	protected void initDefaultCommand() {

	}

}
