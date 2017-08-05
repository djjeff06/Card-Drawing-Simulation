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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GraphActualResults extends JFrame implements ActionListener{
    
    private JLabel lbl = new JLabel("Enter N trials (10 to 100000):");
    private JTextField input=new JTextField("");
    private JButton btnInput = new JButton("Enter");
    private JButton btnBack = new JButton("Back");
    
    public GraphActualResults(){
        
        this.setTitle("N Selection");
        this.setSize(1050,600);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        btnInput.setBounds(110,520,70,30);
        btnInput.addActionListener(this);
        btnBack.setBounds(10,520,70,30);
        btnBack.addActionListener(this);
        this.setLayout(null);
        this.add(btnInput);
        this.add(btnBack);
        
        String path = "plots/desiredtotalfrequency1.jpg";
        try{
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setBounds(0,0,500,500);
            //label.setSize(400, 400);
            label.setVisible(true);
            this.add(label);
        } catch(IOException e){
            e.printStackTrace();
        }
        
        path = "plots/desiredtotalfrequency2.jpg";
        try{
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setBounds(500,0,500,500);
            //label.setSize(400, 400);
            label.setVisible(true);
            this.add(label);
        } catch(IOException e){
            e.printStackTrace();
        }
        //this.setVisible(true);
        
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
                //do experiments and save in txt file
                int[][] result1 = new int[Card.nTrials][Card.drawCards];
                int[][] result2 = new int[Card.nTrials][Card.drawCards];
                try{
                    result1 = Controller.RConnector.withReplacement();
                    result2 = Controller.RConnector.withoutReplacement();
                    SaveLoadController.saveLog2DArray(result1, result2);
                }catch(Exception err){
                    err.printStackTrace();
                }
                FrameManager.getAnotherFrame("DesiredTotal");
            }
        }
        
        else if(e.getSource() == btnBack){
            FrameManager.getAnotherFrame("IdealActualProbability");
        }
        
    }
    
}
