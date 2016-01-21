package org.team1515.robama.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeBall extends CommandGroup {
	
	public IntakeBall() {
		addParallel(new DropRamp());
		addSequential(new IntakeForward());
		addSequential(new RaiseRamp());
	}

}
