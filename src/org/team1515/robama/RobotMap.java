package org.team1515.robama;

import org.team1515.robama.subsystems.Pair;

public class RobotMap {
	//Button
	public static final int BUTTON_FAST_SHOOT = 0;
	public static final int BUTTON_SLOW_SHOOT = 1;
	
	//Drive train
	public static final int[] LEFT_DRIVE_MOTORS = {0, 1, 2};
	public static final Pair LEFT_DRIVE_ENCODER = new Pair<Integer>(0, 1);
	public static final int[] RIGHT_DRIVE_MOTORS = {3, 4, 5};
	public static final Pair RIGHT_DRIVE_ENCODER = new Pair<Integer>(2, 3);
	
	//Shooter
	public static final int[] LEFT_SHOOTER_MOTORS = {6};
	public static final Pair LEFT_SHOOTER_ECODER = new Pair<Integer>(4, 5);
	public static final int[] RIGHT_SHOOTER_MOTORS = {7};
	public static final Pair RIGHT_SHOOTER_ENCODER = new Pair<Integer>(6, 7);
}
