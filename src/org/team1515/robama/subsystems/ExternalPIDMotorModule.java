package org.team1515.robama.subsystems;

import org.team1515.robama.Pair;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;

public class ExternalPIDMotorModule extends PIDMotorModule {
	
	Encoder encoder;

	public ExternalPIDMotorModule(int[] motorPorts, Pair<Integer> encoderPorts, double factor, PIDSourceType pidSourceType, double p, double i, double d) {
		super(motorPorts, factor, pidSourceType, p, i, d);
		
		encoder = new Encoder(encoderPorts.first, encoderPorts.last);
		encoder.setMaxPeriod(.05);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(1);
		encoder.setSamplesToAverage(10); // does this increase oscillation?
		encoder.setPIDSourceType(getPIDSourceType());
		encoder.reset();
	}
	
	public void setPIDSourceType(PIDSourceType type) {
		super.setPIDSourceType(type);
		if(encoder != null) {
			encoder.setPIDSourceType(type);
		}
	}

	public void resetEncoder() {
		encoder.reset();
	}

	public double pidGet() {
		if(getPIDSourceType().equals(PIDSourceType.kRate)) {
			return encoder.getRate();
		}
		else {
			return encoder.get();
		}
	}

}
