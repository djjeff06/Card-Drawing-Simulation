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
import Controller.RConnector;
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
        
        this.setTitle("Desired Total");
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
                int[][] result1 = new int[Card.nTrials][Card.drawCards];
                int[][] result2 = new int[Card.nTrials][Card.drawCards];
                int[] result3 = new int[Card.nTrials];
                int[] result4 = new int[Card.nTrials];
                try{
                    if(Card.experiment == 0){
                        //binomial
                        result1 = Controller.RConnector.binomialWithReplacement();
                        result2 = Controller.RConnector.binomialWithoutReplacement();
                        SaveLoadController.saveLog2DArray(result1, result2);
                        RConnector.createPlot(result1, result2);
                    }
                    else if(Card.experiment == 1){
                        //negative binomial
                        result3 = Controller.RConnector.nbinomial();
                        result4 = null;
                        SaveLoadController.saveLog1DArray(result3, result4);
                        RConnector.createPlot1D(result3, result4);
                        
                    }
                    else if(Card.experiment == 2){
                        //hypergeometric
                        result1 = Controller.RConnector.hyperWithReplacement();
                        result2 = Controller.RConnector.hyperWithoutReplacement();
                        SaveLoadController.saveLog2DArray(result1, result2);
                        RConnector.createPlot(result1, result2);
                    }
                    else if(Card.experiment == 3){
                        //multinomial
                        if(Card.multinomType == 0){
                            result1 = Controller.RConnector.multinomWRType();
                            result2 = Controller.RConnector.multinomWORType();
                        }
                        else{
                            result1 = Controller.RConnector.multinomWRSuit();
                            result2 = Controller.RConnector.multinomWORSuit();
                        }
                        SaveLoadController.saveLog2DArray(result1, result2);
                        RConnector.createPlot(result1, result2);
                    }
                    else{
                        result1 = Controller.RConnector.withReplacement();
                        result2 = Controller.RConnector.withoutReplacement();
                        SaveLoadController.saveLog2DArray(result1, result2);
                        RConnector.createPlot(result1, result2);
                    }
                    
                }catch(Exception err){
                    err.printStackTrace();
                }
                SaveLoadController.checkLog();
                FrameManager.getAnotherFrame("IdealActualProbability");
            }
        }
        
    }
    
}