package org.team1515.robama.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoShoot extends CommandGroup {
	
	public AutoShoot() {
		addSequential(new PrepShooter());
		addSequential(new Shoot(), 2);
	}
	
}