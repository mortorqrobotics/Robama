package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class PurgeIntake extends Command {

	public PurgeIntake() {
		requires(Robot.intake);
		requires(Robot.bottomShooter);
		requires(Robot.wedgeIntake);
	}
	
	@Override
	protected void initialize() {
		Robot.intake.purge();		
		Robot.bottomShooter.setMotor(-1);
		Robot.wedgeIntake.intake(-1);
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
		Robot.bottomShooter.setMotor(0);
		Robot.wedgeIntake.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
