package org.team1515.robama.commands;

import org.team1515.robama.Robot;
import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class PrepShooter extends Command {

	private double speed;
	
	public PrepShooter(double speed) {
		this.speed = speed;
		requires(Robot.shooter);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Robot.shooter.setTop(speed);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		if(!Robot.stick2.getRawButton(RobotMap.BUTTON_SHOOT)) {
			Robot.shooter.stop();
		}
	}

	@Override
	protected void interrupted() {
		end();		
	}

}
