package org.team1515.robama.commands.auto;

import org.team1515.robama.commands.Delay;
import org.team1515.robama.commands.WedgeDown;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PortcullisAuto extends CommandGroup {
	
	public PortcullisAuto() {
		addSequential(new WedgeDown(), 0.5);
		addSequential(new Delay(), 1);
		addSequential(new DriveForwardAuto(0.75), 2.5);
	}

}
