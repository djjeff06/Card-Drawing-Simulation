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
import Controller.SaveLoadController;
import Model.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DesiredTotal extends JFrame implements ActionListener{
    
    private JLabel lbl = new JLabel("Desired Total Drawn in a Trial:");
    private JTextField input=new JTextField("");
    private JButton btnInput = new JButton("Enter");
    
    public DesiredTotal(){
        
        this.setTitle("DesiredTotal");
        this.setSize(400,150);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        lbl.setBounds(10,0,180,30);
        input.setBounds(200, 5, 40, 20);
        btnInput.setBounds(250,5,70,20);
        btnInput.addActionListener(this);
        this.setLayout(null);
        this.add(lbl);
        this.add(input);
        this.add(btnInput);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == btnInput){
            if(Integer.parseInt(input.getText().toString()) < 0 || input.getText().equals("")){
                JOptionPane.showMessageDialog(this,
                    Card.drawCards,
                    "Wrong Input",JOptionPane.ERROR_MESSAGE);
            }
            
            else{
                Card.desiredTotal = Integer.parseInt(input.getText().toString());
                SaveLoadController.checkLog();
                FrameManager.getAnotherFrame("IdealActualProbability");
            }
        }
        
    }
    
}