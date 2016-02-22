package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PrepShooter extends Command {

	private double speed;
	
	public PrepShooter(double speed) {
		this.speed = speed;
		requires(Robot.topShooter);
		requires(Robot.bottomShooter);
	}
	
	@Override
	protected void initialize() {
		Robot.topShooter.setSpeed(speed);
		Robot.bottomShooter.setSpeed(speed);
	}

	@Override
	protected void execute() {
//		SmartDashboard.putNumber("pidError", Robot.topShooter.getEncoder() + Math.random() / 1e9);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		if(!isTimedOut()) {
			Robot.topShooter.stop();
			Robot.bottomShooter.stop();
		}
	}

	@Override
	protected void interrupted() {
//		end();		
	}

}
