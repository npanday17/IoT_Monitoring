package com.mapr.demo.mqtt.simple;

import java.io.IOException;
import java.io.Serializable;

public class Sensor_Data implements Serializable {
	int value;
	String unit; 
public Sensor_Data(int x, String s)
{
 this.value=x;
 this.unit=s;
}
public  String conversion() {
	  return value+"/"+unit; 
	  
}
}
