package com.livesoft.smartfarm.mqtt.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.livesoft.smartfarm.mqtt.publisher.MQTTPublisherBase;

 
public interface MQTTSubscriberBase {

	public static final Logger logger = LoggerFactory.getLogger(MQTTPublisherBase.class);

	/**
	 * Subscribe message
	 * 
	 * @param topic
	 * @param jasonMessage
	 */
	public void subscribeMessage(String topic);

	/**
	 * Disconnect MQTT Client
	 */
	public void disconnect();
}
