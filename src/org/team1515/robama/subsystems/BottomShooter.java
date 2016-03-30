package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BottomShooter extends Subsystem {
	
	private MotorModule motor; // positive in, negative out
//	private RatePID ratePID;
		
	public BottomShooter() {
		motor = new MotorModule(RobotMap.BOTTOM_SHOOTER_MOTORS);
//		ratePID = new RatePID(motor, new InternalEncoder(motor), 0.000003, 0, 0.00001, 30000);
	}
	
//	private void setSpeed(double speed) {
//		ratePID.setSetpoint(speed);
//	}
	
	private void setMotor(double speed) {
		motor.setSpeed(speed);
	}
	
	public void stop() {
//		ratePID.disable(); // sets speed to 0
		setMotor(0);
	}
	
	public void shoot() {
//		setSpeed(1);
		setMotor(0);
	}
	
	public void purge(double speed) {
		setMotor(-speed);
	}
	
	public void purge() {
		purge(1);
	}
	
//	public double getEncoder() {
//		return ratePID.getInput();
//	}
	
	protected void initDefaultCommand() {
		
	}

}
