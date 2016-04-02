package org.team1515.robama.commands.shoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PrepBottom extends CommandGroup {

	public PrepBottom() {
		addSequential(new TimedPurge());
		addSequential(new PrepBottomShooter(), 1);
	}

}
