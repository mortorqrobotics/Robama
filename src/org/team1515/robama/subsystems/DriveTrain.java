package org.team1515.robama.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class DriveTrain extends Subsystem {
	
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
	
	public DriveTrain(Joystick joystick) {
		leftMotors = new MotorModule(1, 2, 3);
		rightMotors = new MotorModule(3, 4, 5);
		
		leftEncoder = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
		leftEncoder.setMaxPeriod(.05);
		leftEncoder.setMinRate(10);
		leftEncoder.setDistancePerPulse(1);
		leftEncoder.setReverseDirection(true);
		leftEncoder.setSamplesToAverage(10);
		leftEncoder.reset();
		
		rightEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
		rightEncoder.setMaxPeriod(.05);
		rightEncoder.setMinRate(10);
		rightEncoder.setDistancePerPulse(1);
		rightEncoder.setReverseDirection(true);
		rightEncoder.setSamplesToAverage(10);
		rightEncoder.reset();
		
		leftPID = new PIDController(1, 0.1, 0.01, leftEncoder, leftMotors);
		leftPID.enable();
		rightPID = new PIDController(1, 0.1, 0.01, rightEncoder, rightMotors);
		rightPID.enable();
		
		this.joystick = joystick;	
	}

	public void setSpeed(double leftSpeed, double rightSpeed) {
		leftMotors.setSpeed(leftSpeed);
		rightMotors.setSpeed(rightSpeed);
	}
	
	protected abstract Pair<Double> getXY();
	
	public void drive() {
		Pair<Double> pair = getXY();
		double y = pair.last * DRIVING_SCALE; // * reverseFactor;
		double x = pair.first * TURNING_SCALE;
		setSpeed(-y + x, y + x);
 	}
	
	protected double getThrottle() {
		return (-joystick.getRawAxis(2) + 1) / 2;
	}
	
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

}
