package org.team1515.robama.commands.test;

import org.team1515.robama.Config;
import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TestForward extends Command {
	
	public TestForward() {
		requires(Robot.driveTrain);
	}

	protected void initialize() {
		
	}

	protected void execute() {
		Robot.driveTrain.setSpeed(1, 1);
		double small = Math.random() / 1e8;
		Config.setDouble("leftError", Robot.driveTrain.getLeftMotors().getPIDError() + small);
		Config.setDouble("rightError", Robot.driveTrain.getRightMotors().getPIDError() + small);
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
