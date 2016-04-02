package org.team1515.robama.commands.movement;

import org.team1515.robama.Robot;

/**
 *
 */
public class RotateRight extends MovementCommand {
	
	double speed;

    public RotateRight(int ticks, double speed) {
    	super(ticks);
        requires(Robot.driveTrain);
        this.speed = speed;
    }

    protected boolean run() {
    	return Robot.driveTrain.rotateRight(ticks, speed);
    }
}
