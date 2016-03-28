package org.team1515.robama.commands.align;

import edu.wpi.first.wpilibj.SerialPort;

public class PiConnection {
	
	SerialPort port;
	
	static final String START_SIGNAL = "ANGLE";
	static final String END_SIGNAL = "$";
	static final String SEND_SIGNAL = "A";
	static final String COPY_SIGNAL = "B";
	
    public PiConnection() {
    	initPort();
    }
    
    private void initPort() {
    	port = new SerialPort(9600, SerialPort.Port.kMXP); // 10 and 14
    }

    public void sendAngleRequest() {
    	port.writeString(SEND_SIGNAL);
    }
    
    public void sendCopyRequest() {
    	port.writeString(COPY_SIGNAL);
    }
    
    public void update() {
    	try {
	    	String input = port.readString();
	    	int start = input.indexOf(START_SIGNAL);
	    	if (start != -1) {
	    		int end = input.indexOf(END_SIGNAL);
	    		if (end != -1) {
	    			try {
	    				double angle = Double.parseDouble(input.substring(
	    					start + START_SIGNAL.length(), end
	    				));
	    				System.out.println(angle);
	    				new GyroAlign(angle).start();
	    			} catch (NumberFormatException ex) {
	    				ex.printStackTrace();
	    			}
	    		}
	    	}
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		initPort();
    	}
    }
    
}
