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

public class GraphActualIdealProb extends JFrame implements ActionListener{
    
    private JLabel lbl = new JLabel("Enter N trials (10 to 100000):");
    private JTextField input=new JTextField("");
    private JButton btnInput = new JButton("Finish");
    private JButton btnBack = new JButton("Back");
    
    public GraphActualIdealProb(){
        
        this.setTitle("Actual vs Ideal Probability");
        this.setSize(1050,900);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        btnInput.setBounds(110,820,70,30);
        btnInput.addActionListener(this);
        btnBack.setBounds(10,820,70,30);
        btnBack.addActionListener(this);
        this.setLayout(null);
        this.add(btnInput);
        this.add(btnBack);
        
        String path = "plots/actualprobability1.jpg";
        try{
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setBounds(0,0,500,400);
            label.setVisible(true);
            this.add(label);
        } catch(IOException e){
            e.printStackTrace();
        }
        
        path = "plots/idealprobability1.jpg";
        try{
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setBounds(500,0,500,400);
            label.setVisible(true);
            this.add(label);
        } catch(IOException e){
            e.printStackTrace();
        }
        
        if(Card.experiment != 1){
            path = "plots/actualprobability2.jpg";
            try{
                File file = new File(path);
                BufferedImage image = ImageIO.read(file);
                JLabel label = new JLabel(new ImageIcon(image));
                label.setBounds(0,400,500,400);
                label.setVisible(true);
                this.add(label);
            } catch(IOException e){
                e.printStackTrace();
            }

            path = "plots/idealprobability2.jpg";
            try{
                File file = new File(path);
                BufferedImage image = ImageIO.read(file);
                JLabel label = new JLabel(new ImageIcon(image));
                label.setBounds(500,400,500,400);
                label.setVisible(true);
                this.add(label);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        else{
            btnInput.setBounds(110,420,70,30);
            btnBack.setBounds(10,420,70,30);
            this.setSize(1050,500);
        }
        //this.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == btnInput){
            FrameManager.getAnotherFrame("MainPage");
        }
        
        else if(e.getSource() == btnBack){
            FrameManager.getAnotherFrame("GraphActualResults");
        }
        
    }
    
}