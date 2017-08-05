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
import java.io.*;

public class SaveLoadController {
    
    public static boolean saveLog1DArray(int[] list1, int[] list2){
        
        boolean done = false;
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter( new FileWriter("log.txt"));
            writer.append("WITH_REPLACEMENT");
            writer.newLine();
            for(int i=0; i<list1.length; i++){
                writer.append(list1[i]+"");
                writer.newLine();
            }
            writer.append("WITHOUT_REPLACEMENT");
            writer.newLine();
            if(list2 != null){
                for(int i=0; i<list2.length; i++){
                    writer.append(list2[i]+" ");
                    writer.newLine();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            try{
                if ( writer != null)
                    writer.close( );
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return done;
        
    }
    
    public static boolean saveLog2DArray(int[][] list1, int[][] list2){
        
        boolean done = false;
        BufferedWriter writer = null;
        try{
            writer = new BufferedWriter( new FileWriter("log.txt"));
            writer.append("WITH_REPLACEMENT");
            writer.newLine();
            for(int i=0; i<list1.length; i++){
                for(int j=0; j<list1[i].length; j++){
                    writer.append(list1[i][j]+" ");
                }
                writer.newLine();
            }
            writer.append("WITHOUT_REPLACEMENT");
            writer.newLine();
            if(list2 != null){
                for(int i=0; i<list2.length; i++){
                    for(int j=0; j<list2[i].length; j++){
                        writer.append(list2[i][j]+" ");
                    }
                    writer.newLine();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            try{
                if ( writer != null)
                    writer.close( );
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return done;
        
    }
    
    public static void checkLog(){
        
        int withRCount = 0;
        int withoutRCount = 0;
        int sum = 0;
        BufferedReader reader = null;
        boolean withReplacement = true;
        try{
            reader = new BufferedReader(new FileReader("log.txt"));
            String line = null;
            while((line = reader.readLine()) != null) {
                sum = 0;
                if(line.equals("WITH_REPLACEMENT")){
                    withReplacement = true;
                }
                else if(line.equals("WITHOUT_REPLACEMENT")){
                    withReplacement = false;
                }
                else{
                    String[] temp = line.split("\\s+");
                    for(int i=0; i<temp.length; i++){
                        sum += Integer.parseInt(temp[i]);
                    }
                    if(sum == Card.desiredTotal){
                        if(withReplacement)
                            withRCount++;
                        else
                            withoutRCount++;
                    }
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            try{
                if(reader!=null)
                    reader.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        
        Card.dtWithRep = withRCount;
        Card.dtWithoutRep = withoutRCount;
                      
    }
    
    public File loadPlot(String fileName){
        
        File file = null;
        
        return file;
        
    }
    
}
