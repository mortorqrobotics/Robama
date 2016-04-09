package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BottomShooter extends Subsystem {
	
	private MotorModule motor; // positive in, negative out
//	private InternalEncoder encoder;
//	private PIDController ratePID;
		
	public BottomShooter() {
		motor = new MotorModule(RobotMap.BOTTOM_SHOOTER_MOTORS);
//		encoder = new InternalEncoder(motor);
//		pid = new PIDController(0.000003, 0, 0.00001, 30000, encoder, motor);
	}
	
//	private void setSpeed(double speed) {
//		ratePID.setSetpoint(speed);
//	}
	
	private void setMotor(double speed) {
		motor.setSpeed(speed);
	}
	
	public void stop() {
//		pid.disable(); // sets speed to 0
		motor.stop();
	}
	
	public void shoot() {
//		setSpeed(1);
		setMotor(1);
	}
	
	public void purge(double speed) {
		setMotor(-speed);
	}
	
	public void purge() {
		purge(1);
	}
	
//	public double getEncoder() {
//		return encoder.get();
//	}
	
	protected void initDefaultCommand() {
		
	}

}
