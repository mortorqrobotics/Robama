package org.team1515.robama.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Delay extends Command {
	
	public Delay() {
		
	}
	
	public Delay(double time) {
		setTimeout(time);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		end();
	}

}
