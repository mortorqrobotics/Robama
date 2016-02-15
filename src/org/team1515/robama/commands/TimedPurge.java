package org.team1515.robama.commands;

import org.team1515.robama.Config;
import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TimedPurge extends Command {

	public TimedPurge() {
		requires(Robot.intake);
		requires(Robot.shooter);
	}
	
	@Override
	protected void initialize() {
		Robot.intake.reverse();		
		Robot.shooter.setBottom(-1);
		setTimeout(Config.getDouble("purgeTime") / 1000.0);
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
		Robot.shooter.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
