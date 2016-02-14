package org.team1515.robama.subsystems.driveTrain;

import org.team1515.robama.Pair;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

public class MotorModule implements PIDOutput {
	
    private CANTalon[] talons;
	private PIDController pid;
	private Encoder encoder;
	boolean usePID;
    
    public MotorModule(Pair<Integer> encoderPorts, int[] motorPorts, boolean usePID) {
    	talons = new CANTalon[motorPorts.length];
    	for(int i = 0; i < motorPorts.length; i++) {
    		talons[i] = new CANTalon(motorPorts[i]);
    		talons[i].setSafetyEnabled(false);
    	}
    	this.usePID = usePID;
    	
    	encoder = new Encoder(encoderPorts.first, encoderPorts.last);
		encoder.setMaxPeriod(.05);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(1);
		encoder.setSamplesToAverage(10);
		//encoder.setPIDSourceParameter(PIDSource.PIDSourceParameter.kRate); // compile error
		encoder.reset();
		
		if(usePID) {
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
//        System.out.println("b "+ speed + "\t" + speed * 450);
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
    
    public PIDController getPIDController() {
    	if(usePID) {
    		return pid;
    	}
    	return null;
    }
    
    public void pidWrite(double value) {
    	for(CANTalon talon : talons) {
    		talon.pidWrite(value);
//    		talon.pidWrite(0.25);
    	}
    	
//    	System.out.println("\terror: " + pid.getError() + " " + ((encoder.getRate())) + " setpoint: " + pid.getSetpoint() + " pidGet: " + encoder.pidGet());
    }
}