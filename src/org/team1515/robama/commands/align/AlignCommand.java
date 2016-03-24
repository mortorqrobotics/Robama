package org.team1515.robama.commands.align;

import org.team1515.robama.Robot;

import edu.wpi.first.wpilibj.command.Command;

public abstract class AlignCommand extends Command {
	
	protected double targetAngle;
	
	public AlignCommand(double targetAngle) {
		requires(Robot.driveTrain);
		this.targetAngle = targetAngle;
	}

	@Override
	protected void execute() {

	}

	@Override
	protected void interrupted() {
		end();
	}

}
