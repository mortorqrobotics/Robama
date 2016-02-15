package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BoulderRamp extends Subsystem {
	
	private DoubleSolenoid solenoid;
	private Compressor compressor;
	private boolean isTilted;
	
	public BoulderRamp() {
		compressor = new Compressor(11); // magic number, change this
		compressor.setClosedLoopControl(true);
		solenoid = new DoubleSolenoid(RobotMap.RAMP_SOLENOID.first, RobotMap.RAMP_SOLENOID.last);
		isTilted = false;
	}
	
	public void tilt() {
		solenoid.set(DoubleSolenoid.Value.kForward);
		isTilted = true;
	}
	
	public void flatten() {
		solenoid.set(DoubleSolenoid.Value.kReverse);
		isTilted = false;
	}
	
	public void toggle() {
		if(isTilted) {
			flatten();
		}else{
			tilt();
		}
	}
	
	public void setTilted(boolean tilted) {
		isTilted = tilted;
	}
	
	public boolean isTilted() {
		return isTilted;
	}
	
	public void stop() {
		solenoid.set(DoubleSolenoid.Value.kOff);
	}
	
	protected void initDefaultCommand() {
		
	}

}
