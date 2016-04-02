package org.team1515.robama.commands.shoot;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class TimedPurge extends Command {
	
	private static final double TIME = 0.1; // milliseconds

	public TimedPurge() {
		requires(Robot.intake);
		requires(Robot.bottomShooter);
	}
	
	@Override
	protected void initialize() {
		double speed = 8 / DriverStation.getInstance().getBatteryVoltage();
		Robot.intake.purge(speed);		
		Robot.bottomShooter.purge(speed);
		setTimeout(TIME);
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
		Robot.bottomShooter.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
