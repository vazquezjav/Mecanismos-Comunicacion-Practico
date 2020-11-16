/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsm;


import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Message;

/**
 *
 * @author javier
 */
public class Productor {
    
    
    @Resource(mappedName = "jms/ConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/Queue")
    private static Queue queue;                
    
    public void enviaMensajeCola(String texto) throws JMSException {
        Connection  connection = null;
        Session session = null;
        
        MessageProducer producer = null;
        Message message = null;
        boolean esTransaccional =  false;
        
        try {
            connection = connectionFactory.createConnection();
            //llamar a start() para permitir el envio de mensajes
            
            connection.start();
            
            //creamos una sesion sin transaccionalidad y con  envio de acuse automatico
            session = connection.createSession(esTransaccional, Session.AUTO_ACKNOWLEDGE);
            
            //creamos el productor a partir de una cola 
            producer = session.createProducer(queue);
            
            //creamos el mensaje de texto
            message = session.createTextMessage(texto);
            
            //mediante el productor le enviamos el mensaje 
            producer.send(message);
            
            System.out.println("Se envio el mensaje:  "+texto);
                    
        } finally {
            // Cerramos los recursos
            //producer.close();
            //session.close();
            //connection.close();
        }
    }
    public static void main(String[] args) throws Exception {
        Productor p = new Productor();
        p.enviaMensajeCola("Hola Mundo");
        p.enviaMensajeCola(" Mundo");
    }
}
