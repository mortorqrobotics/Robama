package org.team1515.robama.commands.test;

import org.team1515.robama.Config;
import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TestShooter extends Command {
	
	public TestShooter() {
		requires(Robot.shooter);
	}

	protected void initialize() {
		Robot.shooter.setSpeed(Config.getDouble("testShootSpeed"));
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.shooter.stop();
	}

	protected void interrupted() {
		end();
	}

}
