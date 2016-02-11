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
		topMotor.setSpeed(speed);
		bottomMotor.setSpeed(speed); //it is positive because motors are facing opposite directions and are spinning opposite directions, so essentially a double negative
	}
	
	public void stop() {
		setSpeed(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
