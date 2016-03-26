package org.team1515.robama.commands;

import org.team1515.robama.Robot;
import org.team1515.robama.subsystems.State;

import edu.wpi.first.wpilibj.command.Command;

public class PrepShooter extends Command {

	double startTime;
	
	public PrepShooter() {
		requires(Robot.topShooter);
	}
	
	@Override
	protected void initialize() {
		Robot.topShooter.prep();
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
		
	}

	@Override
	protected void interrupted() {
		end();
	}

}
