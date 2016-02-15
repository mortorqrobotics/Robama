package org.team1515.robama.commands;

import org.team1515.robama.Robot;
import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {
	
	private double speed;

	public Shoot(double speed) {
		requires(Robot.shooter);
		requires(Robot.intake);
		this.speed = speed;
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		if(Robot.stick2.getRawAxis(RobotMap.SHOOT_AXIS) > 0.5){
			Robot.shooter.shoot(speed);
			Robot.intake.intake();
		}
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		/*if(!Robot.stick2.getRawButton(RobotMap.BUTTON_PREP)) {
			Robot.shooter.stop();
		}*/
		Robot.shooter.stop();
		Robot.intake.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
