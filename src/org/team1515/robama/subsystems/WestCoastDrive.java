package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;
import org.team1515.robama.commands.JoystickDrive;
import org.team1515.robama.config.Config;
import org.team1515.robama.config.Configurable;
import org.team1515.robama.config.ConfigurableType;
import org.team1515.robama.config.ConfigurableVariable;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public abstract class WestCoastDrive extends Subsystem implements Configurable {
	
	protected double deadBand = 0.15;
	protected double drivingScale = 1.0;
	protected double turningScale = 1.0;
	
	protected MotorModule leftMotors;
	protected MotorModule rightMotors;
	protected Joystick joystick;
	
	protected boolean isReversed;

	
	public WestCoastDrive(Joystick joystick) {
		leftMotors = new MotorModule(RobotMap.LEFT_DRIVE_ENCODER, RobotMap.LEFT_DRIVE_MOTORS, true);
		rightMotors = new MotorModule(RobotMap.RIGHT_DRIVE_ENCODER, RobotMap.RIGHT_DRIVE_MOTORS, false);
		
		isReversed = false;
		
		this.joystick = joystick;	
	}


	public void setSpeed(double leftSpeed, double rightSpeed) {
		double factor = 1; //change to -1 to reverse motors
		leftMotors.setSpeed(-leftSpeed * factor);
		rightMotors.setSpeed(rightSpeed * factor);
	}
	
	private boolean setSpeed(int ticks, double leftSpeed, double rightSpeed) {
		setSpeed(leftSpeed, rightSpeed);
//		int distance = Math.abs(leftMotors.getEncoder()) + Math.abs(rightMotors.getEncoder());
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
	
	protected abstract Pair<Double> getJoystickXY();

	public void setXY(double x, double y) {
		setSpeed(y - x, y + x);
	}
	
	public void joystickDrive() {
		Pair<Double> pair = getJoystickXY();
		if(isReversed){
			setXY(-1 * pair.first * turningScale, -1 * pair.last * drivingScale);
		} else {
			setXY(pair.first * turningScale, pair.last * drivingScale);
		}
		
 	}
	
	public void resetEncoders() {
		leftMotors.resetEncoder();
		rightMotors.resetEncoder();
	}
	
	public double getLeftEncoder() {
		return leftMotors.getEncoder();
	}
	
	public double getRightEncoder() {
		return rightMotors.getEncoder();
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
