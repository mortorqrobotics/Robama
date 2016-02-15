package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;
import org.team1515.robama.subsystems.driveTrain.MotorModule;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	
	private MotorModule topMotor;
	private MotorModule bottomMotor;
		
	public Shooter() {
		topMotor = new MotorModule(RobotMap.TOP_SHOOTER_ENCODER, RobotMap.TOP_SHOOTER_MOTORS);
		bottomMotor = new MotorModule(RobotMap.BOTTOM_SHOOTER_ENCODER, RobotMap.BOTTOM_SHOOTER_MOTORS);
	}

	public void setSpeed(double speed) {
		setTop(speed);
		setBottom(speed);
	}
	
	public void setTop(double speed) {
		topMotor.setSpeed(-speed);
	}
	
	public void stopTop() {
		topMotor.stop();
	}
	
	public void setBottom(double speed) {
		bottomMotor.setSpeed(speed);
	}
	
	public void stopBottom() {
		bottomMotor.stop();
	}
	
	public void stop() {
		setSpeed(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
