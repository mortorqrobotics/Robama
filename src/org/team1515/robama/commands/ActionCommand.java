package org.team1515.robama.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ActionCommand extends Command {
	
	Runnable runnable;
	
	public ActionCommand(Runnable runnable, Subsystem... required) {
		this.runnable = runnable;
		for(Subsystem subsystem : required) {
			requires(subsystem);
		}
	}

	protected void initialize() {
		runnable.run();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {

	}

	protected void interrupted() {
		end();
	}

}
