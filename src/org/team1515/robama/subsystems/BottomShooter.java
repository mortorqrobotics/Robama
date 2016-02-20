package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BottomShooter extends Subsystem {
	
	private MotorModule motor;
		
	public BottomShooter() {
//		motor = new InternalPIDMotorModule(RobotMap.TOP_SHOOTER_MOTOR, 36000, PIDSourceType.kRate, 0, 0, 0);
		motor = new MotorModule(new int[] {RobotMap.BOTTOM_SHOOTER_MOTOR});
	}

	public void setSpeed(double speed) {
		motor.setSpeed(speed);
	}
	
	public void stop() {
		setSpeed(0);
	}
	
	protected void initDefaultCommand() {
		
	}

}
