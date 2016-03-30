package org.team1515.robama.subsystems;

import org.team1515.robama.Config;
import org.team1515.robama.RobotMap;
import org.team1515.robama.subsystems.pid.InternalEncoder;
import org.team1515.robama.subsystems.pid.RatePID;

import edu.wpi.first.wpilibj.command.Subsystem;

public class TopShooter extends Subsystem {
	
	private MotorModule motor; // positive in, negative out
	private RatePID ratePID;
	
	private static final double PID_FACTOR = 30000;
		
	public TopShooter() {
		motor = new MotorModule(RobotMap.TOP_SHOOTER_MOTORS);
		ratePID = new RatePID(motor, new InternalEncoder(motor, true), 0.00001, 0, 0.00008, PID_FACTOR);
		
		Config.setDefault("shootPower", 14);
	}

	private void setSpeed(double speed) {
		ratePID.setSetpoint(-speed);
	}
	
	public void stop() {
		ratePID.disable();
	}
	
	public double getEncoder() {
		return -ratePID.getInput();
	}
	
	public void increaseShootPower(double amount) {
		Config.setDouble("shootPower", Config.getDouble("shootPower") + amount);
	}
	
	public void shoot() {
		setSpeed(Config.getDouble("shootPower") * 1000 / PID_FACTOR);
	}
	
	protected void initDefaultCommand() {
	
	}

}
