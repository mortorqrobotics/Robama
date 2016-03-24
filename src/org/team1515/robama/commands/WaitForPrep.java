package org.team1515.robama.commands;

import org.team1515.robama.Robot;
import org.team1515.robama.subsystems.TopShooter;

import edu.wpi.first.wpilibj.command.Command;

public class WaitForPrep extends Command {

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return Robot.topShooter.getState().equals(TopShooter.State.PREPPED);
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		end();
	}

}
