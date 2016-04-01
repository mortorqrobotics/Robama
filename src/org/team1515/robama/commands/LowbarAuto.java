package org.team1515.robama.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LowbarAuto extends CommandGroup {
	
	public LowbarAuto() {
		addSequential(new WedgeDown(), 0.5);
		addSequential(new Delay(), 1);
		addSequential(new DriveForwardAuto(0.5), 6);
	}

}
