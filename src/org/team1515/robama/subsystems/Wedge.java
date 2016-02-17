package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Wedge extends Subsystem {
	
	MotorModule motor;
	
	final double SPEED = 1;
	
	public Wedge() {
		motor = new MotorModule(RobotMap.WEDGE_MOTORS);
	}
	
	public void moveDown() {
		motor.setSpeed(-SPEED);
	}
	
	public void moveUp() {
		motor.setSpeed(SPEED);
	}
	
	public void stop() {
		motor.stop();
	}

	protected void initDefaultCommand() {

	}

}
