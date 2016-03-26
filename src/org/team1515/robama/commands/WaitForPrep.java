package org.team1515.robama.commands;

import org.team1515.robama.Robot;
import org.team1515.robama.subsystems.State;

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
//		return Robot.topShooter.getState().equals(State.PREPPED);
		return System.currentTimeMillis() - Robot.topShooter.getPrepStart() >= 2000;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		end();
	}

}