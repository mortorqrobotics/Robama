package org.team1515.robama.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDOutput;

public class MotorModule  implements PIDOutput {
	
    private CANTalon[] talons;
    
    public MotorModule(int encoderPortA, int encoderPortB, int... ports) {  
    	talons = new CANTalon[ports.length];
    	for(int j = 0; j < ports.length; j++) {
    		talons[j] = new CANTalon(ports[j]);
    		talons[j].setSafetyEnabled(false); //stops robot from randomly stopping
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
    
    public void pidWrite(double value) {
    	for(int i = 0; i < talons.length; i++) {
    		talons[i].pidWrite(value);
    	}
    }

	protected void initDefaultCommand() {
		
		
	}
}
