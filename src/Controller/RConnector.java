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
import Model.Card;
import java.io.FileNotFoundException;  
 import java.io.IOException;  
 import org.rosuda.REngine.*;  
 import org.rosuda.REngine.Rserve.*;  
 import org.rosuda.REngine.Rserve.*; 

 public class RConnector{  
     
   public static int[][] withReplacement()throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     int[][] result = new int[Card.nTrials][Card.drawCards];
     int i=0,j=0;
     int[] temp = new int[Card.drawCards];
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());  
       c.voidEval("deck<-c(1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13)");
       while(i<Card.nTrials){
        REXP exp = c.eval("sample(deck,"+Card.drawCards+",replace=TRUE)");
        for(int k=0; k<exp.asIntegers().length; k++){
            temp[k] = exp.asIntegers()[k];
        }
        while(j<Card.drawCards){
            result[i][j] = temp[j];
            j++;
        }
        j=0;
        i++;
       }
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
     return result;
   }  
   public static int[][] withoutReplacement()throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     int[][] result = new int[Card.nTrials][Card.drawCards];
     int i=0,j=0;
     int[] temp = new int[Card.drawCards];
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());  
       c.voidEval("deck<-c(1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13)");
       while(i<Card.nTrials){
        REXP exp = c.eval("sample(deck,"+Card.drawCards+",replace=FALSE)");
        for(int k=0; k<exp.asIntegers().length; k++){
            temp[k] = exp.asIntegers()[k];
        }
        while(j<Card.drawCards){
            result[i][j] = temp[j];
            j++;
        }
        j=0;
        i++;
       }
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
     return result;
   }  
 }  
