package org.team1515.robama;

import org.team1515.robama.commands.ActionCommand;
import org.team1515.robama.commands.AutoShoot;
import org.team1515.robama.commands.ButtonRotate;
import org.team1515.robama.commands.Center;
import org.team1515.robama.commands.IntakeForward;
import org.team1515.robama.commands.PrepShooter;
import org.team1515.robama.commands.PurgeIntake;
import org.team1515.robama.commands.ReverseDrive;
import org.team1515.robama.commands.ToggleRamp;
import org.team1515.robama.commands.WedgeDown;
import org.team1515.robama.commands.WedgeUp;
import org.team1515.robama.subsystems.State;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue.
 */
public class OI {
	
	private Button
		reverseDriveTrain,
		shoot,
//		autoShoot,
//		prepShooter,
		intake,
		purgeIntake,
		toggleShooter,
//		timedPurge,
		wedgeDown,
		wedgeUp,
		prePrep,
		increasePower,
		decreasePower,
		align,
		center,
		leftRotate,
		rightRotate;
	
	public OI() {
		
		reverseDriveTrain = new JoystickButton(Robot.stick1, RobotMap.BUTTON_REVERSE_DRIVE);
		reverseDriveTrain.whenPressed(new ReverseDrive());
		
		shoot = new AxisButton(Robot.stick2, RobotMap.AXIS_SHOOT, 0.5, 0.5);
//		shoot.whileHeld(new Shoot(1));
		shoot.whenPressed(new AutoShoot());
		
//		autoShoot = new JoystickButton(Robot.stick2, RobotMap.BUTTON_AUTOSHOOT);
//		autoShoot.whenPressed(new AutoShoot());
		
//		prepShooter = new AxisButton(Robot.stick2, RobotMap.AXIS_PREP, 0.5, 0.5);
//		prepShooter.whenPressed(new ActionCommand(() -> {
//			if(Robot.topShooter.getState().equals(State.REST)) {
//				new PrepShooter().start();
//			}
//			else {
//				Robot.topShooter.stop();
//				Robot.topShooter.setState(State.REST);
//			}
//		}));
		
		intake = new JoystickButton(Robot.stick2, RobotMap.BUTTON_INTAKE);
		intake.whileHeld(new IntakeForward());
		
		purgeIntake = new JoystickButton(Robot.stick2, RobotMap.BUTTON_PURGE);
		purgeIntake.whileHeld(new PurgeIntake());
		
		toggleShooter = new JoystickButton(Robot.stick2, RobotMap.BUTTON_RAMP_TOGGLE);
		toggleShooter.whenPressed(new ToggleRamp());
		
//		Config.setDefault("purgeTime", 100);		
//		timedPurge = new JoystickButton(Robot.stick2, RobotMap.BUTTON_TIMED_PURGE);
//		timedPurge.whenPressed(new TimedPurge());

		wedgeDown = new JoystickButton(Robot.stick2, RobotMap.BUTTON_WEDGE_DOWN);
		wedgeDown.whileHeld(new WedgeDown());
		
		wedgeUp = new JoystickButton(Robot.stick2, RobotMap.BUTTON_WEDGE_UP);
		wedgeUp.whileHeld(new WedgeUp());
		
		prePrep = new JoystickButton(Robot.stick2, RobotMap.BUTTON_PREPREP);
		prePrep.whenPressed(new ActionCommand(() -> {
			Robot.topShooter.togglePrePrep();
		}));
		
		increasePower = new POVButton(Robot.stick2, 0); // up
		increasePower.whenPressed(new ActionCommand(() -> {
			Robot.topShooter.increaseShootPower(1);
		}));
		
		decreasePower = new POVButton(Robot.stick2, 180); // down
		decreasePower.whenPressed(new ActionCommand(() -> {
			Robot.topShooter.increaseShootPower(-1);
		}));
		
//		boolean aligning = false;
		align = new JoystickButton(Robot.stick1, RobotMap.BUTTON_ALIGN);
		align.whenPressed(new ActionCommand(() -> {
//			aligning = !aligning;
//			if(aligning) {
				Robot.rpi.sendAngleRequest();
//			}
//			else {
//				Robot.driveTrain.stop();
//			}
//			new GyroAlign(Robot.vision.getAngle()).start();
		}));
		
		center = new JoystickButton(Robot.stick1, RobotMap.BUTTON_CENTER);
		center.whenPressed(new Center());
		
		leftRotate = new JoystickButton(Robot.stick1, RobotMap.BUTTON_LEFT_ROTATE);
		leftRotate.whileHeld(new ButtonRotate(-1, 1));
		
		rightRotate = new JoystickButton(Robot.stick1, RobotMap.BUTTON_RIGHT_ROTATE);
		rightRotate.whileHeld(new ButtonRotate(1, -1));
		
	}
}

