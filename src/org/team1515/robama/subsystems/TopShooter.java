package org.team1515.robama.subsystems;

import org.team1515.robama.Config;
import org.team1515.robama.RobotMap;
import org.team1515.robama.subsystems.pid.InternalEncoder;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TopShooter extends Subsystem {
	
	private MotorModule motor; // positive in, negative out
	private InternalEncoder encoder;
	private PIDController pid;
	
	private static final double PID_FACTOR = 30000;
		
	public TopShooter() {
		motor = new MotorModule(RobotMap.TOP_SHOOTER_MOTORS);
		encoder = new InternalEncoder(motor, true);
		encoder.setPIDSourceType(PIDSourceType.kRate);
		pid = new PIDController(0.00001, 0, 0.00008, encoder, motor);
		
		Config.setDefault("shootPower", 24);
	}

	private void setSpeed(double speed) {
		pid.setSetpoint(-speed * PID_FACTOR);
	}
	
	public void stop() {
		pid.disable();
	}
	
	public double getEncoder() {
		return -encoder.pidGet();
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
