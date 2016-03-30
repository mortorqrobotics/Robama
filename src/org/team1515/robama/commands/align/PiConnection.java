package org.team1515.robama.commands.align;

import edu.wpi.first.wpilibj.SerialPort;

public class PiConnection {
	
	SerialPort port;
	boolean expectingAngle;
	
	static final String RES_START_SIGNAL = "ANGLE";
	static final String RES_END_SIGNAL = "$";
	static final String REQ_ANGLE_SIGNAL = "A";
	static final String REQ_COPY_SIGNAL = "B";
	
    public PiConnection() {
    	initPort();
    }
    
    private void initPort() {
    	port = new SerialPort(9600, SerialPort.Port.kMXP); // 10 and 14
    }

    public void sendAngleRequest() {
    	if (!expectingAngle) {
    		port.writeString(REQ_ANGLE_SIGNAL);
    	}
    }
    
    public void sendCopyRequest() {
    	port.writeString(REQ_COPY_SIGNAL);
    }
    
    public void update() {
    	if (!expectingAngle) {
    		return;
    	} 
    	expectingAngle = false;
    	try {
	    	String input = port.readString();
	    	int start = input.indexOf(RES_START_SIGNAL);
	    	if (start != -1) {
	    		int end = input.indexOf(RES_END_SIGNAL);
	    		if (end != -1) {
	    			try {
	    				double angle = Double.parseDouble(input.substring(
	    					start + RES_START_SIGNAL.length(), end
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
