package org.team1515.robama.commands.movement;

import org.team1515.robama.Robot;

/**
 *
 */
public class DriveForward extends MovementCommand {

	double speed;
	
    public DriveForward(int ticks, double speed) {
    	super(ticks);
    	requires(Robot.driveTrain);
    	this.speed = speed;
    }
    
    protected boolean run() {
    	return Robot.driveTrain.driveForward(ticks, speed);
    }
}
