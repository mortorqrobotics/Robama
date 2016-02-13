package org.team1515.robama.commands.test;

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
