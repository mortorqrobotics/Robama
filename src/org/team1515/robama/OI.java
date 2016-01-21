package org.team1515.robama;

import org.team1515.robama.commands.DropRamp;
import org.team1515.robama.commands.RaiseRamp;
import org.team1515.robama.commands.ReverseDrive;
import org.team1515.robama.commands.SetIntake;
import org.team1515.robama.commands.Shoot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static final Joystick stick1 = new Joystick(0);
	public static final Joystick stick2 = new Joystick(1);
	
	private Button 
		shoot,
		reverseDriveTrain,
		intakeMode;
	
	public OI() {		
		shoot = new JoystickButton(stick1, RobotMap.BUTTON_SHOOT);
		shoot.whileHeld(new Shoot(1));
		
		intakeMode = new JoystickButton(stick1, RobotMap.BUTTON_INTAKE_MODE);
		intakeMode.whileHeld(new SetIntake(1));
		intakeMode.whenPressed(new DropRamp());
		intakeMode.whenReleased(new RaiseRamp());
		
		reverseDriveTrain = new JoystickButton(stick1, 12);
		reverseDriveTrain.whenPressed(new ReverseDrive());
	}
}

