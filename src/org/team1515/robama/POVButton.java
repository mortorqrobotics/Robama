package org.team1515.robama;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class POVButton extends Button {
	
	Joystick joystick;
	int num;
	
	public POVButton(Joystick joystick, int num) {
		this.joystick = joystick;
		this.num = num;
	}

	@Override
	public boolean get() {
		return joystick.getPOV() == num;
	}

}
