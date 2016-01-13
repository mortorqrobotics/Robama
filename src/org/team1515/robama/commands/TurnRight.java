package org.team1515.robama.commands;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnRight extends MovementCommand {
	
	double speed;

    public TurnRight(int ticks, double speed) {
    	super(ticks);
        requires(Robot.driveTrain);
        this.speed = speed;
    }

    protected boolean run() {
    	return Robot.driveTrain.turnRight(ticks, speed);
    }
}
