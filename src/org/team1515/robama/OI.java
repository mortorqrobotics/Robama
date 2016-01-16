package org.team1515.robama;

import org.team1515.robama.commands.Shoot;
import org.team1515.robama.commands.ReverseDrive;

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
		fastShoot,
		slowShoot,
		reverseDriveTrain;
	
	public OI() {		
		fastShoot = new JoystickButton(stick1, RobotMap.BUTTON_FAST_SHOOT);
		fastShoot.whileHeld(new Shoot(1));
	
		slowShoot = new JoystickButton(stick1, RobotMap.BUTTON_SLOW_SHOOT);
		slowShoot.whileHeld(new Shoot(0.5));
		
		reverseDriveTrain = new JoystickButton(stick1, 12);
		reverseDriveTrain.whenPressed(new ReverseDrive());
	}
}

