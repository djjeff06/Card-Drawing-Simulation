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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ExperimentSelection extends JFrame implements ActionListener{
    
    private JLabel lbl = new JLabel("Select type of experiment");
    private JButton btn1 = new JButton("Binomial Experiment");
    private JButton btn2 = new JButton("Negative Binomial Experiment");
    private JButton btnBack = new JButton("Back");
    private JFileChooser fc=new JFileChooser();
    
    public ExperimentSelection(){
        
        this.setTitle("Experiment Selection");
        this.setSize(500,450);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        lbl.setBounds(10,0,250,30);
        btn1.setBounds(10,40,210,30);
        btn2.setBounds(230,40,210,30);
        btnBack.setBounds(10,80,70,30);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btnBack.addActionListener(this);
        this.setLayout(null);
        this.add(lbl);
        this.add(btn1);
        this.add(btn2);
        this.add(btnBack);
        
        String path = "animations/experiment.jpg";
        try{
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setBounds(0,0,500,430);
            label.setVisible(true);
            this.add(label);
        } catch(IOException e){
            e.printStackTrace();
        }
        
        this.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == btn1){
            Card.experiment = 0;
            FrameManager.getAnotherFrame("NSelection");
        }
        
        else if(e.getSource() == btn2){
            Card.experiment = 1;
            FrameManager.getAnotherFrame("NSelection");
        }
        
        else if(e.getSource() == btnBack){
            FrameManager.getAnotherFrame("MainPage");
        }
        
    }
    
}