package com.livesoft.smartfarm.controllers;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.livesoft.smartfarm.mqtt.publisher.MQTTPublisher;
import com.livesoft.smartfarm.mqtt.subscriber.MQTTSubscriber;

import javax.annotation.PostConstruct;
@Slf4j
@RestController
public class MQTTRestController {
    public static String TOPIC= "smartfarm";
       
    @Autowired
    MQTTPublisher publisher;
    @Autowired
    MQTTSubscriber subscriber;
    
    @PostConstruct
    public void init() {
    	//토픽 구독
        subscriber.subscribeMessage(TOPIC);    
    }
    
    @RequestMapping(value = "/mqtt/message", method = RequestMethod.POST)
    public String index(@RequestBody String data) {
    	//메시지 전송
        publisher.publishMessage(TOPIC, data);
        return "Success";
    }
    
}    