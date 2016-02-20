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
	
	// Joysticks
	public static final int JOYSTICK_DRIVE = 0;
	public static final int JOYSTICK_AUX = 1;
	
	// Auxiliary Buttons
	public static final int BUTTON_WEDGE_DOWN = 1;
	public static final int BUTTON_WEDGE_UP = 2;
	public static final int BUTTON_RAMP_TOGGLE = 3;
	public static final int BUTTON_AUTOSHOOT = 4;
	public static final int BUTTON_INTAKE = 5;
	public static final int BUTTON_PURGE = 6;
	public static final int BUTTON_TIMED_PURGE = 7;
	public static final int BUTTON_REVERSE_DRIVE = 12;
	
	// Auxiliary Axes
	public static final int AXIS_PREP = 2;
	public static final int AXIS_SHOOT = 3;
	
	// Drive Axes
	public static final int TILT_AXIS = 0;
	public static final int Y_AXIS = 1;
	public static final int THROTTLE_AXIS = 2;
	public static final int TWIST_AXIS = 5;
	
	// Drive train
	public static final int[] LEFT_DRIVE_MOTORS = {3, 4};
	public static final Pair LEFT_DRIVE_ENCODER = new Pair<Integer>(0, 1);
	public static final int[] RIGHT_DRIVE_MOTORS = {1, 2};
    public static final Pair RIGHT_DRIVE_ENCODER = new Pair<Integer>(2, 3);
	
	// Shooter
	public static final int TOP_SHOOTER_MOTOR = 5;
	public static final int BOTTOM_SHOOTER_MOTOR = 6;

	
	// Intake
	public static final int[] INTAKE_MOTORS = {7};
	
	// Ramp
	public static final Pair<Integer> RAMP_SOLENOID = new Pair<>(0, 1);
	
	// Wedge
	public static final int[] WEDGE_MOTORS = {8};
}