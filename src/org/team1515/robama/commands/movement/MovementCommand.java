package org.team1515.robama.commands.movement;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public abstract class MovementCommand extends Command {

	int ticks;
	boolean isDone;
	
	public MovementCommand(int ticks) {
        requires(Robot.driveTrain);
        this.ticks = ticks;
        isDone = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.resetEncoders();
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	isDone = run();
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
    
    protected abstract boolean run();
}