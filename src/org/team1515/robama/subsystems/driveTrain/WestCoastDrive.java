package org.team1515.robama.subsystems.driveTrain;

import org.team1515.robama.Config;
import org.team1515.robama.RobotMap;
import org.team1515.robama.commands.JoystickDrive;
import org.team1515.robama.subsystems.MotorModule;
import org.team1515.robama.subsystems.pid.ExternalEncoder;
import org.team1515.robama.subsystems.pid.RatePID;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class WestCoastDrive extends Subsystem {
	
	protected MotorModule leftMotors;
	private RatePID leftRatePID;
	protected MotorModule rightMotors;
	private RatePID rightRatePID;
	protected Joystick joystick;
	
	protected boolean isReversed;

	
	public WestCoastDrive(Joystick joystick) {
		leftMotors = new MotorModule(RobotMap.LEFT_DRIVE_MOTORS);
		leftRatePID = new RatePID(leftMotors, new ExternalEncoder(RobotMap.LEFT_DRIVE_ENCODER), 0, 0, 0, 550);
		rightMotors = new MotorModule(RobotMap.RIGHT_DRIVE_MOTORS);
		rightRatePID = new RatePID(rightMotors, new ExternalEncoder(RobotMap.RIGHT_DRIVE_ENCODER), 0, 0, 0, 550);
		
		isReversed = false; // switch to reverse motors
		
		this.joystick = joystick;

		Config.setDefault("rotationCorner", 0.25);
		Config.setDefault("rotationSide", 1.0);
	}
	
	public MotorModule getLeftMotors() {
		return leftMotors;
	}
	public MotorModule getRightMotors() {
		return rightMotors;
	}

	public void setSpeed(double leftSpeed, double rightSpeed) {
		double factor = isReversed ? -1 : 1;
//		leftMotors.setSpeed(leftSpeed * factor);
//		rightMotors.setSpeed(-rightSpeed * factor);
		leftRatePID.setSetpoint(leftSpeed * factor);
		rightRatePID.setSetpoint(-rightSpeed * factor);
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
		double x = Math.abs(xValue);
		double y = Math.abs(yValue);
		double a = Config.getDouble("rotationSide");
		double b = Config.getDouble("rotationCorner");
    	double left = a * x + y * (1 - a * x);
    	double right = y * (1 + (a + b - 1) * x) - a * x;
    	if(yValue < 0) {
    		left *= -1;
    		right *= -1;
    		xValue *= -1;
    	}
    	if(xValue < 0) {
    		double temp = left;
    		left = right;
    		right = temp;
    	}
    	setSpeed(left, right);
	}
	
	public void joystickDrive() {
		JoystickValues values = getJoystickXY();
		Config.setDouble("throttle", values.getThrottle());
		setXY(values.getX() * values.getThrottle(), values.getY() * values.getThrottle());
 	}
	
	public void resetEncoders() {
//		leftMotors.resetEncoder();
//		rightMotors.resetEncoder();
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());	
	}
}
