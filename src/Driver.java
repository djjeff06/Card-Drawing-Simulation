/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author msi
 */

import java.util.ArrayList;
import Model.Card;
import View.MainPage;

public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //initialize card deck
        ArrayList<Card> cardList = new ArrayList<>();
        cardList.add(new Card("Ace",1,0));
        cardList.add(new Card("Ace",1,1));
        cardList.add(new Card("Ace",1,2));
        cardList.add(new Card("Ace",1,3));
        
        cardList.add(new Card("Two",2,0));
        cardList.add(new Card("Two",2,1));
        cardList.add(new Card("Two",2,2));
        cardList.add(new Card("Two",2,3));
        
        cardList.add(new Card("Three",3,0));
        cardList.add(new Card("Three",3,1));
        cardList.add(new Card("Three",3,2));
        cardList.add(new Card("Three",3,3));
        
        cardList.add(new Card("Four",4,0));
        cardList.add(new Card("Four",4,1));
        cardList.add(new Card("Four",4,2));
        cardList.add(new Card("Four",4,3));
        
        cardList.add(new Card("Five",5,0));
        cardList.add(new Card("Five",5,1));
        cardList.add(new Card("Five",5,2));
        cardList.add(new Card("Five",5,3));
        
        cardList.add(new Card("Six",6,0));
        cardList.add(new Card("Six",6,1));
        cardList.add(new Card("Six",6,2));
        cardList.add(new Card("Six",6,3));
        
        cardList.add(new Card("Seven",7,0));
        cardList.add(new Card("Seven",7,1));
        cardList.add(new Card("Seven",7,2));
        cardList.add(new Card("Seven",7,3));
        
        cardList.add(new Card("Eight",8,0));
        cardList.add(new Card("Eight",8,1));
        cardList.add(new Card("Eight",8,2));
        cardList.add(new Card("Eight",8,3));
        
        cardList.add(new Card("Nine",9,0));
        cardList.add(new Card("Nine",9,1));
        cardList.add(new Card("Nine",9,2));
        cardList.add(new Card("Nine",9,3));
        
        cardList.add(new Card("Ten",10,0));
        cardList.add(new Card("Ten",10,1));
        cardList.add(new Card("Ten",10,2));
        cardList.add(new Card("Ten",10,3));
        
        cardList.add(new Card("Jack",11,0));
        cardList.add(new Card("Jack",11,1));
        cardList.add(new Card("Jack",11,2));
        cardList.add(new Card("Jack",11,3));
        
        cardList.add(new Card("Queen",12,0));
        cardList.add(new Card("Queen",12,1));
        cardList.add(new Card("Queen",12,2));
        cardList.add(new Card("Queen",12,3));
        
        cardList.add(new Card("King",13,0));
        cardList.add(new Card("King",13,1));
        cardList.add(new Card("King",13,2));
        cardList.add(new Card("King",13,3));
        
        MainPage mainPage= new MainPage();
        
        
    }
    
}
