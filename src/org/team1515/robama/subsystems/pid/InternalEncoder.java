package org.team1515.robama.subsystems.pid;

import org.team1515.robama.subsystems.MotorModule;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDSourceType;

public class InternalEncoder implements PIDInput {
	
	CANTalon talon;
	PIDSourceType pidSourceType;
	
	public InternalEncoder(MotorModule motors) {
		talon = motors.getFirstTalon();
	}

	public double pidGet() {
		if(pidSourceType.equals(PIDSourceType.kRate)) {
			return talon.getEncVelocity();
		}
		else {
			return talon.getEncPosition();
		}
	}

	public void reset() {
		talon.setEncPosition(0);
	}

	public void setPIDSourceType(PIDSourceType pidSourceType) {
		this.pidSourceType = pidSourceType;
	}

	public PIDSourceType getPIDSourceType() {
		return pidSourceType;
	}

}
