package org.team1515.robama;

public class RobotMap {
	
	//Buttons
	public static final int BUTTON_SHOOT = 0;
	public static final int BUTTON_INTAKE = 0;
	
	//Axes
	public static final int THROTTLE_AXIS = 2;
	public static final int TILT_AXIS = 0;
	public static final int TWIST_AXIS = 5;
	public static final int Y_AXIS = 1;
	
	//Drive train
	public static final int[] LEFT_DRIVE_MOTORS = {0, 1, 2};
	public static final Pair LEFT_DRIVE_ENCODER = new Pair<Integer>(0, 1);
	public static final int[] RIGHT_DRIVE_MOTORS = {3, 4, 5};
	public static final Pair RIGHT_DRIVE_ENCODER = new Pair<Integer>(2, 3);
	
	//Shooter
	public static final int[] TOP_SHOOTER_MOTORS = {6};
	public static final Pair TOP_SHOOTER_ENCODER = new Pair<Integer>(4, 5);
	public static final int[] BOTTOM_SHOOTER_MOTORS = {7};
	public static final Pair BOTTOM_SHOOTER_ENCODER = new Pair<Integer>(6, 7);
	
	//Intake
	public static final int[] INTAKE_MOTORS = {8};
	public static final Pair INTAKE_ENCODER = new Pair<Integer>(8, 9);
	
	//Ramp
	public static final int[] RAMP_MOTORS = {9};
	public static final Pair RAMP_ENCODER = new Pair<Integer>(10, 11);
}