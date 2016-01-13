package org.team1515.robama.commands;

import org.team1515.robama.Robot;

/**
 *
 */
public class TurnLeft extends MovementCommand {
	
	double speed;

    public TurnLeft(int ticks, double speed) {
    	super(ticks);
        requires(Robot.driveTrain);
        this.speed = speed;
    }

    protected boolean run() {
    	return Robot.driveTrain.turnLeft(ticks, speed);
    }
}
