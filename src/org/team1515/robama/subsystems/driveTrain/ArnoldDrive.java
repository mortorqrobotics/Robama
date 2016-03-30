package org.team1515.robama.subsystems.driveTrain;

import edu.wpi.first.wpilibj.Joystick;

public class ArnoldDrive extends WestCoastDrive {
	
	private static double DEAD_BAND = 0.15;
	
	public ArnoldDrive(Joystick joystick) {
		super(joystick);
	}

	protected JoystickValues getJoystickXY() {
		double y = -joystick.getRawAxis(1);
		double x = joystick.getRawAxis(5);
		if (Math.abs(y) <= DEAD_BAND) {
			y = 0.0;
		}
		if (Math.abs(x) <= DEAD_BAND) {
			x = 0.0;
		}
		return new JoystickValues(x, y, getThrottle());
	}
	
	protected double getThrottle() {
		return (1 - joystick.getRawAxis(2)) / 2;
	}
	
}