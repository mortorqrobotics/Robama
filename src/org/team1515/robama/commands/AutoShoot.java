package org.team1515.robama.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoShoot extends CommandGroup {
	public AutoShoot() {
		addParallel(new PrepShooter(), 2);
		addSequential(new PrepBottom());
		addSequential(new Shoot(1), 2);
	}
}