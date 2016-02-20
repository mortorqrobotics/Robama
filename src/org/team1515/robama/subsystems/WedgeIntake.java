package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class WedgeIntake extends Subsystem {
	
	private MotorModule motor;
	
	public WedgeIntake() {
		this.motor = new MotorModule(RobotMap.WEDGE_INTAKE_MOTORS);
	}
	
	public void intake() {
		motor.setSpeed(1);
	}
	
	public void stop() {
		motor.stop();
	}

	protected void initDefaultCommand() {

	}

}
