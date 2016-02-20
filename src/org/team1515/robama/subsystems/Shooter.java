package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	
	private PIDMotorModule topMotor; // switch to MotorModule declaration?
	private PIDMotorModule bottomMotor;
		
	public Shooter() {
		topMotor = new InternalPIDMotorModule(RobotMap.TOP_SHOOTER_MOTOR, 36000, PIDSourceType.kRate, 0, 0, 0);
		bottomMotor = new InternalPIDMotorModule(RobotMap.BOTTOM_SHOOTER_MOTOR, 36000, PIDSourceType.kRate, 0, 0, 0);
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
