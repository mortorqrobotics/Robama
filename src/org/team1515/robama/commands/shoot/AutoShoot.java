package org.team1515.robama.commands.shoot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoShoot extends CommandGroup {
	
	public AutoShoot() {
		
		this.setInterruptible(false);
		
		addSequential(new PrepShooter());
		addSequential(new Shoot(), 2);
	}
	
}