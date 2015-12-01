package org.team1515.robama.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveTrain {
	
	protected MotorModule leftMotors;
	protected MotorModule rightMotors;
	protected Joystick joystick;
	
	PIDController leftPID;
	PIDController rightPID;
	
	public DriveTrain() {
		
		leftPID = new PIDController(1, 0.1, 0.01, leftMotors.getEncoder(), leftMotors);	
		rightPID = new PIDController(1, 0.1, 0.01, rightMotors.getEncoder(), rightMotors);
		
	}

}
