package jsm;

import javax.jms.JMSException;

public class Main {

	public static void main(String[] args) throws JMSException {
		// TODO Auto-generated method stub
		Productor p = new Productor();
        p.enviaMensajeCola("Hola Mundo");
        p.enviaMensajeCola(" Mundo");
	}

}
