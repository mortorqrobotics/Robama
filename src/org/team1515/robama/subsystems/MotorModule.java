package org.team1515.robama.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class MotorModule extends PIDSubsystem implements PIDOutput {
	
    private CANTalon[] talons;
    private Encoder encoder;
    
    public MotorModule(double p, double i, double d, int... ports) {
    	super(p, i, d);
    
    	talons = new CANTalon[ports.length];
    	for(int port = 0; port < ports.length; port++) {
    		talons[port] = new CANTalon(ports[port]);
    	}
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
    
    public Encoder getEncoder() {
    	return encoder;
    }
    
    public void pidWrite(double value) {
    	for(int i = 0; i < talons.length; i++) {
    		talons[i].pidWrite(value);
    	}
    }

	protected double returnPIDInput() {
		return encoder.get();
	}

	protected void usePIDOutput(double output) {
		
		
	}

	protected void initDefaultCommand() {
		
		
	}
}
