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
import Controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NSelection extends JFrame implements ActionListener{
    
    private JLabel lbl = new JLabel("Enter N trials (10 to 100000):");
    private JTextField input=new JTextField("");
    private JButton btnInput = new JButton("Enter");
    private JButton btnBack = new JButton("Back");
    
    public NSelection(){
        
        this.setTitle("N Selection");
        this.setSize(400,150);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        lbl.setBounds(10,0,160,30);
        input.setBounds(180, 5, 40, 20);
        btnInput.setBounds(230,5,70,20);
        btnInput.addActionListener(this);
        btnBack.setBounds(10,40,70,30);
        btnBack.addActionListener(this);
        this.setLayout(null);
        this.add(lbl);
        this.add(input);
        this.add(btnInput);
        this.add(btnBack);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == btnInput){
            if(Integer.parseInt(input.getText().toString()) < 10 || Integer.parseInt(input.getText().toString()) > 100000){
                JOptionPane.showMessageDialog(this,
                    "N trials must be from 10 to 100000!",
                    "Wrong Input",JOptionPane.ERROR_MESSAGE);
            }
            
            else{
                Card.nTrials = Integer.parseInt(input.getText().toString());
                FrameManager.getAnotherFrame("DesiredTotal");
            }
        }
        
        else if(e.getSource() == btnBack){
            FrameManager.getAnotherFrame("ExperimentSelection");
        }
        
    }
    
}