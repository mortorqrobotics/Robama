package org.team1515.robama;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class AxisButton extends Button {

	Joystick joystick;
	int axis;
	double pressThreshold;
	double releaseThreshold;
	int reverseFactor;
	boolean wasPressed;
	
	public AxisButton(Joystick joystick, int axis, double pressThreshold, double releaseThreshold, boolean reverse) {
		this.joystick = joystick;
		this.axis = axis;
		if(reverse) {
			this.reverseFactor = -1;
		} else {
			this.reverseFactor = 1;
		}
		this.pressThreshold = pressThreshold * reverseFactor;
		this.releaseThreshold = releaseThreshold * reverseFactor;
		this.wasPressed = false;
	}

	public AxisButton(Joystick joystick, int axis, double pressThreshold, double releaseThreshold) {
		this(joystick, axis, pressThreshold, releaseThreshold, false);
	}
	
	@Override
	public boolean get() {
		double threshold;
		if(wasPressed) {
			threshold = releaseThreshold;
		} else {
			threshold = pressThreshold;
		}
		this.wasPressed = reverseFactor * joystick.getRawAxis(axis) > threshold; 
		return wasPressed;
	}

	
}
