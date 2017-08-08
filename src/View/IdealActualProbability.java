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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class IdealActualProbability extends JFrame implements ActionListener{
    
    private JLabel lbl1 = new JLabel("Desired Total: "+Card.desiredTotal);
    private JLabel lbl2 = new JLabel("Desired Total Occurence in With Replacement: "+Card.dtWithRep);
    private JLabel lbl3 = new JLabel("Desired Total Occurence in Without Replacement: "+Card.dtWithoutRep);
    private JLabel lbl4 = new JLabel("Ideal Probability: "+Card.computeIdealProb());
    private JLabel lbl5 = new JLabel("Actual Probability (With Replacement): "+Card.computeActualProbWithRep());
    private JLabel lbl6 = new JLabel("Actual Probability (Without Replacement): "+Card.computeActualProbWithoutRep());
    private JButton btnNext = new JButton("Next");
    
    public IdealActualProbability(){
        
        this.setTitle("Ideal and Actual Probability");
        this.setSize(500,315);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        
        lbl1.setBounds(10,0,400,30);
        lbl2.setBounds(10,40,400,30);
        lbl3.setBounds(10,80,400,30);
        lbl4.setBounds(10,120,400,30);
        lbl5.setBounds(10,160,400,30);
        lbl6.setBounds(10,200,400,30);
        btnNext.setBounds(10,240,70,30);
        btnNext.addActionListener(this);
        this.setLayout(null);
        this.add(lbl1);
        this.add(lbl2);
        this.add(lbl4);
        this.add(lbl5);
        this.add(btnNext);
        
        if(Card.experiment != 1){
            this.add(lbl3);
            this.add(lbl6);
        }
        else{
            lbl4.setBounds(10,80,400,30);
            lbl5.setBounds(10,120,400,30);
            btnNext.setBounds(10,160,70,30);
        }
        
        String path = "animations/beach.jpg";
        try{
            File file = new File(path);
            BufferedImage image = ImageIO.read(file);
            JLabel label = new JLabel(new ImageIcon(image));
            label.setBounds(0,0,500,281);
            label.setVisible(true);
            this.add(label);
        } catch(IOException e){
            e.printStackTrace();
        }
        
        this.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == btnNext){
            //run code to create plot
            FrameManager.getAnotherFrame("GraphActualResults");
        }
        
    }
    
}
