package org.team1515.robama;

import org.team1515.robama.commands.ActionCommand;
import org.team1515.robama.commands.AutoShoot;
import org.team1515.robama.commands.ButtonRotate;
import org.team1515.robama.commands.Center;
import org.team1515.robama.commands.IntakeForward;
import org.team1515.robama.commands.PurgeIntake;
import org.team1515.robama.commands.ReverseDrive;
import org.team1515.robama.commands.ToggleRamp;
import org.team1515.robama.commands.WedgeDown;
import org.team1515.robama.commands.WedgeUp;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue.
 */
public class OI {
	
	private Button
		reverseDriveTrain,
		shoot,
		intake,
		purgeIntake,
		toggleShooter,
		wedgeDown,
		wedgeUp,
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
		shoot.whenPressed(new AutoShoot());
		
		intake = new JoystickButton(Robot.stick2, RobotMap.BUTTON_INTAKE);
		intake.whileHeld(new IntakeForward());
		
		purgeIntake = new JoystickButton(Robot.stick2, RobotMap.BUTTON_PURGE);
		purgeIntake.whileHeld(new PurgeIntake());
		
		toggleShooter = new JoystickButton(Robot.stick2, RobotMap.BUTTON_RAMP_TOGGLE);
		toggleShooter.whenPressed(new ToggleRamp());

		wedgeDown = new JoystickButton(Robot.stick2, RobotMap.BUTTON_WEDGE_DOWN);
		wedgeDown.whileHeld(new WedgeDown());
		
		wedgeUp = new JoystickButton(Robot.stick2, RobotMap.BUTTON_WEDGE_UP);
		wedgeUp.whileHeld(new WedgeUp());
		
		increasePower = new POVButton(Robot.stick2, 0); // up
		increasePower.whenPressed(new ActionCommand(() -> {
			Robot.topShooter.increaseShootPower(1);
		}));
		
		decreasePower = new POVButton(Robot.stick2, 180); // down
		decreasePower.whenPressed(new ActionCommand(() -> {
			Robot.topShooter.increaseShootPower(-1);
		}));
		
		align = new JoystickButton(Robot.stick1, RobotMap.BUTTON_ALIGN);
		align.whenPressed(new ActionCommand(() -> {
			Robot.rpi.sendAngleRequest();
		}));
		
		center = new JoystickButton(Robot.stick1, RobotMap.BUTTON_CENTER);
		center.whenPressed(new Center());
		
		leftRotate = new JoystickButton(Robot.stick1, RobotMap.BUTTON_LEFT_ROTATE);
		leftRotate.whileHeld(new ButtonRotate(-1, 1));
		
		rightRotate = new JoystickButton(Robot.stick1, RobotMap.BUTTON_RIGHT_ROTATE);
		rightRotate.whileHeld(new ButtonRotate(1, -1));
		
	}
}

