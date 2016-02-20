package org.team1515.robama.subsystems.pid;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

public abstract class PID extends PIDController implements PIDOutput {
	
	private PIDInput pidInput;
	
	public PID(PIDOutput pidOutput, PIDInput pidInput, double p, double i, double d) {
		super(p, i, d, pidInput, pidOutput);
	}
	
	public void resetInput() {
		pidInput.reset();
	}
	
	public void pidWrite(double output) {
		setSetpoint(output);
	}
	
}