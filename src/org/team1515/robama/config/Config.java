package org.team1515.robama.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config {
	
	Map<String, Object> vars;
	List<Configurable> configurables;
	
	public Config(List<Configurable> configurables) {
		this.vars = new HashMap<String, Object>();
		this.configurables = configurables;
		
		//vars.put("test", 5);
	}
	
	public void reload() {
		//update vars
		for(Configurable configurable : configurables) {
			configurable.reloadConfig(this);
		}
	}
	
	private Object get(String key, Object fallback, Class type) {
		Object value = vars.get(key);
		if(value != null && value.getClass().equals(type)) {
			return value;
		}
		else {
			return fallback;
		}
	}
	
	public int getInt(String key, int fallback) {
		return (int) get(key, fallback, Integer.class);
	}
	
	public double getDouble(String key, double fallback) {
		return (double) get(key, fallback, Double.class);
	}
	
	public boolean getBool(String key, boolean fallback) {
		return (boolean) get(key, fallback, Boolean.class);
	}
}