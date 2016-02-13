package org.team1515.robama.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BoulderRamp extends Subsystem {
	
	private DoubleSolenoid solenoid;
	
	public BoulderRamp() {
		solenoid = new DoubleSolenoid(0, 1);
	}
	
	public void tilt() {
		solenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void straighten() {
		solenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void stop() {
		solenoid.set(DoubleSolenoid.Value.kOff);
	}
	
	protected void initDefaultCommand() {
		
	}

}
