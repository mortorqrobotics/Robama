package org.team1515.robama.commands;

import org.team1515.robama.Robot;

public class PrepShooter extends ActionCommand {
	
	public PrepShooter(double speed) {
		super(() -> {
			Robot.shooter.setPrepping(!Robot.shooter.isPrepping());
			if(Robot.shooter.isPrepping()) {
				Robot.shooter.setTop(speed);
			}
			else {
				Robot.shooter.stopTop();
			}
		}, Robot.shooter);
	}

	/*private double speed;
	
	public PrepShooter(double speed) {
		this.speed = speed;
		requires(Robot.shooter);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		if(!Robot.stick2.getRawButton(RobotMap.BUTTON_SHOOT)) {
			Robot.shooter.stop();
		}
		//Robot.shooter.stopTop();
	}

	@Override
	protected void interrupted() {
		end();		
	}*/

}
