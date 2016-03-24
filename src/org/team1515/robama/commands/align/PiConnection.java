package org.team1515.robama.commands.align;

import edu.wpi.first.wpilibj.SerialPort;

public class PiConnection {
	
	SerialPort port;
	
	final String START_SIGNAL = "ANGLE";
	final String END_SIGNAL = "$";
	final String SEND_SIGNAL = "A";
	
    public void robotInit() {
    	port = new SerialPort(9600, SerialPort.Port.kMXP); // 10 and 14
    }

    public void sendAngleRequest() {
    	port.writeString(SEND_SIGNAL);
    }
    
    public void update() {
    	String input = port.readString();
    	int start = input.indexOf(START_SIGNAL);
    	if (start != -1) {
    		int end = input.indexOf(END_SIGNAL);
    		if (end != -1) {
    			try {
    				double angle = Double.parseDouble(input.substring(
    					start + START_SIGNAL.length(), end
    				));
    				new GyroAlign(angle).start();
    			} catch (NumberFormatException ex) {
    				ex.printStackTrace();
    			}
    		}
    	}
    }
    
}
