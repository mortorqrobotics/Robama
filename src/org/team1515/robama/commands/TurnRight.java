package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnRight extends Command {
	
	int position;
	double speed;
	boolean isDone;

    public TurnRight(int position, double speed) {
        requires(Robot.driveTrain);
        this.position = position;
        this.speed = speed;
        isDone = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	isDone = Robot.driveTrain.turnRight(position, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isDone;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
