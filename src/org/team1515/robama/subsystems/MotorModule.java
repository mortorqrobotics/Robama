package org.team1515.robama.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

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
		encoder.setPIDSourceParameter(PIDSource.PIDSourceParameter.kRate);
		encoder.reset();
		
		if(usePid) {
			pid = new PIDController(/*-0.0005*/0.005, 0, 0, 0.001111, encoder, this);
			pid.enable();
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
        // hack
        speed = 0.25;
        System.out.println("b "+ speed + "\t" + speed * 450);
        for(CANTalon talon : talons) {

        	if(pid != null) {
//        		pid.setSetpoint(speed * 450);
        		pid.setSetpoint(speed * 450);
        		
        	} else {
            	talon.set(speed);
        		
        	}
        	//talon.pidWrite(speed);
        }
    }
    
    public void stop(){
        setSpeed(0.0);
    }
    
    public void resetEncoder() {
    	encoder.reset();
    }
    
    public double getEncoder() {
//    	return encoder.get();
    	return encoder.getRate();
    }
    
    public void pidWrite(double value) {
    	boolean enabled = true;
    	for(CANTalon talon : talons) {
    		talon.pidWrite(value);
//    		talon.pidWrite(0.25);
    		if(!talon.isAlive())
    			enabled = false;
    	}
    	if(enabled)
    		System.out.print("a " + value);
    	
    	System.out.println("\terror: " + pid.getError() + " " + ((encoder.getRate())) + " setpoint: " + pid.getSetpoint() + " pidGet: " + encoder.pidGet());
    }
}
