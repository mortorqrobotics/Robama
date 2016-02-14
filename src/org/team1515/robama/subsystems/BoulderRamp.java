package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BoulderRamp extends Subsystem {
	
	private DoubleSolenoid solenoid;
	private Compressor comp;
	
	public BoulderRamp() {
		comp = new Compressor(11); // magic number, change this
		comp.setClosedLoopControl(true);
		solenoid = new DoubleSolenoid(RobotMap.RAMP_SOLENDOID.first, RobotMap.RAMP_SOLENDOID.last);
	}
	
	public void tilt() {
		solenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void flatten() {
		solenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void stop() {
		solenoid.set(DoubleSolenoid.Value.kOff);
	}
	
	protected void initDefaultCommand() {
		
	}

}
