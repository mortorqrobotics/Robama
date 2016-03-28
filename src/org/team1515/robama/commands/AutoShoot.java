package org.team1515.robama.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoShoot extends CommandGroup {
	public AutoShoot() {
		addSequential(new Prep());
		addSequential(new Shoot(1), 2);
	}
}