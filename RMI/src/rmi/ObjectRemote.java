/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author javier
 */
public class ObjectRemote extends UnicastRemoteObject implements InterfaceRemote{

    // implementa la interfaz del servidor 
    
    //OBJETO REMOTO
    public ObjectRemote () throws RemoteException{
    super();
    }
        
    @Override
    public String ejemplo(String input) throws RemoteException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        return "Desde el servidor: "+input;
    }

    @Override
    public int suma(int a, int b) throws RemoteException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Sumando "+a+" + "+b);
        return a+b;
    }
    
}
