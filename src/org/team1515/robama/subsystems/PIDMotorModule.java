package org.team1515.robama.subsystems;

import org.team1515.robama.Pair;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

public class PIDMotorModule extends EncoderMotorModule implements PIDOutput {
	
	private PIDController pid;
	
	public PIDMotorModule(int[] motorPorts, Pair<Integer> encoderPorts) { // take in max encoder rate?
		super(motorPorts, encoderPorts);

		pid = new PIDController(0, 0, 0, encoder, this);
		pid.enable();
	}
	
	public double getPIDError() {
		return pid.getError();
	}
	
	public void pidWrite(double value) {
    	for(CANTalon talon : talons) {
    		talon.pidWrite(value / 450); // need correct calculation
    	}
    }
	
	public void setSpeed(double speed) {
		pid.setSetpoint(speed * 450); // need correct calculation
	}
    
    public void setPID(double p, double i, double d) {
    	pid.setPID(p, i, d);
    }

}
