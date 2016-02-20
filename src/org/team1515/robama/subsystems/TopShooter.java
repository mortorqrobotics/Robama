package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;
import org.team1515.robama.subsystems.pid.InternalEncoder;
import org.team1515.robama.subsystems.pid.RatePID;

import edu.wpi.first.wpilibj.command.Subsystem;

public class TopShooter extends Subsystem {
	
	private MotorModule motor;
	private RatePID ratePID;
		
	public TopShooter() {
		motor = new MotorModule(RobotMap.TOP_SHOOTER_MOTORS);
		// ratePID = new RatePID(motor, new InternalEncoder(motor), 36000, 0, 0, 0);
	}

	public void setSpeed(double speed) {
		// ratePID.setSetpoint(speed);
		motor.setSpeed(speed);
	}
	
	public void stop() {
		// ratePID.disable();
		setSpeed(0);
	}
	
	protected void initDefaultCommand() {
		
	}

}
