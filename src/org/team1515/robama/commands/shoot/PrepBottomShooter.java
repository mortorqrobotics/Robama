package org.team1515.robama.commands.shoot;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PrepBottomShooter extends Command {
	
	public PrepBottomShooter() {
		requires(Robot.bottomShooter);
	}

	@Override
	protected void initialize() {
		Robot.bottomShooter.shoot();
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
