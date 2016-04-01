package org.team1515.robama.commands.auto;

import org.team1515.robama.commands.Delay;
import org.team1515.robama.commands.WedgeDown;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CDFAuto extends CommandGroup {
	
	private static final double DRIVE_TIME = 0.6; // 74 inches to back of robot
	
	public CDFAuto() {
		addSequential(new DriveForwardAuto(0.5), DRIVE_TIME);
		addSequential(new Delay(), 1);
		addSequential(new WedgeDown(), 0.5);
		addSequential(new Delay(), 1);
		addSequential(new DriveForwardAuto(0.75), 1.5);
	}

}
