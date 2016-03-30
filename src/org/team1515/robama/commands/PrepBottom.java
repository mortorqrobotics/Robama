package org.team1515.robama.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PrepBottom extends CommandGroup {

	public PrepBottom() {
		addSequential(new TimedPurge());
		addSequential(new PrepBottomShooter(), 1);
	}

}
