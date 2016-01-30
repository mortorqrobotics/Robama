package org.team1515.robama.config;

public enum ConfigurableType {
	
	BOOLEAN, INTEGER, DOUBLE;
	
	public static ConfigurableType fromId(int id) {
		if(id == 0) return BOOLEAN;
		if(id == 1) return INTEGER;
		if(id == 2) return DOUBLE;
		return null;
	}
	
	public static ConfigurableType fromName(String name) {
		if(name.equalsIgnoreCase("boolean")) return BOOLEAN;
		if(name.equalsIgnoreCase("integer")) return INTEGER;
		if(name.equalsIgnoreCase("double")) return DOUBLE;
		return null;
	}
	
	public Object parseValue(String str) {
		if(this == BOOLEAN) return Boolean.parseBoolean(str);	
		else if(this == INTEGER) return Integer.parseInt(str);
		else if(this == DOUBLE) return Double.parseDouble(str);
		return null;
	}
	
	public Class getTypeClass() {
		if(this == BOOLEAN) return Boolean.class;	
		else if(this == INTEGER) return Integer.class;
		else if(this == DOUBLE) return Double.class;
		return null;
	}
}