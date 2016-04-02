package org.team1515.robama.commands.shoot;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PrepTopShooter extends Command {
	
	public PrepTopShooter() {
		requires(Robot.topShooter);
	}
	
	@Override
	protected void initialize() {
		Robot.topShooter.shoot();
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
