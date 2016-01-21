package org.team1515.robama.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeMode extends CommandGroup {
	public IntakeMode(double intakeSpeed, double dropSpeed, int dropTime) {
		addParallel(new StartIntake(intakeSpeed));
		addParallel(new DropBoulderRamp(dropSpeed, dropTime));
	}
}
