package org.team1515.robama.subsystems.driveTrain;

public class JoystickValues {

	double x;
	double y;
	double throttle;
	
	public JoystickValues(double x, double y, double throttle) {
		this.x = x;
		this.y = y;
		this.throttle = throttle;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getThrottle() {
		return throttle;
	}
	
}
