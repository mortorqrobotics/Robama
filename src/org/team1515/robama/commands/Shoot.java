package org.team1515.robama.commands;

import org.team1515.robama.Robot;
import org.team1515.robama.subsystems.State;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
	
	private double speed;

	public Shoot(double speed) {
		requires(Robot.topShooter);
		requires(Robot.bottomShooter);
		requires(Robot.intake);
		requires(Robot.wedgeIntake);
		this.speed = speed;
	}
	
	@Override
	protected void initialize() {
		Robot.topShooter.prep();
		Robot.bottomShooter.setSpeed(speed);
		Robot.bottomShooter.setMotor(speed);
		Robot.wedgeIntake.intake();
		Robot.intake.intake();
	}

	@Override
	protected void execute() {
//		SmartDashboard.putNumber("pidError", Robot.bottomShooter.getEncoder() + Math.random() / 1e9);
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
		Robot.wedgeIntake.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
