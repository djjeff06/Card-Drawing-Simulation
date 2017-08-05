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
   
   public static int[] binomialWithReplacement()throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     int[] result = new int[Card.nTrials];
     int i=0,j=0;
     int[] temp = new int[Card.drawCards];
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());  
       while(i<Card.nTrials){
        REXP exp = c.eval("rbinom(1,"+Card.drawCards+",0.5)");
        result[i] = exp.asInteger();
        i++;
       }
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
     return result;
   }  
   
   public static int[][] nbinomialWithReplacement()throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     int[][] result = new int[Card.nTrials][Card.drawCards];
     int i=0,j=0;
     int[] temp = new int[Card.drawCards];
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());  
       while(i<Card.nTrials){
        REXP exp = c.eval("rnbinom(1,"+Card.drawCards+",0.5)");
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
   
   public static int[][] multinom()throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     int[][] result = new int[Card.nTrials][Card.drawCards];
     int i=0,j=0;
     int[] temp = new int[Card.drawCards];
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());  
       while(i<Card.nTrials){
        REXP exp  = c.eval("rmultinom(1,14,prob=c(4/52,4/52,4/52,4/52,4/52,4/52,4/52,4/52,4/52,4/52,4/52,4/52,4/52))");
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
   
   public static void createPlot1(int[][] result1,int[][] result2)throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());
       String temp = "";
       int total = 0;
       for(int i=0; i<result1.length; i++){
           total = 0;
           for(int j=0; j<result1[i].length; j++){
               total += result1[i][j];
           }
           if(i==0)
               temp = temp.concat(total+"");
           else
               temp = temp.concat(","+total);
       }
        c.voidEval("y = seq(0,"+(Card.nTrials-1)+",1)");
        c.voidEval("jpeg('NetBeansProjects/MODESTAMC02/plots/desiredtotalfrequency1.jpg',width=500,height=500)");
        c.voidEval("barplot(c("+temp+"),y,main='Actual Results Possible Total Frequency(w/ Replacement)',xlab='Possible Totals',ylab='Frequency',las=1)");
        c.voidEval("dev.off()");
        temp = "";
        for(int i=0; i<result2.length; i++){
           total = 0;
           for(int j=0; j<result2[i].length; j++){
               total += result2[i][j];
           }
           if(i==0)
               temp = temp.concat(total+"");
           else
               temp = temp.concat(","+total);
       }
        c.voidEval("y = seq(0,"+(Card.nTrials-1)+",1)");
        c.voidEval("jpeg('NetBeansProjects/MODESTAMC02/plots/desiredtotalfrequency2.jpg',width=500,height=500)");
        c.voidEval("barplot(c("+temp+"),y,main='Actual Results Possible Total Frequency(w/o Replacement)',xlab='Possible Totals',ylab='Frequency',las=1)");
        c.voidEval("dev.off()");
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
   }  
   
 }  
