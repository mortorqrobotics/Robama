package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PrepShooter extends Command {

	private double speed;
//	private double lastEncoder;
	
	public PrepShooter(double speed) {
		this.speed = speed;
		requires(Robot.topShooter);
		requires(Robot.bottomShooter);
	}
	
	@Override
	protected void initialize() {
//		lastEncoder = 0;
		Robot.topShooter.setSpeed(speed);
		Robot.bottomShooter.setMotor(speed);
//		Robot.bottomShooter.setSpeed(speed);
	}

	@Override
	protected void execute() {
//		SmartDashboard.putNumber("pidError", Robot.topShooter.getEncoder() + Math.random() / 1e9);
//		System.out.println(Robot.topShooter.getEncoder() + " " + Robot.bottomShooter.getEncoder());
	}

	@Override
	protected boolean isFinished() {
//		double encoder = Robot.topShooter.getEncoder();
//		double setpoint = Robot.topShooter.getSetpoint();
//		if(encoder < setpoint && setpoint < lastEncoder) {
//			return true;
//		}
//		lastEncoder = encoder;
		return isTimedOut();
	}

	@Override
	protected void end() {
		if(!isTimedOut()) {
			Robot.topShooter.stop();
//			Robot.bottomShooter.stop();
		}
	}

	@Override
	protected void interrupted() {
//		end();		
	}

}
