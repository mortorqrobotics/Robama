package org.team1515.robama.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class Config {
	
	final String fileLocation = "/config/config.txt";
	
	Map<String, Object> values;
	Map<String, ConfigurableType> vars;
	List<Configurable> configurables;
	NetworkTable valueTable;
	NetworkTable varTable;
	
	public Config(List<Configurable> configurables) {
		this.configurables = configurables;
		this.values = new HashMap<String, Object>();
		this.vars = new HashMap<String, ConfigurableType>();
		readFile();
		registerVariables();
		this.valueTable = NetworkTable.getTable("configValues");
		this.varTable = NetworkTable.getTable("varTable");
	}
	
	public void reload() {
		for(String key : vars.keySet()) {
			Object newValue = valueTable.getValue(key, values.get(key));
			values.put(key, newValue);
		}
		for(Configurable configurable : configurables) {
			configurable.reloadConfig(this);
		}
	}
	
	private void registerVariables() {
		List<ConfigurableVariable> varList = new ArrayList<ConfigurableVariable>();
		for(Configurable configurable : configurables) {
			ConfigurableVariable[] registered = configurable.registerVariables();
			for(ConfigurableVariable var : registered) {
				varList.add(var);
				if(!values.containsKey(var.getName())) {
					values.put(var.getName(), var.getDefaultValue());
					vars.put(var.getName(), var.getType());
				}
			}
		}
		varTable.putValue("varList", varList);
	}
	
	public int getInt(String key) {
		return (int) values.get(key);
	}
	
	public double getDouble(String key) {
		return (double) values.get(key);
	}
	
	public boolean getBool(String key) {
		return (boolean) values.get(key);
	}
	
	private void readFile() {
		try {
			String file = new String(Files.readAllBytes(Paths.get(fileLocation)));
			for(String line : file.split("\n")) {
				line = line.trim();
				int index1 = line.indexOf(";");
				int index2 = line.indexOf(";", index1 + 1);
				String name = line.substring(0, index1);
				ConfigurableType type = ConfigurableType.fromName(line.substring(index1 + 1, index2));
				Object value = type.parseValue(line.substring(index2 + 1));
				values.put(name, value);
			}
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}