package org.team1515.robama.subsystems.pid;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSourceType;

public class RatePID extends PID {
	
	private double speedFactor;

	public RatePID(PIDOutput pidOutput, PIDInput pidInput, double p, double i, double d, double speedFactor) {
		super(new CumulativePIDOutput(pidOutput), pidInput, p, i, d);
		
		this.speedFactor = speedFactor;

		pidInput.setPIDSourceType(PIDSourceType.kRate);
	}
	
	public void setSetpoint(double speed) {
		if(speed == 0) {
			disable();
		}
		else {
			speed = Math.max(-1, Math.min(1, speed));
			enable();
			super.setSetpoint(speed * speedFactor);
		}
	}
	
	public void disable() {
		if(pidOutput instanceof CumulativePIDOutput) {
			((CumulativePIDOutput) pidOutput).reset();
		}
		super.disable();
	}

}
