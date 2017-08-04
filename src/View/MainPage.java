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

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame{
    
    private JLabel label1 = new JLabel("Number of cards to be drawn (1 to 5):");
    private JTextField input=new JTextField("");
    private JFileChooser fc=new JFileChooser();
    
    public MainPage(){
        
        this.setTitle("Main Page");
        this.setSize(500,500);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        label1.setBounds(0,0,30,10);
        input.setBounds(0, 30, 40, 10);
        input.setColumns(20);
        this.add(label1);
        this.add(input);
        
    }
    
    
    
}
