package com.eidiko;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;

public class SendMessage {
	
	// private final static String JMSCF_JNDI_NAME = "java:comp/env/jms/TheConnectionFactory";
	//    private final static String JMSQ_JNDI_NAME = "java:comp/env/jms/PackageReceivedQueue";
	//    private final static String messageText = "Package Received - 24595023";

	public  void sendMessage(String queueName , String qcfName , String message) throws Exception {
		InitialContext initCtx = new InitialContext();
		
        // Finding the WAS QueueConnectionFactory
        javax.jms.ConnectionFactory qcf = (javax.jms.ConnectionFactory) initCtx.lookup(qcfName);

        // Finding the Queue Destination
        Destination q = (Destination) initCtx.lookup(queueName);

        // Create JMS Connection
        Connection connection = qcf.createConnection("test","test");

        // Create JMS Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create MessageProducer and TextMessage
        MessageProducer queueSender = session.createProducer(q);
        TextMessage outMessage = session.createTextMessage();
        outMessage.setText(message);

        // Set type and destination and send
        outMessage.setJMSType("package_received");
        outMessage.setJMSDestination(q);
        queueSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        queueSender.send(outMessage);
        
        connection.close();    
        System.out.println("Send completed");
	}


}
