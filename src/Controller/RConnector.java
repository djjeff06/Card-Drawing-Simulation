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
     
   public static int denominatorIdeal()throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     int result = 0;
     int[] temp = new int[Card.drawCards];
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());  
       REXP exp = c.eval("perm_without_replacement(52,"+Card.drawCards+")");
       result = exp.asInteger();
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
     return result;
   }  
   
   public static double computeIdealProb(double prob)throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     double result = 0.0;
     int[] temp = new int[Card.drawCards];
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString()); 
       REXP exp = null;
         System.out.println(Card.idealProbability);
         System.out.println(Math.round(Card.idealProbability*Card.nTrials));
       if(Card.experiment == 0)
        exp = c.eval("dbinom("+Math.round(prob*Card.nTrials)+","+Card.nTrials+","+prob+")");
       else
           exp = c.eval("dnbinom("+(Card.nTrials-Card.dtWithRep)+","+Card.dtWithRep+","+prob+")");
       result = exp.asDouble();
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
     return result;
   }  
   
   public static double computeActualProb(int success, int failure, double prob)throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     double result = 0.0;
     int[] temp = new int[Card.drawCards];
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString()); 
       REXP exp = null;
         System.out.println(Card.idealProbability);
         System.out.println(Math.round(Card.idealProbability*Card.nTrials));
       if(Card.experiment == 0)
        exp = c.eval("dbinom("+Card.dtWithRep+","+Card.nTrials+","+prob+")");
       else
           exp = c.eval("dnbinom("+failure+","+success+","+prob+")");
       result = exp.asDouble();
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
     return result;
   }
     
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
   
   public static double binomialWithReplacement(double prob)throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     double result = 0.0;
     int i=0,j=0;
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());  
       REXP exp = null;
       exp = c.eval("");
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
     return result;
   }  
   
   public static int[] nbinomial()throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     int[] result = new int[Card.nTrials];
     int i=0;
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());  
       while(i<Card.nTrials){
        REXP exp = c.eval("rnbinom(1,"+Card.drawCards+",0.5)");
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
   
   public static int[][] hyperWithReplacement()throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     int[][] result = new int[Card.nTrials][Card.drawCards];
     int i=0,j=0;
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());  
       REXP exp = null;
       while(i<Card.nTrials){
           for(int k =0; k<Card.drawCards; k++){
               exp = c.eval("rhyper(1,26,26,1)");
               result[i][k] = exp.asInteger();
           }
           i++;
       }
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
     return result;
   }  
   
   public static int[][] hyperWithoutReplacement()throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     int[][] result = new int[Card.nTrials][Card.drawCards];
     int i=0;
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());  
       REXP exp = null;
       int red = 26, black = 26;
       while(i<Card.nTrials){
           for(int k =0; k<Card.drawCards; k++){
               if(k==0)
                exp = c.eval("rhyper(1,26,26,1)");
               else{
                   exp = c.eval("rhyper(1,"+red+","+black+",1)");
                   if(exp.asInteger() == 0)
                       red--;
                   else
                       black--;
               }
               result[i][k] = exp.asInteger();
           }
           i++;
           red = 26;
           black = 26;
       }
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
     return result;
   }
   
   public static int[][] multinomWRType()throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     int i=0;
     int[][] temp = new int[Card.nTrials][13];
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());  
       while(i<Card.nTrials){
        REXP exp  = c.eval("rmultinom(1,"+Card.drawCards+",prob=c(4/52,4/52,4/52,4/52,4/52,4/52,4/52,4/52,4/52,4/52,4/52,4/52,4/52))");
        for(int k=0; k<exp.asIntegers().length; k++){
            temp[i][k] = exp.asIntegers()[k];
        }
        i++;
       }
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
     return temp;
   }
   
   public static int[][] multinomWORType()throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     int i=0;
     int[][] temp = new int[Card.nTrials][13];
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());  
       int ace=4, two=4, three=4, four=4, five=4, six=4, seven=4, eight=4, nine=4, ten=4, jack=4, queen=4, king=4, deck=52;
       while(i<Card.nTrials){
           for(int j=0; j<Card.drawCards; j++){
               REXP exp  = c.eval("rmultinom(1,1,prob=c("+ace+"/"+deck+","+two+"/"+deck+","+three+"/"+deck+","+four+"/"+deck+","
                       +five+"/"+deck+","+six+"/"+deck+","+seven+"/"+deck+","+eight+"/"+deck+","+nine+"/"+deck+","+ten+"/"+deck+","+jack+"/"+deck+","
                       +queen+"/"+deck+","+king+"/"+deck+"))");
               deck--;
               for(int k=0; k<exp.asIntegers().length; k++){
                    if(exp.asIntegers()[k]==1){
                        temp[i][k] = temp[i][k] + exp.asIntegers()[k];
                        switch(k){
                            case 0:
                                ace--;
                                break;
                            case 1:
                                two--;
                                break;
                            case 2:
                                three--;
                                break;
                            case 3:
                                four--;
                                break;
                            case 4:
                                five--;
                                break;
                            case 5:
                                six--;
                                break;
                            case 6:
                                seven--;
                                break;
                            case 7:
                                eight--;
                                break;
                            case 8:
                                nine--;
                                break; 
                            case 9:
                                ten--;
                                break;
                            case 10:
                                jack--;
                                break; 
                            case 11:
                                queen--;
                                break;
                            case 12:
                                king--;
                                break;
                        }
                    }
                }
           }
           
        i++;
       }
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
     return temp;
   }
   
   public static int[][] multinomWRSuit()throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     int i=0;
     int[][] temp = new int[Card.nTrials][4];
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());  
       while(i<Card.nTrials){
        REXP exp  = c.eval("rmultinom(1,"+Card.drawCards+",prob=c(13/52,13/52,13/52,13/52))");
        for(int k=0; k<exp.asIntegers().length; k++){
            temp[i][k] = exp.asIntegers()[k];
        }
        i++;
       }
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
     return temp;
   }
   
   public static int[][] multinomWORSuit()throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     int i=0;
     int[][] temp = new int[Card.nTrials][4];
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());  
       int diamond=13, heart=13, spade=13, clover=13, deck=52;
       while(i<Card.nTrials){
           for(int j=0; j<Card.drawCards; j++){
               REXP exp  = c.eval("rmultinom(1,1,prob=c("+diamond+"/"+deck+","+heart+"/"+deck+","+spade+"/"+deck+","+clover+"/"+deck+"))");
               deck--;
               for(int k=0; k<exp.asIntegers().length; k++){
                    if(exp.asIntegers()[k]==1){
                        temp[i][k] = temp[i][k] + exp.asIntegers()[k];
                        switch(k){
                            case 0:
                                diamond--;
                                break;
                            case 1:
                                heart--;
                                break;
                            case 2:
                                spade--;
                                break;
                            case 3:
                                clover--;
                                break;
                        }
                    }
                }
           }
           
        i++;
       }
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
     return temp;
   }
   
   public static void createPlot(int[][] result1,int[][] result2)throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
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
        String temp2 = "";
        c.voidEval("y = seq(0,"+(Card.nTrials-1)+",1)");
        for(int i = 0; i<Card.nTrials; i++){
            if(i == Card.nTrials - 1)
                temp2 = "1";
            else
                temp2 = "1,";
        }
        c.voidEval("jpeg('NetBeansProjects/MODESTAMC02/plots/desiredtotalfrequency1.jpg',width=500,height=400)");
        c.voidEval("barplot(c("+temp+"),main='Actual Results Possible Total Frequency(w/ Replacement)',xlab='Possible Totals',ylab='Frequency',las=1)");
        c.voidEval("dev.off()");
        if(result2!=null){
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
            temp2 = "";
            for(int i = 0; i<Card.nTrials; i++){
                if(i == Card.nTrials - 1)
                    temp2 = "1";
                else
                    temp2 = "1,";
            }
            c.voidEval("jpeg('NetBeansProjects/MODESTAMC02/plots/desiredtotalfrequency2.jpg',width=500,height=400)");
            c.voidEval("barplot(c("+temp+"),c("+temp2+"),main='Actual Results Possible Total Frequency(w/o Replacement)',xlab='Possible Totals',ylab='Frequency',las=1)");
            c.voidEval("dev.off()");
        }
        temp = "";
        double d;
        d = Card.actualProbability;
        temp = d+",1.0";
        c.voidEval("jpeg('NetBeansProjects/MODESTAMC02/plots/actualprobability1.jpg',width=500,height=400)");
        c.voidEval("barplot(c("+temp+"),c(1,0),main='Actual Probability Distribution of Possible Totals(w/ Replacement)',xlab='Possible Totals',ylab='Probability',las=1)");
        c.voidEval("dev.off()");
        if(result2!=null){
            temp = "";
            for(int i=0; i<result2.length; i++){
               total = 0;
               for(int j=0; j<result2[i].length; j++){
                   total += result2[i][j];
               }
               d = total/(Card.drawCards*13);
               if(Card.experiment == 0 || Card.experiment == 2 || Card.experiment == 3)
                   d = (double)total/(Card.drawCards);
               if(i==0)
                   temp = temp.concat(d+"");
               else
                   temp = temp.concat(","+d);
           }
            c.voidEval("y = seq(0,"+(Card.nTrials-1)+",1)");
            temp2 = "";
            for(int i = 0; i<Card.nTrials; i++){
                if(i == Card.nTrials - 1)
                    temp2 = "1";
                else
                    temp2 = "1,";
            }
            c.voidEval("jpeg('NetBeansProjects/MODESTAMC02/plots/actualprobability2.jpg',width=500,height=400)");
            c.voidEval("barplot(c("+temp+"),c("+temp2+"),main='Actual Probability Distribution of Possible Totals(w/o Replacement)',xlab='Possible Totals',ylab='Probability',las=1)");
            c.voidEval("dev.off()");
        }
        temp = "";
        d = Card.idealProbability;
        temp = d+",1.0";
        c.voidEval("jpeg('NetBeansProjects/MODESTAMC02/plots/idealprobability1.jpg',width=500,height=400)");
        c.voidEval("barplot(c("+temp+"),c(1,0),main='Ideal Probability Distribution of Possible Totals(w/ Replacement)',xlab='Possible Totals',ylab='Probability',las=1)");
        c.voidEval("dev.off()");
        if(result2!=null){
            temp = "";
            for(int i=0; i<result2.length; i++){
               d = Card.computeIdealProb();
               if(i==0)
                   temp = temp.concat(d+"");
               else
                   temp = temp.concat(","+d);
           }
            c.voidEval("jpeg('NetBeansProjects/MODESTAMC02/plots/idealprobability2.jpg',width=500,height=400)");
            c.voidEval("barplot(c("+temp+"),main='Ideal Probability Distribution of Possible Totals(w/o Replacement)',xlab='Possible Totals',ylab='Probability',las=1)");
            c.voidEval("dev.off()");
        }
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
   }  
   
   public static void createPlot1D(int[] result1,int[] result2)throws RserveException, REXPMismatchException, FileNotFoundException, IOException {  
     RConnection c = new RConnection("localhost", 6311);  
     if(c.isConnected()) {  
       System.out.println("Connected to RServe.");  
       org.rosuda.REngine.REXP x0 = c.eval("R.version.string");  
       System.out.println(x0.asString());
       String temp = "";
       int total = 0;
       for(int i=0; i<result1.length; i++){
           total = result1[i];
           if(i==0)
               temp = temp.concat(total+"");
           else
               temp = temp.concat(","+total);
       }
       String temp2 = "";
        c.voidEval("y = seq(0,"+(Card.nTrials-1)+",1)");
        temp2 = "";
        for(int i = 0; i<Card.nTrials; i++){
            if(i == Card.nTrials - 1)
                temp2 = "1";
            else
                temp2 = "1,";
        }
        c.voidEval("jpeg('NetBeansProjects/MODESTAMC02/plots/desiredtotalfrequency1.jpg',width=500,height=400)");
        c.voidEval("barplot(c("+temp+"),c("+temp2+"),main='Actual Results Possible Total Frequency(w/ Replacement)',xlab='Possible Totals',ylab='Frequency',las=1)");
        c.voidEval("dev.off()");
        if(Card.experiment != 1){
            temp = "";
            for(int i=0; i<result2.length; i++){
               total = result2[i];
               if(i==0)
                   temp = temp.concat(total+"");
               else
                   temp = temp.concat(","+total);
           }
            c.voidEval("y = seq(0,"+(Card.nTrials-1)+",1)");
            c.voidEval("jpeg('NetBeansProjects/MODESTAMC02/plots/desiredtotalfrequency2.jpg',width=500,height=400)");
            c.voidEval("barplot(c("+temp+"),c("+temp2+"),main='Actual Results Possible Total Frequency(w/o Replacement)',xlab='Possible Totals',ylab='Frequency',las=1)");
            c.voidEval("dev.off()");
        }
        temp = "";
        double d;
        for(int i=0; i<result1.length; i++){
           total = result1[i];
           d = total/(Card.drawCards*13);
           if(Card.experiment == 0)
               d = (double)total/(Card.drawCards);
           else if(Card.experiment == 1)
               d = (double)total/26;
           if(i==0)
               temp = temp.concat(d+"");
           else
               temp = temp.concat(","+d);
       }
        c.voidEval("y = seq(0,"+(Card.nTrials-1)+",1)");
        temp2 = "";
        for(int i = 0; i<Card.nTrials; i++){
            if(i == Card.nTrials - 1)
                temp2 = "1";
            else
                temp2 = "1,";
        }
        c.voidEval("jpeg('NetBeansProjects/MODESTAMC02/plots/actualprobability1.jpg',width=500,height=400)");
        c.voidEval("barplot(c("+temp+"),c("+temp2+"),main='Actual Probability Distribution of Possible Totals(w/ Replacement)',xlab='Possible Totals',ylab='Probability',las=1)");
        c.voidEval("dev.off()");
        if(Card.experiment != 1){
            temp = "";
            for(int i=0; i<result2.length; i++){
               total = result2[i];
               d = total/(Card.drawCards*13);
               if(Card.experiment == 0)
                   d = (double)total/(Card.drawCards);
               else if(Card.experiment == 1)
               d = (double)total/26;
               if(i==0)
                   temp = temp.concat(d+"");
               else
                   temp = temp.concat(","+d);
           }
            c.voidEval("y = seq(0,"+(Card.nTrials-1)+",1)");
            temp2 = "";
            for(int i = 0; i<Card.nTrials; i++){
                if(i == Card.nTrials - 1)
                    temp2 = "1";
                else
                    temp2 = "1,";
            }
            c.voidEval("jpeg('NetBeansProjects/MODESTAMC02/plots/actualprobability2.jpg',width=500,height=400)");
            c.voidEval("barplot(c("+temp+"),c("+temp2+"),main='Actual Probability Distribution of Possible Totals(w/o Replacement)',xlab='Possible Totals',ylab='Probability',las=1)");
            c.voidEval("dev.off()");
        }
        temp = "";
        for(int i=0; i<result1.length; i++){
           d = Card.desiredTotal/(Card.drawCards*13);
           if(Card.experiment == 0)
               d = (double)Card.desiredTotal/(Card.drawCards);
           else if(Card.experiment == 1)
               d = (double)Card.desiredTotal/26;
           if(i==0)
               temp = temp.concat(d+"");
           else
               temp = temp.concat(","+d);
       }
        c.voidEval("y = seq(0,"+(Card.nTrials-1)+",1)");
        temp2 = "";
        for(int i = 0; i<Card.nTrials; i++){
            if(i == Card.nTrials - 1)
                temp2 = "1";
            else
                temp2 = "1,";
        }
        c.voidEval("jpeg('NetBeansProjects/MODESTAMC02/plots/idealprobability1.jpg',width=500,height=400)");
        c.voidEval("barplot(c("+temp+"),c("+temp2+"),main='Ideal Probability Distribution of Possible Totals(w/ Replacement)',xlab='Possible Totals',ylab='Probability',las=1)");
        c.voidEval("dev.off()");
        if(Card.experiment != 1){
            temp = "";
            for(int i=0; i<result2.length; i++){
               d = Card.desiredTotal/(Card.drawCards*13);
               if(Card.experiment == 0)
                   d = (double)Card.desiredTotal/(Card.drawCards);
               else if(Card.experiment == 1)
               d = (double)Card.desiredTotal/26;
               if(i==0)
                   temp = temp.concat(d+"");
               else
                   temp = temp.concat(","+d);
           }
            c.voidEval("y = seq(0,"+(Card.nTrials-1)+",1)");
            temp2 = "";
            for(int i = 0; i<Card.nTrials; i++){
                if(i == Card.nTrials - 1)
                    temp2 = "1";
                else
                    temp2 = "1,";
        }
            c.voidEval("jpeg('NetBeansProjects/MODESTAMC02/plots/idealprobability2.jpg',width=500,height=400)");
            c.voidEval("barplot(c("+temp+"),c("+temp2+"),main='Ideal Probability Distribution of Possible Totals(w/o Replacement)',xlab='Possible Totals',ylab='Probability',las=1)");
            c.voidEval("dev.off()");
        }
     } else {  
       System.out.println("Rserve could not connect");  
     }  
     c.close();  
     System.out.println("Session Closed");  
   }
   
 }  
