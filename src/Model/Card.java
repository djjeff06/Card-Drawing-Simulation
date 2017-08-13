/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.RConnector;

/**
 *
 * @author msi
 */
public class Card {
    
    public static int experiment = 0;
    public static int drawCards = 0;
    public static int nTrials = 0;
    public static int desiredTotal = 0;
    public static int dtWithRep = 0;
    public static int dtWithoutRep = 0;
    public static int multinomType = 0;
    public static double idealProbability = 0.0;
    public static double actualProbability = 0.0;
    public static double temp = 0.0;
    private String name;
    private int value;
    private int suit;//0-clover, 1-spade, 2-heart, 3-diamond
    
    public Card(String name, int value, int suit){
        this.name = name;
        this.value = value;
        this.suit = suit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }
    
    public static double computeIdealProb(){
        double numerator = 0, denominator = 0;
        try{
            denominator = RConnector.denominatorIdeal();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        switch(drawCards){
            case 1:
                numerator = 1;
                break;
            case 2:
                switch(desiredTotal){
                    case 2: numerator = 16;
                            break;
                    case 3: numerator = 32;
                            break;
                    case 4: numerator = 48;
                            break;
                    case 5: numerator = 64;
                            break;
                    case 6: numerator = 80;
                            break;
                    case 7: numerator = 96;
                            break;
                    case 8: numerator = 112;
                            break;
                    case 9: numerator = 128;
                            break;
                    case 10: numerator = 176;
                             break;
                    case 11: numerator = 160;
                             break;
                    case 12: numerator = 176;
                             break;
                    case 13: numerator = 192;
                             break;
                    case 14: numerator = 208;
                             break;
                    case 15: numerator = 192;
                             break;
                    case 16: numerator = 176;
                             break;
                    case 17: numerator = 160;
                             break;
                    case 18: numerator = 144;
                             break;
                    case 19: numerator = 128;
                             break;
                    case 20: numerator = 112;
                             break;
                    case 21: numerator = 96;
                             break;
                    case 22: numerator = 80;
                             break;
                    case 23: numerator = 64;
                             break;
                    case 24: numerator = 48;
                             break;
                    case 25: numerator = 32;
                             break;
                    case 26: numerator = 16;
                             break;
                }
                break;
            case 3:
                switch(desiredTotal){
                    case 3: numerator = 64;
                            break;
                    case 4: numerator = 192;
                            break;
                    case 5: numerator = 384;
                            break;
                    case 6: numerator = 640;
                            break;
                    case 7: numerator = 960;
                            break;
                    case 8: numerator = 1344;
                            break;
                    case 9: numerator = 1792;
                            break;
                    case 10: numerator = 3520;
                             break;
                    case 11: numerator = 2880;
                             break;
                    case 12: numerator = 3520;
                             break;
                    case 13: numerator = 4224;
                             break;
                    case 14: numerator = 4992;
                             break;
                    case 15: numerator = 5824;
                             break;
                    case 16: numerator = 6528;
                             break;
                    case 17: numerator = 7104;
                             break;
                    case 18: numerator = 7552;
                             break;
                    case 19: numerator = 7872;
                             break;
                    case 20: numerator = 8064;
                             break;
                    case 21: numerator = 8128;
                             break;
                    case 22: numerator = 8064;
                             break;
                    case 23: numerator = 7872;
                             break;
                    case 24: numerator = 7552;
                             break;
                    case 25: numerator = 7104;
                             break;
                    case 26: numerator = 6528;
                             break;
                    case 27: numerator = 5824;
                             break;
                    case 28: numerator = 4992;
                             break;
                    case 29: numerator = 4224;
                             break;
                    case 30: numerator = 3520;
                             break;
                    case 31: numerator = 2880;
                             break;
                    case 32: numerator = 2304;
                             break;
                    case 33: numerator = 1792;
                             break;
                    case 34: numerator = 1344;
                             break;
                    case 35: numerator = 960;
                             break;
                    case 36: numerator = 640;
                             break;
                    case 37: numerator = 384;
                             break;
                    case 38: numerator = 192;
                             break;
                    case 39: numerator = 64;
                             break;
                }
                break;
            case 4:
                switch(desiredTotal){
                    case 4: numerator = 256;
                            break;
                    case 5: numerator = 1024;
                            break;
                    case 6: numerator = 2560;
                            break;
                    case 7: numerator = 5120;
                            break;
                    case 8: numerator = 8960;
                            break;
                    case 9: numerator = 14336;
                            break;
                    case 10: numerator = 42240;
                             break;
                    case 11: numerator = 30720;
                             break;
                    case 12: numerator = 42240;
                             break;
                    case 13: numerator = 56320;
                             break;
                    case 14: numerator = 73216;
                             break;
                    case 15: numerator = 93184;
                             break;
                    case 16: numerator = 116480;
                             break;
                    case 17: numerator = 142336;
                             break;
                    case 18: numerator = 169984;
                             break;
                    case 19: numerator = 198656;
                             break;
                    case 20: numerator = 227584;
                             break;
                    case 21: numerator = 256000;
                             break;
                    case 22: numerator = 283136;
                             break;
                    case 23: numerator = 308224;
                             break;
                    case 24: numerator = 330496;
                             break;
                    case 25: numerator = 349184;
                             break;
                    case 26: numerator = 363520;
                             break;
                    case 27: numerator = 372736;
                             break;
                    case 28: numerator = 376064;
                             break;
                    case 29: numerator = 372736;
                             break;
                    case 30: numerator = 363520;
                             break;
                    case 31: numerator = 349184;
                             break;
                    case 32: numerator = 330496;
                             break;
                    case 33: numerator = 308224;
                             break;
                    case 34: numerator = 283136;
                             break;
                    case 35: numerator = 256000;
                             break;
                    case 36: numerator = 227584;
                             break;
                    case 37: numerator = 198656;
                             break;
                    case 38: numerator = 169984;
                             break;
                    case 39: numerator = 142336;
                             break;
                    case 40: numerator = 116480;
                             break;
                    case 41: numerator = 93184;
                             break;
                    case 42: numerator = 73216;
                             break;
                    case 43: numerator = 56320;
                             break;
                    case 44: numerator = 42240;
                             break;
                    case 45: numerator = 30720;
                             break;
                    case 46: numerator = 21504;
                             break;
                    case 47: numerator = 14336;
                             break;
                    case 48: numerator = 8960;
                             break;
                    case 49: numerator = 5120;
                             break;
                    case 50: numerator = 2560;
                             break;
                    case 51: numerator = 1024;
                             break;
                    case 52: numerator = 256;
                             break;
                }
                break;
            case 5:
                switch(desiredTotal){
                    case 5: numerator = 1024;
                            break;
                    case 6: numerator = 5120;
                            break;
                    case 7: numerator = 15360;
                            break;
                    case 8: numerator = 35840;
                            break;
                    case 9: numerator = 71680;
                            break;
                    case 10: numerator = 337920;
                             break;
                    case 11: numerator = 215040;
                             break;
                    case 12: numerator = 337920;
                             break;
                    case 13: numerator = 506880;
                             break;
                    case 14: numerator = 732160;
                             break;
                    case 15: numerator = 1025024;
                             break;
                    case 16: numerator = 1397760;
                             break;
                    case 17: numerator = 1863680;
                             break;
                    case 18: numerator = 2432000;
                             break;
                    case 19: numerator = 3107840;
                             break;
                    case 20: numerator = 3892224;
                             break;
                    case 21: numerator = 4782080;
                             break;
                    case 22: numerator = 5770240;
                             break;
                    case 23: numerator = 6845440;
                             break;
                    case 24: numerator = 7992320;
                             break;
                    case 25: numerator = 9191424;
                             break;
                    case 26: numerator = 10419200;
                             break;
                    case 27: numerator = 11648000;
                             break;
                    case 28: numerator = 12846080;
                             break;
                    case 29: numerator = 13977600;
                             break;
                    case 30: numerator = 15002624;
                             break;
                    case 31: numerator = 15997360;
                             break;
                    case 32: numerator = 16604160;
                             break;
                    case 33: numerator = 17131520;
                             break;
                    case 34: numerator = 17454080;
                             break;
                    case 35: numerator = 17562624;
                             break;
                    case 36: numerator = 17454080;
                             break;
                    case 37: numerator = 17131520;
                             break;
                    case 38: numerator = 16604160;
                             break;
                    case 39: numerator = 15887360;
                             break;
                    case 40: numerator = 15002624;
                             break;
                    case 41: numerator = 13977600;
                             break;
                    case 42: numerator = 12846080;
                             break;
                    case 43: numerator = 11648000;
                             break;
                    case 44: numerator = 10419200;
                             break;
                    case 45: numerator = 9191424;
                             break;
                    case 46: numerator = 7992320;
                             break;
                    case 47: numerator = 6845440;
                             break;
                    case 48: numerator = 5770240;
                             break;
                    case 49: numerator = 4782080;
                             break;
                    case 50: numerator = 3892224;
                             break;
                    case 51: numerator = 3107840;
                             break;
                    case 52: numerator = 2432000;
                             break;
                    case 53: numerator = 1863680;
                             break;
                    case 54: numerator = 1397760;
                             break;
                    case 55: numerator = 1025024;
                             break;
                    case 56: numerator = 732160;
                             break;
                    case 57: numerator = 506880;
                             break;
                    case 58: numerator = 337920;
                             break;
                    case 59: numerator = 215040;
                             break;
                    case 60: numerator = 129024;
                             break;
                    case 61: numerator = 71680;
                             break;
                    case 62: numerator = 35840;
                             break;
                    case 63: numerator = 15360;
                             break;
                    case 64: numerator = 5120;
                             break;
                }
                break;
        }
        temp = numerator/denominator;
        System.out.println(temp);
        try{
            idealProbability = RConnector.computeIdealProb(numerator/denominator);
        }catch(Exception e){
            e.printStackTrace();
        }
        //idealProbability = numerator/denominator;
        return idealProbability;
    }
    
    public static double computeActualProbWithRep(int[] resultSum){
        
        if(experiment == 0)
            return ((double)dtWithRep)/(nTrials);
        /*else
            return ((double)1-((double)(nTrials-dtWithRep)/nTrials));*/
        /*int success = 0;
        int failure = 0;
        for(int i=0; i<resultSum.length; i++){
            if(resultSum[i] == desiredTotal && success<Card.dtWithRep){
                success++;
            }
            else if(success<Card.dtWithRep)
                failure++;
        }*/
        try{
            return RConnector.computeActualProb(temp);
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public static double computeActualProbWithoutRep(){
        return ((double)1-((double)dtWithoutRep)/(nTrials));
    }
    
}
