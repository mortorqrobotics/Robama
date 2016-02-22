package org.team1515.robama.subsystems.pid;

import org.team1515.robama.Pair;

import edu.wpi.first.wpilibj.Encoder;

public class ExternalEncoder extends Encoder implements PIDInput {
	
	public ExternalEncoder(Pair<Integer> encoderPorts, boolean reversed) {
		super(encoderPorts.first, encoderPorts.last);
		setMaxPeriod(.05);
		setMinRate(10);
		setDistancePerPulse(1);
		setSamplesToAverage(10);
		setReverseDirection(reversed);
		reset();
	}
	
	public ExternalEncoder(Pair<Integer> encoderPorts) {
		this(encoderPorts, false);
	}

}
