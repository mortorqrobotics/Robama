package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ReverseDrive extends Command {	
	public ReverseDrive() {
		requires(Robot.driveTrain);
	}
	
	@Override
	protected void initialize() {
		requires(Robot.driveTrain);
	}

	@Override
	protected void execute() {
		Robot.driveTrain.isReversed = !Robot.driveTrain.isReversed;
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		end();
	}
}
