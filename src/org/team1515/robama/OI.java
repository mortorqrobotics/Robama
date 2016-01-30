package org.team1515.robama;

import org.team1515.robama.commands.IntakeBall;
import org.team1515.robama.commands.ReverseDrive;
import org.team1515.robama.commands.Shoot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static final Joystick stick1 = new Joystick(1);
	public static final Joystick stick2 = new Joystick(2);
	
	private Button 
		shoot,
		reverseDriveTrain,
		intake;
	
	public OI() {		
		shoot = new JoystickButton(stick1, RobotMap.BUTTON_SHOOT);
		shoot.whileHeld(new Shoot(1));
		
		intake = new JoystickButton(stick1, RobotMap.BUTTON_INTAKE);
		intake.whileHeld(new IntakeBall());
		
		reverseDriveTrain = new JoystickButton(stick1, 12);
		reverseDriveTrain.whenPressed(new ReverseDrive());
	}
}

