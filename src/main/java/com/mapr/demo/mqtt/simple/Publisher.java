package com.mapr.demo.mqtt.simple;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.*;
 // publisher is the broker
public class Publisher {
	
  public static void main(String[] args) throws MqttException, IOException, JSONException {
	JSONObject data= new JSONObject();

	data.put("test2",20); 

	String messageString = data.toString();
    
    System.out.println(messageString);
    

    if (args.length == 2 ) {
      messageString = args[1];
    }


    System.out.println("== START PUBLISHER ==");


    MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
    client.connect();
    MqttMessage message = new MqttMessage();
    message.setPayload(data.toString().getBytes());
    client.publish("iot_data", message);

 
    client.disconnect();

    System.out.println("== END PUBLISHER ==");

  }

  
}
