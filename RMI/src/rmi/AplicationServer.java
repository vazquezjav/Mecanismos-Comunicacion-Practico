/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author javier
 */
public class AplicationServer {
    
    public static void main(String[] args) throws RemoteException{
        
        //asociar el stub al servicio 
        
        Registry registry=  LocateRegistry.createRegistry(5099); //registrar a nuestro cliente 
        registry.rebind("hello", new ObjectRemote());
    }
            
}
