package org.team1515.robama.commands.test;

import org.team1515.robama.Config;
import org.team1515.robama.subsystems.driveTrain.MotorModule;

import edu.wpi.first.wpilibj.command.Command;

public class TestForward extends Command {
	
	MotorModule motors;
	
	public TestForward(MotorModule motors) {
		this.motors = motors;
		// no requires I guess?
	}

	protected void initialize() {
		
	}

	protected void execute() {
		motors.setSpeed(1);
		double small = Math.random() / 1e8;
		Config.setDouble("pidError", motors.getPIDError() + small);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		end();
	}

}
