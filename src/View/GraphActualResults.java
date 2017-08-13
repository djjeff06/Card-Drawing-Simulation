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
    
    private JButton btnInput = new JButton("Next");
    private JButton btnBack = new JButton("Back");
    
    public GraphActualResults(){
        
        this.setTitle("Actual Results Graph");
        this.setSize(1050,500);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        btnInput.setBounds(110,420,70,30);
        btnInput.addActionListener(this);
        btnBack.setBounds(10,420,70,30);
        btnBack.addActionListener(this);
        this.setLayout(null);
        this.add(btnInput);
        this.add(btnBack);
        
        String path = "plots/desiredtotalfrequency1.jpg";
        try{
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setBounds(0,0,500,400);
            //label.setSize(400, 400);
            label.setVisible(true);
            this.add(label);
        } catch(IOException e){
            e.printStackTrace();
        }
        
        if(Card.experiment!=0 && Card.experiment != 1){
            path = "plots/desiredtotalfrequency2.jpg";
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
        }
        else{
            this.setSize(550,500);
        }
        //this.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == btnInput){
            FrameManager.getAnotherFrame("GraphActualIdealProb");
        }
        
        else if(e.getSource() == btnBack){
            FrameManager.getAnotherFrame("IdealActualProbability");
        }
        
    }
    
}
