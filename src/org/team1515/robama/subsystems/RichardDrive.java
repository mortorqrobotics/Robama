package org.team1515.robama.subsystems;

import edu.wpi.first.wpilibj.Joystick;

public class RichardDrive extends MecanumDrive {
	
	public RichardDrive(Joystick joystick) {
		super(joystick);
	}

	protected Triple<Double> getXYZ() {
		double x = joystick.getRawAxis(0); //left/right
		double y = -joystick.getRawAxis(1); //forward/back
		double z = joystick.getRawAxis(5); //twist
		
		if (Math.abs(x) <= DEAD_BAND) {
			x = 0.0;
		}
		if (Math.abs(y) <= DEAD_BAND) {
			y = 0.0;
		}
		if (Math.abs(z) <= DEAD_BAND) {
			z = 0.0;
		}
		
		x *= getThrottle();
		y *= getThrottle();
		z *= getThrottle();
		
		return new Triple<Double>(x, y, z);
	}
	
	public void drive() {
		Triple<Double> triple = getXYZ();
		double x = triple.first * TURNING_SCALE;
		double y = triple.middle * DRIVING_SCALE; // * reverseFactor;
		double z = triple.last * TURNING_SCALE;
		
		/* The following is very wrong, but can be used to understand the motion of mecanum wheels
		 
		if(x == 0 && z == 0 && y != 0){
			setSpeed(y,y,y,y);
		}else if(x != 0 && z == 0 && y == 0){
			setSpeed(x, x, -x, -x);
		}else if(x != 0 && z == 0 && y == 0){
			setSpeed(z, -z, z, -z);
		}else{
			setSpeed(0,0,0,0);
		}
		*/
		
		setSpeed(0,0,0,0); //temporary
 	}

	
}