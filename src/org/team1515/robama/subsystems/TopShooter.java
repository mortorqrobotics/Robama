package org.team1515.robama.subsystems;

import org.team1515.robama.Config;
import org.team1515.robama.RobotMap;
import org.team1515.robama.subsystems.pid.InternalEncoder;
import org.team1515.robama.subsystems.pid.RatePID;

import edu.wpi.first.wpilibj.command.Subsystem;

public class TopShooter extends Subsystem {
	
	private MotorModule motor;
	private RatePID ratePID;
	private boolean prePrepping;
		
	public TopShooter() {
		motor = new MotorModule(RobotMap.TOP_SHOOTER_MOTORS);
		ratePID = new RatePID(motor, new InternalEncoder(motor, true), 0.00001, 0, 0.00008, 30000);
		prePrepping = false;
		
		Config.setDefault("prePrepSpeed", 0.25);
	}

	public void setSpeed(double speed) {
		ratePID.setSetpoint(-speed);
//		motor.setSpeed(speed);
	}
	
	public double getSetpoint() {
		return -ratePID.getSetpoint();
	}
	
	public void stop() {
		ratePID.disable();
//		setSpeed(0);
		prePrepping = false;
	}
	
	public void togglePrePrep() {
		prePrepping = !prePrepping;
		if(prePrepping) {
			setMotor(Config.getDouble("prePrepSpeed"));
		}
		else {
			setMotor(0);
		}
	}

	public void setMotor(double speed) {
		motor.setSpeed(-speed);
	}
	
	public double getEncoder() {
		return -ratePID.getInput();
	}
	
	public void setPIDFactor(double factor) {
		ratePID.setFactor(factor);
	}
	
	protected void initDefaultCommand() {
		
	}

}
