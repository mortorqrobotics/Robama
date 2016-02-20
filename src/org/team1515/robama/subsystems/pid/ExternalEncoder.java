package org.team1515.robama.subsystems.pid;

import org.team1515.robama.Pair;

import edu.wpi.first.wpilibj.Encoder;

public class ExternalEncoder extends Encoder implements PIDInput {
	
	public ExternalEncoder(Pair<Integer> encoderPorts) {
		super(encoderPorts.first, encoderPorts.last);
		setMaxPeriod(.05);
		setMinRate(10);
		setDistancePerPulse(1);
		setSamplesToAverage(10);
		reset();
	}

}
