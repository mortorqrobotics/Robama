package org.team1515.robama;

import java.util.HashMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Config {

	static HashMap<String, Double> defaultValues = new HashMap<String, Double>();
	
	public static void setDefault(String name, double value) {
		defaultValues.put(name, value);
	}
	
	public static void setDouble(String name, double value) {
		SmartDashboard.putNumber(name, value);
	}
	
	public static double getDouble(String name) {
		double defaultValue = 0.0;
		if(defaultValues.containsKey(name)) {
			defaultValue = defaultValues.get(name);
		}
		return SmartDashboard.getNumber(name, defaultValue);
	}
	
	public static void init() {
		for(String key : defaultValues.keySet()) {
			SmartDashboard.putNumber(key, defaultValues.get(key));
		}
	}
	
}
