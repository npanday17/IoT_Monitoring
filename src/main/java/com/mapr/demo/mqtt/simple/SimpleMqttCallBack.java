package com.mapr.demo.mqtt.simple;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import pcis.*;

public class SimpleMqttCallBack implements MqttCallback {

  public void connectionLost(Throwable throwable) {
    System.out.println("Connection to MQTT broker lost!");
  }

  public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
	  String msg = new String(mqttMessage.getPayload());
    System.out.println("Message received:\t"+ msg) ;
    JSONObject obj = new JSONObject(msg);
    System.out.println(obj.getDouble("test2"));
    
    TemperatureEvent te = new TemperatureEvent(obj.getDouble("test2"));
    System.out.println(te.getTemperature());
    EsperTest ttt = new EsperTest();
    ttt.testMethod(te);
  }

  public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
  }
}
