package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;
import org.team1515.robama.subsystems.pid.InternalEncoder;
import org.team1515.robama.subsystems.pid.RatePID;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BottomShooter extends Subsystem {
	
	private MotorModule motor;
	private RatePID ratePID;
		
	public BottomShooter() {
		motor = new MotorModule(RobotMap.BOTTOM_SHOOTER_MOTORS);
		ratePID = new RatePID(motor, new InternalEncoder(motor), 0.000003, 0, 0.00001, 30000);
	}

	public void setSpeed(double speed) {
		ratePID.setSetpoint(speed);
//		motor.setSpeed(speed);
	}
	
	public void stop() {
		ratePID.disable();
//		setSpeed(0);
	}
	
	public void setMotor(double speed) {
		motor.setSpeed(speed);
	}
	
	public double getEncoder() {
		return ratePID.getInput();
	}
	
	protected void initDefaultCommand() {
		
	}

}
