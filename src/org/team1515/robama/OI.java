package org.team1515.robama;

import org.team1515.robama.commands.ReverseDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick stick1;
	Joystick stick2;
	
	Button reverse;
	
	public OI() {
		stick1 = new Joystick(0);
		stick2 = new Joystick(1);
		
		reverse = new JoystickButton(stick1, 12);
		reverse.whenPressed(new ReverseDrive());
	}

}

