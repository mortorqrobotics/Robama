package org.team1515.robama;

import org.team1515.robama.commands.AutoShoot;
import org.team1515.robama.commands.IntakeForward;
import org.team1515.robama.commands.PrepShooter;
import org.team1515.robama.commands.PurgeIntake;
import org.team1515.robama.commands.ReverseDrive;
import org.team1515.robama.commands.Shoot;
import org.team1515.robama.commands.TimedPurge;
import org.team1515.robama.commands.ToggleRamp;
import org.team1515.robama.commands.WedgeUp;
import org.team1515.robama.commands.WedgeDown;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue.
 */
public class OI {
	
	private Button
		reverseDriveTrain,
		shoot,
		autoShoot,
		prepShooter,
		intake,
		purgeIntake,
		toggleShooter,
		timedPurge,
		wedgeDown,
		wedgeUp;
	
	public OI() {		
		
		reverseDriveTrain = new JoystickButton(Robot.stick1, RobotMap.BUTTON_REVERSE_DRIVE);
		reverseDriveTrain.whenPressed(new ReverseDrive());
		
		shoot = new AxisButton(Robot.stick2, RobotMap.AXIS_SHOOT, 0.5, 0.5);
		shoot.whileHeld(new Shoot(1));
		
		autoShoot = new JoystickButton(Robot.stick2, RobotMap.BUTTON_AUTOSHOOT);
		autoShoot.whenPressed(new AutoShoot());
		
		prepShooter = new AxisButton(Robot.stick2, RobotMap.AXIS_PREP, 0.5, 0.5);
		prepShooter.whileHeld(new PrepShooter(1));
		
		intake = new JoystickButton(Robot.stick2, RobotMap.BUTTON_INTAKE);
		intake.whileHeld(new IntakeForward());
		
		purgeIntake = new JoystickButton(Robot.stick2, RobotMap.BUTTON_PURGE);
		purgeIntake.whileHeld(new PurgeIntake());
		
		toggleShooter = new JoystickButton(Robot.stick2, RobotMap.BUTTON_RAMP_TOGGLE);
		toggleShooter.whenPressed(new ToggleRamp());
		
		Config.setDefault("purgeTime", 60);		
		timedPurge = new JoystickButton(Robot.stick2, RobotMap.BUTTON_TIMED_PURGE);
		timedPurge.whenPressed(new TimedPurge());

		wedgeDown = new JoystickButton(Robot.stick2, RobotMap.BUTTON_WEDGE_DOWN);
		wedgeDown.whileHeld(new WedgeDown());
		
		wedgeUp = new JoystickButton(Robot.stick2, RobotMap.BUTTON_WEDGE_UP);
		wedgeUp.whileHeld(new WedgeUp());
	}
}

