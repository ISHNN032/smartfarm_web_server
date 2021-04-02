package com.livesoft.smartfarm.mqtt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.livesoft.smartfarm.mqtt.subscriber.MQTTSubscriberBase;

@Component
public class MessageListener implements Runnable{

	@Autowired
	MQTTSubscriberBase subscriber;
	
	@Override
	public void run() {
		while(true) {
			subscriber.subscribeMessage("nct2con0000");
		}
		
	}

}
