/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsm;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author javier
 */
public class MyListener implements MessageListener {

	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		 
        TextMessage msg = null;
	
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                System.out.println("Recibido asincrono " + msg.getText());
            } else {
                System.err.println("El mensaje no es de tipo texto");
            }
        } catch (JMSException e) {
            System.err.println("JMSException en onMessage(): " + e.toString());
        } catch (Throwable t) {
            System.err.println("Exception en onMessage():" + t.getMessage());
        }
	}
    


}
