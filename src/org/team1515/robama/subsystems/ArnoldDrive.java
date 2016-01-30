package org.team1515.robama.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public class ArnoldDrive extends WestCoastDrive {
	
	public ArnoldDrive(Joystick joystick) {
		super(joystick);
	}

	protected Pair<Double> getJoystickXY() {
		double y = -joystick.getRawAxis(1);
		double x = joystick.getRawAxis(5);
		if (Math.abs(y) <= deadBand) {
			y = 0.0;
		}
		if (Math.abs(x) <= deadBand) {
			x = 0.0;
		}
		y *= getThrottle();
		x *= getThrottle();
		return new Pair<Double>(x, y);
	}
	
	protected double getThrottle() {
//		System.out.print((-joystick.getRawAxis(2) + 1) / 2 + " ");
		return (-joystick.getRawAxis(2) + 1) / 2;
	}
	
}