package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeForward extends Command {
	
	public IntakeForward() {
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {
		Robot.intake.start();
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		Robot.intake.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
	
	
}
