/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author msi
 */
import java.io.FileNotFoundException;  
 import java.io.IOException;  
 import org.rosuda.REngine.*;  
 import org.rosuda.REngine.Rserve.*;  
 import org.rosuda.REngine.Rserve.*; 

 public class RConnector{  
     
   public static void connect()throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());  
       if(c.needLogin()) {  
         System.out.println("Providing Login");  
         c.login("username", "password");
       } 
       REXP exp = c.eval("dbinom(5,20,0.5)");
         System.out.println(exp.asDouble());
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
   }  
 }  
