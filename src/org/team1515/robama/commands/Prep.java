package org.team1515.robama.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Prep extends CommandGroup {
	
	public Prep() {
		addParallel(new PrepShooter(), 2);
		addParallel(new PrepBottom());
	}

}
