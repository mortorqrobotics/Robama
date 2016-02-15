package org.team1515.robama.subsystems;

import org.team1515.robama.Pair;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;

public class MecanumDrive {
	
	protected static final double DEAD_BAND = 0.15;
	protected static final double DRIVING_SCALE = 1.0;
	protected static final double TURNING_SCALE = 1.0;
	
	protected CANTalon topLeftMotor;
	protected CANTalon bottomLeftMotor;
	protected CANTalon topRightMotor;
	protected CANTalon bottomRightMotor;
	
	protected Joystick joystick;
	
	Encoder leftEncoder;
	Encoder rightEncoder;
	
	PIDController topLeftPID;
	PIDController bottomLeftPID;
	PIDController topRightPID;
	PIDController bottomRightPID;
	
	public MecanumDrive(Joystick stick){
		topLeftMotor = new CANTalon(0);
		bottomLeftMotor = new CANTalon(1);
		topRightMotor = new CANTalon(2);
		bottomRightMotor = new CANTalon(3);
		
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
		
		topLeftPID = new PIDController(1, 0.1, 0.01, leftEncoder, topLeftMotor);
		topLeftPID.enable();
		bottomLeftPID = new PIDController(1, 0.1, 0.01, leftEncoder, topLeftMotor);
		bottomLeftPID.enable();
		topRightPID = new PIDController(1, 0.1, 0.01, rightEncoder, topLeftMotor);
		topRightPID.enable();
		bottomRightPID = new PIDController(1, 0.1, 0.01, rightEncoder, topLeftMotor);
		bottomRightPID.enable();
		
		this.joystick = joystick;	
	}
	
	public void setSpeed(double topLeftSpeed, double bottomLeftSpeed, double topRightSpeed, double bottomRightSpeed) {
		topLeftMotor.set(topLeftSpeed);
		bottomLeftMotor.set(bottomLeftSpeed);
		topRightMotor.set(topRightSpeed);
		bottomRightMotor.set(bottomRightSpeed);
	}

	protected Pair<Double> getXY() {
		double y = -joystick.getRawAxis(1);
		double x = joystick.getRawAxis(5);
		if (Math.abs(y) <= DEAD_BAND) {
			y = 0.0;
		}
		if (Math.abs(x) <= DEAD_BAND) {
			x = 0.0;
		}
		y *= getThrottle();
		x *= getThrottle();
		return new Pair<Double>(x, y);
	}
	
	public void drive() {
		Pair<Double> pair = getXY();
		double y = pair.last * DRIVING_SCALE; // * reverseFactor;
		double x = pair.first * TURNING_SCALE;
		setSpeed(1,1,1,1);
	} 

	protected double getThrottle() {
		return (-joystick.getRawAxis(2) + 1) / 2;
	}
	
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
}
