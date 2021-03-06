package org.team1515.robama.subsystems.driveTrain;

import org.team1515.robama.Config;
import org.team1515.robama.RobotMap;
import org.team1515.robama.commands.JoystickDrive;
import org.team1515.robama.subsystems.MotorModule;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class WestCoastDrive extends Subsystem {
	
	protected MotorModule leftMotors;
//	private ExternalEncoder leftEncoder;
	protected MotorModule rightMotors;
//	private ExternalEncoder rightEncoder;
//	private PIDController rightPID;
	protected Joystick joystick;
	
	protected boolean isReversed;

	
	public WestCoastDrive(Joystick joystick) {
		leftMotors = new MotorModule(RobotMap.LEFT_DRIVE_MOTORS);
//		leftEncoder = new ExternalEncoder(RobotMap.LEFT_DRIVE_ENCODER);
//		leftEncoder.setPIDSourceType(PIDSourceType.kRate);
//		leftPID = new PIDController(0.0006, 0, 0, leftEncoder, leftMotors); // factor 550
		rightMotors = new MotorModule(RobotMap.RIGHT_DRIVE_MOTORS);
//		rightEncoder = new ExternalEncoder(RobotMap.RIGHT_DRIVE_ENCODER);v
//		rightEncoder.setPIDSourceType(PIDSourceType.kRate);
//		rightPID = new PIDController(0.0006, 0, 0, rightMotors, rightEncoder); // factor 550
		
		isReversed = false; // switch to reverse motors
		
		this.joystick = joystick;

		Config.setDefault("rotationCorner", 0.25);
		Config.setDefault("rotationSide", 1.0);
		
		Config.setDefault("leftTrim", 1);
		Config.setDefault("rightTrim", 1);
	}
	
	public MotorModule getLeftMotors() {
		return leftMotors;
	}
	public MotorModule getRightMotors() {
		return rightMotors;
	}

	public void setSpeed(double leftSpeed, double rightSpeed) {
//		leftMotors.setSpeed(leftSpeed * Config.getDouble("leftTrim"));
//		rightMotors.setSpeed(-rightSpeed * Config.getDouble("rightTrim"));
		leftMotors.setSpeed(leftSpeed);
		rightMotors.setSpeed(-rightSpeed);
//		leftPID.setSetpoint(leftSpeed * factor);
//		rightPID.setSetpoint(-rightSpeed * factor);
	}
	
	private boolean setSpeed(int ticks, double leftSpeed, double rightSpeed) {
		setSpeed(leftSpeed, rightSpeed);
//		int distance = Math.abs(leftMotors.getEncoderRate()) + Math.abs(rightMotors.getEncoderRate());
//		return distance >= ticks * 2;
		return false;
	}
	
	public boolean driveForward(int ticks, double speed) {
		return setSpeed(ticks, speed, speed);
	}
	
	public boolean driveBackward(int ticks, double speed) {
		return setSpeed(ticks, -speed, -speed);
	}
	
	public boolean rotateLeft(int ticks, double speed) {
		return setSpeed(ticks, -speed, speed);
	}
	
	public boolean rotateRight(int ticks, double speed) {
		return setSpeed(ticks, speed, -speed);
	}

	public void stop() {
		setSpeed(0, 0);
	}
	
	public void reverse() {
		this.isReversed = !this.isReversed;
	}
	
	protected abstract JoystickValues getJoystickXY();

	public void setXY(double xValue, double yValue) {
//		double reverseFactor = isReversed ? -1 : 1;
//		yValue *= reverseFactor;
		double x = Math.abs(xValue);
		double y = Math.abs(yValue);
//		double a = Config.getDouble("rotationSide");
//		double b = Config.getDouble("rotationCorner");
		double a = 1.0;
		double b = 0.25;
    	double left = a * x + y * (1 - a * x);
    	double right = y * (1 + (a + b - 1) * x) - a * x;
    	if (yValue < 0) {
    		left *= -1;
    		right *= -1;
    		xValue *= -1;
    	}
    	if (xValue < 0) {
    		double temp = left;
    		left = right;
    		right = temp;
    	}
    	setSpeed(left, right);
	}
	
	public void joystickDrive() {
		JoystickValues values = getJoystickXY();
		setXY(values.getX() * values.getThrottle(), values.getY() * values.getThrottle());
 	}
	
	public void resetEncoders() {
//		leftMotors.resetEncoder();
//		rightMotors.resetEncoder();
	}
	
//	public double getLeftEncoder() {
//		return leftEncoder.pidGet();
//	}
//	
//	public double getRightEncoder() {
//		return rightEncoder.pidGet();
//	}

	public boolean isReversed() {
		return isReversed;
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());	
	}
	
}
