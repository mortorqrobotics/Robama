package org.team1515.robama.subsystems;

import edu.wpi.first.wpilibj.CANTalon;

public class MotorModule {
	
    protected CANTalon[] talons;
    
    public MotorModule(int[] motorPorts) {
    	
    	talons = new CANTalon[motorPorts.length];
    	for(int i = 0; i < motorPorts.length; i++) {
    		talons[i] = new CANTalon(motorPorts[i]);
    		talons[i].setSafetyEnabled(false);
    	}
    }
    
    public void setSpeed(double speed){
		speed = Math.max(-1, Math.min(1, speed));
        for(CANTalon talon : talons) {
           	talon.set(speed);
        }
    }
    
    public void stop(){
        setSpeed(0.0);
    }

}
