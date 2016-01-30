package org.team1515.robama.config;

public class ConfigurableVariable {

	private String name;
	private ConfigurableType type;
	private Object defaultValue;
	
	public ConfigurableVariable(String name, ConfigurableType type, Object defaultValue) {
		this.name = name;
		this.type = type;
		this.defaultValue = defaultValue;
	}
	
	public String getName() {
		return name;
	}
	
	public ConfigurableType getType() {
		return type;
	}
	
	public Object getDefaultValue() {
		return defaultValue;
	}
}