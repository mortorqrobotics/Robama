package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StartIntake extends Command {
	
	double intakeSpeed;
	
	public StartIntake(double intakeSpeed) {
		requires(Robot.shooter);
		this.intakeSpeed = intakeSpeed;
	}

	@Override
	protected void initialize() {
		Robot.shooter.setIntakeSpeed(intakeSpeed);
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
		Robot.shooter.stopIntake();
	}

	@Override
	protected void interrupted() {
		end();
	}
	
	
}
