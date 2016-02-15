package org.team1515.robama;

import org.team1515.robama.commands.IntakeForward;
import org.team1515.robama.commands.PurgeIntake;
import org.team1515.robama.commands.ReverseDrive;
import org.team1515.robama.commands.ToggleRamp;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Button
		reverseDriveTrain,
		intake,
		purgeIntake,
		toggleShooter,
		smallPurge;
	
	public OI() {		
		
		reverseDriveTrain = new JoystickButton(Robot.stick1, RobotMap.BUTTON_REVERSE_DRIVE);
		reverseDriveTrain.whenPressed(new ReverseDrive());
		
//		shoot = new JoystickButton(Robot.stick2, RobotMap.BUTTON_SHOOT);
//		shoot.whileHeld(new Shoot(1));
//		
//		prepShooter = new JoystickButton(Robot.stick2, RobotMap.BUTTON_PREP);
//		prepShooter.whileHeld(new PrepShooter());
		
		intake = new JoystickButton(Robot.stick2, RobotMap.BUTTON_INTAKE);
		intake.whileHeld(new IntakeForward());
		
		purgeIntake = new JoystickButton(Robot.stick2, RobotMap.BUTTON_PURGE);
		purgeIntake.whileHeld(new PurgeIntake());
		
		toggleShooter = new JoystickButton(Robot.stick2, RobotMap.BUTTON_RAMP_TOGGLE);
		toggleShooter.whenPressed(new ToggleRamp());
		
		smallPurge = new JoystickButton(Robot.stick2, RobotMap.BUTTON_SMALL_PURGE); // untested
		smallPurge.whenPressed(new PurgeIntake((int) Config.getDouble("purgeTime")));
		Config.setDefault("purTime", 100);
	}
}

