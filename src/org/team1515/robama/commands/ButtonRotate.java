package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ButtonRotate extends Command {
	
	protected static final double SPEED = 0.3;
	
	private double left;
	private double right;
	
	public ButtonRotate(double left, double right) {
		this.left = left;
		this.right = right;
		requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
		Robot.driveTrain.setSpeed(left * SPEED, right * SPEED);
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
		Robot.driveTrain.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
