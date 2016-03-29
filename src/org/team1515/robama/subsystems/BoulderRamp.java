package org.team1515.robama.subsystems;

import org.team1515.robama.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BoulderRamp extends Subsystem {

	private Solenoid solenoid1;
	private Solenoid solenoid2;
	private boolean isTilted;
	
	public BoulderRamp() {
//		Compressor compressor = new Compressor(11);
//		compressor.setClosedLoopControl(true);
		solenoid1 = new Solenoid(11, RobotMap.RAMP_SOLENOID.first);
		solenoid2 = new Solenoid(11, RobotMap.RAMP_SOLENOID.last);
		setTilted(false);
	}
	
	public void tilt() {
//		solenoid.set(DoubleSolenoid.Value.kForward);
		solenoid1.set(false);
		solenoid2.set(true);
		setTilted(true);
	}
	
	public void flatten() {
//		solenoid.set(DoubleSolenoid.Value.kReverse);
		solenoid1.set(true);
		solenoid2.set(false);
		setTilted(false);
	}
	
	public void toggle() {
		if(isTilted) {
			flatten();
		} else {
			tilt();
		}
	}
	
	private void setTilted(boolean tilted) {
		isTilted = tilted;
		SmartDashboard.putBoolean("rampTilted", isTilted);
	}
	
	public boolean isTilted() {
		return isTilted;
	}
	
	public void stop() {
//		solenoid.set(DoubleSolenoid.Value.kOff);
		solenoid1.set(false);
		solenoid2.set(false);
	}
	
	protected void initDefaultCommand() {
		
	}

}
