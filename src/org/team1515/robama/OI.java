package org.team1515.robama;

import org.team1515.robama.commands.FlattenRamp;
import org.team1515.robama.commands.IntakeBall;
import org.team1515.robama.commands.ReverseDrive;
import org.team1515.robama.commands.Shoot;
import org.team1515.robama.commands.TiltRamp;

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
		intake,
		tilt,
		flatten;
	
	public OI() {		
		
		reverseDriveTrain = new JoystickButton(Robot.stick1, 12);
		reverseDriveTrain.whenPressed(new ReverseDrive());
		
		shoot = new JoystickButton(Robot.stick2, RobotMap.BUTTON_SHOOT);
		shoot.whileHeld(new Shoot(1));
		
		intake = new JoystickButton(Robot.stick2, RobotMap.BUTTON_INTAKE);
		intake.whileHeld(new IntakeBall());
		
		tilt = new JoystickButton(Robot.stick2, RobotMap.BUTTON_RAMP_TILT);
		tilt.whenPressed(new TiltRamp());
		
		flatten = new JoystickButton(Robot.stick2, RobotMap.BUTTON_RAMP_FLATTEN);
		flatten.whenPressed(new FlattenRamp());
	}
}

