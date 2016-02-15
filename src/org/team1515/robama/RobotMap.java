package org.team1515.robama;

public class RobotMap {
/*
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	~~~~~~~~~ CAN IDs ~~~~~~~~~~
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 *	~~~ Drive Train ~~~
 *	1 - top, right
 *	2 - bottom, right
 *	3 - top, left
 *	4 - bottom, left
 *
 *	~~~ Shooter ~~~
 *	5 - left, back
 *	6 - left, front
 *	7 - right
 *
 *	~~~ Other Systems ~~~
 *	10 - PDP
 *	11 - PCM
*/
	
	// Joystick
	public static final int JOYSTICK_DRIVE = 0;
	public static final int JOYSTICK_AUX = 1;
	
	// Buttons
	public static final int BUTTON_INTAKE = 5;
	public static final int BUTTON_PURGE = 6;
	public static final int BUTTON_SMALL_PURGE = 7;
	public static final int BUTTON_RAMP_TOGGLE = 3;
	public static final int BUTTON_REVERSE_DRIVE = 12;
	
	// Axes
	public static final int TILT_AXIS = 0;
	public static final int Y_AXIS = 1;
	public static final int THROTTLE_AXIS = 2;
	public static final int TWIST_AXIS = 5;
	public static final int PREP_AXIS = 2;
	public static final int SHOOT_AXIS = 3;
	
	// Drive train
	public static final int[] LEFT_DRIVE_MOTORS = {3, 4};
	public static final Pair LEFT_DRIVE_ENCODER = new Pair<Integer>(0, 1);
	public static final int[] RIGHT_DRIVE_MOTORS = {1, 2};
    public static final Pair RIGHT_DRIVE_ENCODER = new Pair<Integer>(2, 3);
	
	// Shooter
	public static final int[] TOP_SHOOTER_MOTORS = {5};
	public static final Pair<Integer> TOP_SHOOTER_ENCODER = new Pair<>(4, 5);
	public static final int[] BOTTOM_SHOOTER_MOTORS = {6};
	public static final Pair<Integer> BOTTOM_SHOOTER_ENCODER = new Pair<>(6, 7);

	
	// Intake
	public static final int[] INTAKE_MOTORS = {7};
	public static final Pair INTAKE_ENCODER = new Pair<Integer>(8, 9);
	
	// Ramp
	public static final Pair<Integer> RAMP_SOLENOID = new Pair<>(0, 1);
}