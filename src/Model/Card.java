/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author msi
 */
public class Card {
    
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
    
}
