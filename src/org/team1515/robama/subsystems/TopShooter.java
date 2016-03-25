package org.team1515.robama.subsystems;

import org.team1515.robama.Config;
import org.team1515.robama.RobotMap;
import org.team1515.robama.subsystems.pid.InternalEncoder;
import org.team1515.robama.subsystems.pid.RatePID;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TopShooter extends Subsystem {
	
	private volatile State state;
	private long prepStart;
	
	private MotorModule motor;
	private RatePID ratePID;
	private boolean prePrepping;
		
	public TopShooter() {
		motor = new MotorModule(RobotMap.TOP_SHOOTER_MOTORS);
		ratePID = new RatePID(motor, new InternalEncoder(motor, true), 0.00001, 0, 0.00008, 30000);
		prePrepping = false;
		state = State.REST;
		
		Config.setDefault("prePrepSpeed", 0.25);
		Config.setDefault("shootPower", 26);
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
		if (state != State.REST && state != State.PREPREP) {
			return;
		}
		prePrepping = !prePrepping;
		if (prePrepping) {
			setMotor(Config.getDouble("prePrepSpeed"));
			state = State.PREPREP;
		} else {
			setMotor(0);
			state = State.REST;
		}
		SmartDashboard.putBoolean("prePrepping", prePrepping);
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

	public void setState(State state) {
		System.out.println(state);
		this.state = state;
	}
	
	public State getState() {
		return state;
	}
	
	public void increaseShootPower(double amount) {
		Config.setDouble("shootPower", Config.getDouble("shootPower") + amount);
	}
	
	public void prep() {
		setSpeed(Config.getDouble("shootPower") * 1000 / 30000);
	}
	
	public void setPrepStart() {
		this.prepStart = System.currentTimeMillis();
	}
	
	public long getPrepStart() {
		return prepStart;
	}

}
