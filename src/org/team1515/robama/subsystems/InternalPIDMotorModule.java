package org.team1515.robama.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDSourceType;

public class InternalPIDMotorModule extends PIDMotorModule {
	
	CANTalon talon;

	public InternalPIDMotorModule(int motorPort, double factor, PIDSourceType pidSourceType, double p, double i, double d) {
		super(new int[] {motorPort}, factor, pidSourceType, p, i, d);
		
		talon = talons[0];
	}

	public double pidGet() {
		if(getPIDSourceType().equals(PIDSourceType.kRate)) {
			return talon.getEncVelocity();
		}
		else {
			return talon.getEncPosition();
		}
	}

	public void resetEncoder() {
		talon.setEncPosition(0);
	}

}
