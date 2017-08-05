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

public class MainPage extends JFrame implements ActionListener{
    
    private JLabel label1 = new JLabel("Enter number of cards to be drawn (1 to 5):");
    private JTextField input=new JTextField("");
    private JButton btnInput = new JButton("Enter");
    
    public MainPage(){
        
        this.setTitle("Main Page");
        this.setSize(500,150);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        label1.setBounds(10,0,250,30);
        input.setBounds(270, 5, 40, 20);
        btnInput.setBounds(320,5,70,20);
        btnInput.addActionListener(this);
        this.setLayout(null);
        this.add(label1);
        this.add(input);
        this.add(btnInput);
        
        Card.desiredTotal = 0;
        Card.drawCards = 0;
        Card.dtWithRep = 0;
        Card.dtWithoutRep = 0;
        Card.experiment = 0;
        Card.nTrials = 0;
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == btnInput){
            
            //do something
            if(Integer.parseInt(input.getText().toString()) > 5 || Integer.parseInt(input.getText().toString()) < 1){
                JOptionPane.showMessageDialog(this,
                    "Number of cards to be drawn must be from 1 to 5!",
                    "Wrong Input",JOptionPane.ERROR_MESSAGE);
            }
            
            else{
                Card.drawCards = Integer.parseInt(input.getText().toString());
                FrameManager.getAnotherFrame("ExperimentSelection");
            }
            
        }
        
    }
    
}
