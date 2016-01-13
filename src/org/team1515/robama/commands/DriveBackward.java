package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBackward extends MovementCommand {

	double speed;
	
    public DriveBackward(int ticks, double speed) {
    	super(ticks);
    	requires(Robot.driveTrain);
    	this.speed = speed;
    }

    protected boolean run() {
    	return Robot.driveTrain.driveBackward(ticks, speed);
    }
}