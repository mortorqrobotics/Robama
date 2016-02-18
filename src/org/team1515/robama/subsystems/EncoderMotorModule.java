package org.team1515.robama.subsystems;

import org.team1515.robama.Pair;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;

public class EncoderMotorModule extends MotorModule {
	
	protected Encoder encoder;
	
	public EncoderMotorModule(int[] motorPorts, Pair<Integer> encoderPorts) {
		super(motorPorts);

		encoder = new Encoder(encoderPorts.first, encoderPorts.last);
		encoder.setMaxPeriod(.05);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(1);
		encoder.setSamplesToAverage(10);
		encoder.setPIDSourceType(PIDSourceType.kRate);
		encoder.reset();
	}
    
    public void resetEncoder() {
    	encoder.reset();
    }
    
    public double getEncoderRate() {
    	return encoder.getRate();
    }

}
