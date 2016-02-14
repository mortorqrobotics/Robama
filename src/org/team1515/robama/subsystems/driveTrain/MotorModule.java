package org.team1515.robama.subsystems.driveTrain;

import org.team1515.robama.Config;
import org.team1515.robama.Pair;
import org.team1515.robama.commands.ActionCommand;
import org.team1515.robama.commands.test.TestForward;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    
    public double getPIDError() {
    	if(usePID) {
    		return pid.getError();
    	}
    	return 0;
    }
    
    public void pidWrite(double value) {
    	for(CANTalon talon : talons) {
    		talon.pidWrite(value);
//    		talon.pidWrite(0.25);
    	}
    	
//    	System.out.println("\terror: " + pid.getError() + " " + ((encoder.getRate())) + " setpoint: " + pid.getSetpoint() + " pidGet: " + encoder.pidGet());
    }
    
    public void testPID() {
		Config.setDefault("pidP", pid.getP());
		Config.setDefault("pidI", pid.getI());
		Config.setDefault("pidD", pid.getD());
		Config.setDefault("pidF", pid.getF());
		
		SmartDashboard.putData("updatePID", new ActionCommand(() -> {
			pid.setPID(Config.getDouble("pidP"), Config.getDouble("pidI"), Config.getDouble("pidD"), Config.getDouble("pidF"));
		}));
		
		SmartDashboard.putData("testForward", new TestForward(this));
	}

}
