package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PurgeIntake extends Command {

	public PurgeIntake() {
		requires(Robot.intake);
		requires(Robot.shooter);
	}
	
	@Override
	protected void initialize() {
		Robot.intake.reverse();		
		Robot.shooter.setBottom(-1);
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return false;
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
