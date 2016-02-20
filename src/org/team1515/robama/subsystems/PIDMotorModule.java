package org.team1515.robama.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public abstract class PIDMotorModule extends MotorModule implements PIDSource, PIDOutput {

	private double factor;
	private PIDSourceType pidSourceType;
	private PIDController pid;
	private double lastSpeed;
	
	public PIDMotorModule(int[] motorPorts, double factor, PIDSourceType pidSourceType, double p, double i, double d) {
		super(motorPorts);
		
		this.factor = factor;
		setPIDSourceType(pidSourceType);
		pid = new PIDController(p, i, d, this, this);
		
		lastSpeed = 0;
	}
	
	public void setSpeed(double speed) {
		if(speed == 0) {
			pid.disable();
			super.setSpeed(0);
			lastSpeed = 0;
		}
		else {
			speed = Math.max(-1, Math.min(1, speed));
			pid.enable();
			pid.setSetpoint(speed * factor);
		}
	}
	
	public double getPIDError() {
		return pid.getError();
	}
	
	public void setPID(double p, double i, double d) {
		pid.setPID(p, i, d);
	}
	
	public void pidWrite(double value) {
		lastSpeed += value;
    	super.setSpeed(lastSpeed);
    }
	
	public void setPIDSourceType(PIDSourceType type) {
		this.pidSourceType = type;
	}
	
	public PIDSourceType getPIDSourceType() {
		return pidSourceType;
	}
	
	public abstract void resetEncoder();

}
