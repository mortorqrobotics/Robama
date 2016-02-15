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
		this.reverseFactor = reverse ? -1 : 1;
		this.pressThreshold = pressThreshold * reverseFactor;
		this.releaseThreshold = releaseThreshold * reverseFactor;
		this.wasPressed = false;
	}
	
	@Override
	public boolean get() {		
		return wasPressed = reverseFactor * joystick.getRawAxis(axis) > (wasPressed ? releaseThreshold : pressThreshold); 
	}

	
}
