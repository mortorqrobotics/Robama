package org.team1515.robama.config;

public interface Configurable {
	public void reloadConfig(Config config);
	public ConfigurableVariable[] registerVariables();
}