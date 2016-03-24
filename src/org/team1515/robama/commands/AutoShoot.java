package org.team1515.robama.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoShoot extends CommandGroup {
	public AutoShoot() {
		addSequential(new TimedPurge());
		addSequential(new PrepBottomShooter(1), 1);
		addSequential(new WaitForPrep());
		addSequential(new Shoot(1));
	}
}