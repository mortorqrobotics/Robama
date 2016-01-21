package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetIntake extends Command {
	
	double speed;
	
	public SetIntake(double speed) {
		requires(Robot.intake);
		this.speed = speed;
	}

	@Override
	protected void initialize() {
		Robot.intake.setSpeed(speed);
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
	}

	@Override
	protected void interrupted() {
		end();
	}
	
	
}
