/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author javier
 */
public class RMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        // TODO code application logic here
        
        //CLIENTE 
        // localiza el stub y usa su interfaz
        
        /* Modos de buscar el stub de un servicio 
    
        Mediante java.rmi.registry.Registry
            Registry registro=LocateRegistry.getRegistry();
            registro.lookup(nombre);
        Mediante java.rmi.Naming
            Naming.lookup(nombre)
        
        */
        InterfaceRemote service = (InterfaceRemote) Naming.lookup("rmi://localhost:5099/hello");
        System.out.println("--- "+service.ejemplo("servidor")+" "+service.getClass().getName());
        System.out.println("`---"+service.suma(5, 10)+" "+service.getClass().getName());
    }
    
}
