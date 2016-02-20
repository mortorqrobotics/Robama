package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PurgeIntake extends Command {

	public PurgeIntake() {
		requires(Robot.intake);
		requires(Robot.bottomShooter);
	}
	
	@Override
	protected void initialize() {
		Robot.intake.reverse();		
		Robot.bottomShooter.setSpeed(-1);
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
		Robot.bottomShooter.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
