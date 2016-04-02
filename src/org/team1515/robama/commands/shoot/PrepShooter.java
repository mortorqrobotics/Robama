package org.team1515.robama.commands.shoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PrepShooter extends CommandGroup {
	
	public PrepShooter() {
		addParallel(new PrepTopShooter(), 2);
		addParallel(new PrepBottom());
	}

}
