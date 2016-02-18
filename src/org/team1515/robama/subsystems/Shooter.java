package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	
	private PIDMotorModule topMotor; // switch to MotorModule declaration?
	private PIDMotorModule bottomMotor;
		
	public Shooter() {
		topMotor = new PIDMotorModule(RobotMap.TOP_SHOOTER_MOTORS, RobotMap.TOP_SHOOTER_ENCODER);
		bottomMotor = new PIDMotorModule(RobotMap.BOTTOM_SHOOTER_MOTORS, RobotMap.BOTTOM_SHOOTER_ENCODER);
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
	
	public void prep() {
		setTop(1.0);
	}
	
	public void shoot(double speed) {
		setSpeed(speed);
	}
	
	public void stop() {
		setSpeed(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
