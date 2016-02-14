package org.team1515.robama.commands.test;

import org.team1515.robama.Config;
import org.team1515.robama.Robot;
import org.team1515.robama.subsystems.driveTrain.PIDTest;

import edu.wpi.first.wpilibj.command.Command;

public class TestForward extends Command {
	
	PIDTest pidTest;
	
	public TestForward(PIDTest pidTest) {
		this.pidTest = pidTest;
		requires(Robot.driveTrain);
	}

	protected void initialize() {
		
	}

	protected void execute() {
		pidTest.getMotors().setSpeed(1);
		double small = Math.random() / 1e8;
		Config.setDouble("pidError", pidTest.getPIDController().getError() + small);
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
