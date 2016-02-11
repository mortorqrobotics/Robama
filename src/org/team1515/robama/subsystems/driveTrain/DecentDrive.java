package org.team1515.robama.subsystems.driveTrain;

import org.team1515.robama.Config;
import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.Joystick;

public class DecentDrive extends WestCoastDrive {

	public DecentDrive(Joystick joystick) {
		super(joystick);
		Config.setDefault("deadBand", 0.15);
		Config.setDefault("tiltThreshold", 0.2);
	}

	protected JoystickValues getJoystickXY() {
		double deadBand = Config.getDouble("deadBand");
		double throttle = (1 - joystick.getRawAxis(RobotMap.THROTTLE_AXIS)) / 2;
		double tilt = applyDeadband(joystick.getRawAxis(RobotMap.TILT_AXIS), deadBand);
		double twist = applyDeadband(joystick.getRawAxis(RobotMap.TWIST_AXIS), deadBand);
		double y = -applyDeadband(joystick.getRawAxis(RobotMap.Y_AXIS), deadBand);
		double x = tilt;
		if(Math.signum(tilt) + Math.signum(twist) != 0) {
			x = twist;
			if(Math.abs(y) > Config.getDouble("tiltThreshold") && Math.abs(tilt) > Math.abs(twist)) {
				x = tilt;
			}
		}
		return new JoystickValues(x, y, throttle);
	}
	
	private double applyDeadband(double value, double deadBand) {
		if(Math.abs(value) < deadBand) {
			return 0;
		}
		return value;
	}

}
