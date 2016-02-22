package org.team1515.robama.subsystems.pid;

import org.team1515.robama.subsystems.MotorModule;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDSourceType;

public class InternalEncoder implements PIDInput {
	
	CANTalon talon;
	PIDSourceType pidSourceType;
	boolean reversed;
	
	public InternalEncoder(MotorModule motors, boolean reversed) {
		talon = motors.getFirstTalon();
		this.reversed = reversed;
	}
	
	public InternalEncoder(MotorModule motors) {
		this(motors, false);
	}

	public double pidGet() {
		int reverseFactor = reversed ? -1 : 1;
		if(pidSourceType.equals(PIDSourceType.kRate)) {
			return talon.getEncVelocity() * reverseFactor;
		}
		else {
			return talon.getEncPosition() * reverseFactor;
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
