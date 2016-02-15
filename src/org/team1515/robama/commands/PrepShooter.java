package org.team1515.robama.commands;

import org.team1515.robama.Robot;
import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class PrepShooter extends Command {
	
	/*
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
		
		this.speed = speed;
	}
	*/

	
	
	public PrepShooter() {
		requires(Robot.shooter);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		if(Robot.stick2.getRawAxis(RobotMap.PREP_AXIS) > 0.5){
			Robot.shooter.prep();
		}
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
//		if(!Robot.stick2.getRawButton(RobotMap.BUTTON_SHOOT)) {
//			Robot.shooter.stop();
//		}
		//Robot.shooter.stopTop();
	}

	@Override
	protected void interrupted() {
		end();		
	}

}
