/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsm;

import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;

/**
 *
 * @author javier
 */
public class Consumidor {
    @Resource(mappedName = "jms/ConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/Queue")
    private static Queue queue;
    
    public void recibirMensajeAsincrono() throws JMSException{
        
        Connection connection = null;
        Session session = null;

        MessageConsumer consumer = null;
        MyListener listener = null;
        boolean esTransaccional = false;
        
        try{
            connection = connectionFactory.createConnection();
             
            //creamos una session sin transaccionalidad y con envio de acuse automatico
            session = connection.createSession(esTransaccional,Session.AUTO_ACKNOWLEDGE);
            
            //creamos el consumidor a partir de una cola 
            consumer = session.createConsumer(queue);
            
            //creamos el listener y lo vinculamos al consumidor asincrono 
            listener = new MyListener();

            consumer.setMessageListener(listener);
            
            //start para empezar a consumir 
            connection.start();
            System.out.println("mensaje "+listener.toString());
        }finally{
            // Cerramos los recursos
            consumer.close();
            session.close();
            connection.close();
        }
    }
    
    public static void main(String[] args) throws Exception {
        Consumidor p = new Consumidor();
        p.recibirMensajeAsincrono();
    }
}
