package org.team1515.robama.subsystems.pid;

import edu.wpi.first.wpilibj.PIDOutput;

public class CumulativePIDOutput implements PIDOutput {

	private PIDOutput pidOutput;
	private double outputSum;
	
	public CumulativePIDOutput(PIDOutput pidOutput) {
		this.pidOutput = pidOutput;
		outputSum = 0;
	}
	
	public void pidWrite(double output) {
		outputSum += output;
		pidOutput.pidWrite(outputSum);
	}
	
	public void reset() {
		outputSum = 0;
	}

}
