# Connecting Mqtt and Esper

## Prerequisite

* Maven 3.3.x
* Install a MQTT Broker, for example [Mosquitto](https://mosquitto.org/)
* Download and include the Esper jar files
    
    
## Build and run the application

**1- Run the MQTT broker**

**2- Build the project with Apache Maven:**

This project is a simple Java application that runs a publisher and subscriber using the [Eclipse Paho library](https://eclipse.org/paho/).


```
$ mvn clean package
```

For convenience, the example programs project is set up so that the maven package target produces a single executable, 
`/mqtt-sample `, that includes all of the example programs and dependencies.

**3- Run Esper**

**4- Run the Subscriber**

The subscriber will received and print all the messages published on the `iot_data` topic.

```
$ ./target/mqtt-sample subscriber
```

**5- Run the Publisher**

Run the publisher with the following command, the second parameter is the message to publish

```
$ ./target/mqtt-sample publisher "My first MQTT message..."
```