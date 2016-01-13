package org.team1515.robama.subsystems;

import org.team1515.robama.commands.JoystickDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class WestCoastDrive extends Subsystem {
	
	protected static final double DEAD_BAND = 0.15;
	protected static final double DRIVING_SCALE = 1.0;
	protected static final double TURNING_SCALE = 1.0;
	
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
		int distance = Math.abs(leftEncoder.get());
		return distance >= ticks;
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
	
	public void drive() {
		Pair<Double> pair = getJoystickXY();
		setXY(pair.first, pair.last);
 	}
	
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());	
	}
}
