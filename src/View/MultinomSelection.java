/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author msi
 */
import Model.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MultinomSelection extends JFrame implements ActionListener{
    
    private JLabel lbl = new JLabel("Select type of multinomial experiment");
    private JButton btn1 = new JButton("Selecting type of card (Ace through King)");
    private JButton btn2 = new JButton("Selecting Suit");
    private JButton btnBack = new JButton("Back");
    private JFileChooser fc=new JFileChooser();
    
    public MultinomSelection(){
        
        this.setTitle("Multinom Selection");
        this.setSize(360,200);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        lbl.setBounds(10,0,250,30);
        btn1.setBounds(10,40,300,30);
        btn2.setBounds(10,80,300,30);
        btnBack.setBounds(10,120,70,30);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btnBack.addActionListener(this);
        this.setLayout(null);
        this.add(lbl);
        this.add(btn1);
        this.add(btn2);
        this.add(btnBack);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == btn1){
            Card.multinomType = 0;
            FrameManager.getAnotherFrame("NSelection");
        }
        
        else if(e.getSource() == btn2){
            Card.multinomType = 1;
            FrameManager.getAnotherFrame("NSelection");
        }
        
        else if(e.getSource() == btnBack){
            FrameManager.getAnotherFrame("ExperimentSelection");
        }
        
    }
    
}