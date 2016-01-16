package org.team1515.robama.subsystems;

import org.team1515.robama.commands.JoystickDrive;
import org.team1515.robama.config.Config;
import org.team1515.robama.config.Configurable;
import org.team1515.robama.config.ConfigurableType;
import org.team1515.robama.config.ConfigurableVariable;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class WestCoastDrive extends Subsystem implements Configurable {
	
	protected double deadBand = 0.15;
	protected double drivingScale = 1.0;
	protected double turningScale = 1.0;
	
	protected MotorModule leftMotors;
	protected MotorModule rightMotors;
	protected Joystick joystick;
	
	Encoder leftEncoder;
	Encoder rightEncoder;
	
	PIDController leftPID;
	PIDController rightPID;
	
	public WestCoastDrive(Joystick joystick) {
		leftMotors = new MotorModule(0, 1, 0, 1, 2);
		rightMotors = new MotorModule(2, 3, 3, 4, 5);
		
		leftEncoder = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
		initEncoder(leftEncoder);
		rightEncoder = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
		initEncoder(rightEncoder);
		
		leftPID = new PIDController(1, 0.1, 0.01, leftEncoder, leftMotors);
		leftPID.enable();
		rightPID = new PIDController(1, 0.1, 0.01, rightEncoder, rightMotors);
		rightPID.enable();
		
		this.joystick = joystick;	
	}
	
	private void initEncoder(Encoder encoder) {
		encoder.setMaxPeriod(.05);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(1);
		encoder.setSamplesToAverage(10);
		encoder.reset();
	}

	public void setSpeed(double leftSpeed, double rightSpeed) {
		double factor = 1; //change to -1 to reverse motors
		leftMotors.setSpeed(-leftSpeed * factor);
		rightMotors.setSpeed(rightSpeed * factor);
	}
	
	private boolean setSpeed(int ticks, double leftSpeed, double rightSpeed) {
		setSpeed(leftSpeed, rightSpeed);
		int distance = Math.abs(leftEncoder.get()) + Math.abs(rightEncoder.get());
		return distance >= ticks * 2;
	}
	
	public boolean driveForward(int ticks, double speed) {
		return setSpeed(ticks, speed, speed);
	}
	
	public boolean driveBackward(int ticks, double speed) {
		return setSpeed(ticks, -speed, -speed);
	}
	
	public boolean turnLeft(int ticks, double speed) {
		return setSpeed(ticks, -speed, speed);
	}
	
	public boolean turnRight(int ticks, double speed) {
		return setSpeed(ticks, speed, -speed);
	}

	public void stop() {
		setSpeed(0, 0);
	}
	
	protected abstract Pair<Double> getJoystickXY();

	public void setXY(double x, double y) {
		setSpeed(y - x, y + x);
	}
	
	public void joystickDrive() {
		Pair<Double> pair = getJoystickXY();
		setXY(pair.first * turningScale, pair.last * drivingScale);
 	}
	
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());	
	}
	
	public void reloadConfig(Config config) {
		deadBand = config.getDouble("deadBand");
		drivingScale = config.getDouble("drivingScale");
		turningScale = config.getDouble("turningScale");
	}
	
	public ConfigurableVariable[] registerVariables() {
		return new ConfigurableVariable[] {
				new ConfigurableVariable("deadBand", ConfigurableType.DOUBLE, 0.15),
				new ConfigurableVariable("drivingScale", ConfigurableType.DOUBLE, 1.0),
				new ConfigurableVariable("turningScale", ConfigurableType.DOUBLE, 1.0),
		};
	}
}
