package org.team1515.robama.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

public class MotorModule implements PIDOutput {
	
    private CANTalon[] talons;
	private PIDController pid;
	private Encoder encoder;
    
    public MotorModule(Pair<Integer> encoderPorts, int[] motorPorts, boolean usePid) {
    	talons = new CANTalon[motorPorts.length];
    	for(int i = 0; i < motorPorts.length; i++) {
    		talons[i] = new CANTalon(motorPorts[i]);
    		talons[i].setSafetyEnabled(false);
    	}
    	
    	encoder = new Encoder(encoderPorts.first, encoderPorts.last);
		encoder.setMaxPeriod(.05);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(1);
		encoder.setSamplesToAverage(10);
		encoder.reset();
		
		if(usePid) {
			pid = new PIDController(1, 0.1, 0.01, encoder, this);
		}
    }
    
    public MotorModule(Pair<Integer> encoderPorts, int[] motorPorts) {
    	this(encoderPorts, motorPorts, false);
    }
    
    public void setSpeed(double speed){
        if(speed > 1.0){
            speed = 1.0;
        }
        if(speed < -1.0){
            speed = -1.0;
        }
        for(CANTalon talon : talons) {
        	talon.set(speed);
        }
    }
    
    public void stop(){
        setSpeed(0.0);
    }
    
    public void resetEncoder() {
    	encoder.reset();
    }
    
    public int getEncoder() {
    	return encoder.get();
    }
    
    public void pidWrite(double value) {
    	for(CANTalon talon : talons) {
    		talon.pidWrite(value);
    	}
    }
}
