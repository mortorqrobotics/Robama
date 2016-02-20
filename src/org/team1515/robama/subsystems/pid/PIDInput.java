package org.team1515.robama.subsystems.pid;

import edu.wpi.first.wpilibj.PIDSource;

public interface PIDInput extends PIDSource {
	
	void reset();
	
}
