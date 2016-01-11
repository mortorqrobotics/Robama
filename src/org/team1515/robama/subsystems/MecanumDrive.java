package org.team1515.robama.subsystems;

import org.team1515.robama.commands.JoystickDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;

public abstract class MecanumDrive extends DriveTrain {
	
	protected static final double DEAD_BAND = 0.15;
	protected static final double DRIVING_SCALE = 1.0;
	protected static final double TURNING_SCALE = 1.0;
	
	protected CANTalon topLeftMotor;
	protected CANTalon topRightMotor;
	protected CANTalon bottomLeftMotor;
	protected CANTalon bottomRightMotor;
	
	protected Joystick joystick;
	
	Encoder leftEncoder;
	Encoder rightEncoder;
	
	PIDController topLeftPID;
	PIDController topRightPID;
	PIDController bottomLeftPID;
	PIDController bottomRightPID;
	
	public MecanumDrive(Joystick joystick) {
		topLeftMotor = new CANTalon(0);
		topRightMotor = new CANTalon(1);
		bottomLeftMotor = new CANTalon(2);
		bottomRightMotor = new CANTalon(3);
		
		
		leftEncoder = new Encoder(0, 1, true, Encoder.EncodingType.k4X);
		leftEncoder.setMaxPeriod(.05);
		leftEncoder.setMinRate(10);
		leftEncoder.setDistancePerPulse(1);
		leftEncoder.setSamplesToAverage(10);
		leftEncoder.reset();
		
		rightEncoder = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
		rightEncoder.setMaxPeriod(.05);
		rightEncoder.setMinRate(10);
		rightEncoder.setDistancePerPulse(1);
		rightEncoder.setSamplesToAverage(10);
		rightEncoder.reset();
		
		topLeftPID = new PIDController(1, 0.1, 0.01, leftEncoder, topLeftMotor);
		topRightPID = new PIDController(1, 0.1, 0.01, rightEncoder, topRightMotor);
		bottomLeftPID = new PIDController(1, 0.1, 0.01, leftEncoder, bottomLeftMotor);
		bottomRightPID = new PIDController(1, 0.1, 0.01, rightEncoder, bottomRightMotor);
		
		
		this.joystick = joystick;	
	}

	public void setSpeed(double topLeftSpeed, double topRightSpeed, double bottomLeftSpeed, double bottomRightSpeed) {
		topLeftMotor.set(-topLeftSpeed);
		topRightMotor.set(topRightSpeed);
		bottomLeftMotor.set(-bottomLeftSpeed);
		bottomRightMotor.set(bottomRightSpeed);
	}
	
	protected abstract Triple<Double> getXYZ();
	
	public void forward(double speed) {
		setSpeed(-speed, speed, -speed, speed);
	}
	
	public void backward(double speed) {
		setSpeed(speed, -speed, speed, -speed);
	}
	
	public boolean turnLeft(int position, double speed) {
		if(Math.abs(leftEncoder.get() - rightEncoder.get()) < position) {
			setSpeed(-speed, -speed, -speed, -speed);
			return false;
		} else {
			setSpeed(0,0,0,0);
			return true;
		}
	}
	
	public boolean turnRight(int position, double speed) {
		if(Math.abs(leftEncoder.get() - rightEncoder.get()) < position) {
			setSpeed(speed, speed, speed, speed);
			return false;
		} else {
			setSpeed(0,0,0,0);
			return true;
		}
	}
	
	public void stop() {
		topLeftMotor.set(0);
		topRightMotor.set(0);
		bottomLeftMotor.set(0);
		bottomRightMotor.set(0);
	}
	
	protected double getThrottle() {
		return (-joystick.getRawAxis(2) + 1) / 2;
	}
	
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());	
	}

}
