package org.team1515.robama.subsystems.pid;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSourceType;

public class LocationPID extends PID {

	public LocationPID(PIDOutput pidOutput, PIDInput pidInput, double p, double i, double d) {
		super(pidOutput, pidInput, p, i, d);
		
		pidInput.setPIDSourceType(PIDSourceType.kDisplacement);
	}

}
