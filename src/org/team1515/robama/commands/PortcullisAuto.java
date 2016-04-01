package org.team1515.robama.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PortcullisAuto extends CommandGroup {
	
	public PortcullisAuto() {
		addSequential(new WedgeDown(), 0.5);
		addSequential(new Delay(), 1);
		addSequential(new DriveForwardAuto(0.75), 3.5);
	}

}
