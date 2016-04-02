package org.team1515.robama.commands.shoot;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {

	public Shoot() {
		requires(Robot.topShooter);
		requires(Robot.bottomShooter);
		requires(Robot.intake);
	}
	
	@Override
	protected void initialize() {
		Robot.topShooter.shoot();
		Robot.bottomShooter.shoot();
//		Robot.bottomShooter.setMotor(bottomSpeed);
		Robot.intake.intake();
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
		Robot.topShooter.stop();
		Robot.bottomShooter.stop();
		Robot.intake.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
