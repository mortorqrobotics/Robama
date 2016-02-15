package org.team1515.robama;

import org.team1515.robama.commands.AutoShoot;
import org.team1515.robama.commands.FlattenRamp;
import org.team1515.robama.commands.IntakeBall;
import org.team1515.robama.commands.PrepShooter;
import org.team1515.robama.commands.PurgeIntake;
import org.team1515.robama.commands.ReverseDrive;
import org.team1515.robama.commands.Shoot;
import org.team1515.robama.commands.TiltRamp;
import org.team1515.robama.commands.TimedPurge;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Button
		reverseDriveTrain,
		shoot,
		autoShoot,
		prepShooter,
		intake,
		purgeIntake,
		tilt,
		flatten,
		smallPurge;
	
	public OI() {		
		
		reverseDriveTrain = new JoystickButton(Robot.stick1, RobotMap.BUTTON_REVERSE_DRIVE);
		reverseDriveTrain.whenPressed(new ReverseDrive());
		
		shoot = new JoystickButton(Robot.stick2, RobotMap.BUTTON_SHOOT);
		shoot.whileHeld(new Shoot(1));
		
		autoShoot = new JoystickButton(Robot.stick2, RobotMap.BUTTON_AUTOSHOOT);
		autoShoot.whenPressed(new AutoShoot());
		
		prepShooter = new JoystickButton(Robot.stick2, RobotMap.BUTTON_PREP);
		prepShooter.whenPressed(new PrepShooter(1));
		
		intake = new JoystickButton(Robot.stick2, RobotMap.BUTTON_INTAKE);
		intake.whileHeld(new IntakeBall());
		
		purgeIntake = new JoystickButton(Robot.stick2, RobotMap.BUTTON_PURGE);
		purgeIntake.whileHeld(new PurgeIntake());
		
		tilt = new JoystickButton(Robot.stick2, RobotMap.BUTTON_RAMP_TILT);
		tilt.whenPressed(new TiltRamp());
		
		flatten = new JoystickButton(Robot.stick2, RobotMap.BUTTON_RAMP_FLATTEN);
		flatten.whenPressed(new FlattenRamp());
		
		Config.setDefault("purgeTime", 60);		
		smallPurge = new JoystickButton(Robot.stick2, RobotMap.BUTTON_SMALL_PURGE); // untested
		smallPurge.whenPressed(new TimedPurge());
	}
}

