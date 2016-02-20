package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeForward extends Command {
	
	public IntakeForward() {
		requires(Robot.intake);
		requires(Robot.wedgeIntake);
	}

	@Override
	protected void initialize() {
		Robot.intake.intake();
		Robot.wedgeIntake.intake();
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
		Robot.wedgeIntake.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
	
	
}
