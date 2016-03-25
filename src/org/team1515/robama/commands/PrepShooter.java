package org.team1515.robama.commands;

import org.team1515.robama.Robot;
import org.team1515.robama.subsystems.State;

import edu.wpi.first.wpilibj.command.Command;

public class PrepShooter extends Command {

//	private double lastEncoder;
	double startTime;
//	boolean finished;
	
	public PrepShooter() {
		requires(Robot.topShooter);
//		requires(Robot.bottomShooter);
	}
	
	@Override
	protected void initialize() {
//		if(Robot.topShooter.getState().equals(TopShooter.State.PREP)
//			|| Robot.topShooter.getState().equals(TopShooter.State.PREPPED)) {
//			Robot.topShooter.stop();
//			Robot.topShooter.setState(TopShooter.State.REST);
//			finished = true;
//			return;
//		}
//		finished = false;
		startTime = System.currentTimeMillis();
//		lastEncoder = 0;
		Robot.topShooter.prep();
		Robot.topShooter.setState(State.PREP);
		Robot.topShooter.setPrepStart();
//		Robot.bottomShooter.setMotor(speed);
//		Robot.bottomShooter.setSpeed(speed);
	}

	@Override
	protected void execute() {
//		if(System.currentTimeMillis() - startTime >= 2000) {
//			Robot.topShooter.setState(State.PREPPED);
//		}
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
//		return isTimedOut();
		
//		if(Robot.topShooter.getState().equals(State.REST)) {
//			Robot.topShooter.stop();
//			return true;
//		}
//		return false;
		return true;
	}

	@Override
	protected void end() {
//		if(!isTimedOut()) {
//			Robot.topShooter.stop();
////			Robot.bottomShooter.stop();
//		}
	}

	@Override
	protected void interrupted() {
		System.out.println("C");
//		end();
	}

}
