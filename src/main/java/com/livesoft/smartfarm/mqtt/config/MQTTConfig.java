package com.livesoft.smartfarm.mqtt.config;


public abstract class MQTTConfig {

	protected final String broker = "broker.hivemq.com";
	protected final int qos = 2;
	protected Boolean hasSSL = false; /* By default SSL is disabled */
	protected Integer port = 1883; /* Default port */
	protected final String userName = "smartfarm";
	protected final String password = "smartfarm@12#$";
	protected final String TCP = "tcp://";
	protected final String SSL = "ssl://";

	/**
	 * Custom Configuration
	 * 
	 * @param broker
	 * @param port
	 * @param ssl
	 * @param withUserNamePass
	 */
	protected abstract void config(String broker, Integer port, Boolean ssl, Boolean withUserNamePass);

	/**
	 * Default Configuration
	 */
	protected abstract void config();
}
