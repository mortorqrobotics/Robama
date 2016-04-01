package org.team1515.robama.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CDFAuto extends CommandGroup {
	
	public CDFAuto() {
		addSequential(new DriveForwardAuto(0.5), 0.6); // 74 inches to back of robot
		addSequential(new Delay(), 1);
		addSequential(new WedgeDown(), 0.5);
		addSequential(new Delay(), 1);
		addSequential(new DriveForwardAuto(0.75), 1);
	}

}
