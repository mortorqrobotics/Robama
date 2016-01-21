package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	
	private MotorModule topMotor;
	private MotorModule bottomMotor;
	private MotorModule intakeMotor;
	private MotorModule boulderRampMotor; //assuming the sheet drop is powered
	
	private final int MAX_BOULDER_RAMP_DROP = 100; //temporary
	
	public Shooter() {
		topMotor = new MotorModule(RobotMap.TOP_SHOOTER_ENCODER, RobotMap.TOP_SHOOTER_MOTORS, false);
		bottomMotor = new MotorModule(RobotMap.BOTTOM_SHOOTER_ENCODER, RobotMap.BOTTOM_SHOOTER_MOTORS, false);
		intakeMotor = new MotorModule(RobotMap.INTAKE_SHOOTER_ENCODER, RobotMap.INTAKE_SHOOTER_MOTORS, false);
		boulderRampMotor = new MotorModule(RobotMap.BOULDER_RAMP_ENCODER, RobotMap.BOULDER_RAMP_MOTORS, false);
	}
	
	public void setSpeed(double speed) {
		topMotor.setSpeed(speed);
		bottomMotor.setSpeed(speed); //it is positive because motors are on opposite sides and are spinning opposite directions, so essentially a double negative
	}
	
	public void stop() {
		setSpeed(0);
	}
	
	public void setIntakeSpeed(double speed) {
		intakeMotor.setSpeed(speed);
	}
	
	public void stopIntake() {
		setIntakeSpeed(0);
	}
	
	public void setDropSpeed(double speed) {
		boulderRampMotor.setSpeed(speed);
	}
	
	public void stopDrop() {
		setDropSpeed(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
