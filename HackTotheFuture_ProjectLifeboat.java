//Project LifeBoat
//Hack to the Future 2020

//submitted by student: Yulee Kang
//a website aimed at connecting patients to payment options 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class HackTotheFuture_ProjectLifeboat
{

   public static void main(String[] args)
   {
      new Display();
   }
   
   /***************** panel stuff *****************/
   
   private static class Panel extends JPanel
   {
      private Display display;
      
      public Panel()
      {
         setLayout(new GridLayout());
         display = new Display();
         add(display);
      }
   }
   
   /***************** actual display stuff *****************/
   
   private static class Display extends JPanel
   {
      private JFrame frame = new JFrame("My LifeBoat");
      private JFrame Infoframe = new JFrame("About you");
      private JFrame Resultsframe = new JFrame("Your matches"); 
      private JButton startbutton = new JButton("Start");
      
      
      public Display()
      {
         frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
         frame.getContentPane().add(startbutton);
         
         frame.setLayout(new GridLayout(3,3));
         
         frame.getContentPane().setBackground(Color.decode("#d5ebed"));
         frame.setSize(900,900);
         frame.setVisible(true);
         
         startbutton.addActionListener
            (
            new ActionListener() 
            {
               public void actionPerformed(ActionEvent e) 
               {
                  frame.dispose();
                  new InfoFrame();
               }
            }
            );
      }
      
      public class InfoFrame extends JPanel 
      {
      
         private JLabel agelabel, addresslabel, incomelabel, conditionlabel, costlabel;
         private JTextField ageInput, addressInput, incomeInput, conditionInput, costInput;
         private JButton nextbutton = new JButton("Match!");
         
         public InfoFrame() 
         {
            Infoframe.getContentPane().setBackground(Color.decode("#d5ebed"));
         
            Infoframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Infoframe.setSize(900,900);
            Infoframe.setVisible(true);
            
            JPanel agepanel = new JPanel();
            agepanel.setLayout(new GridLayout(9,9));
            
            agepanel.add(new JLabel("Input your age"));
            ageInput = new JTextField("example: 32", 10);
            ageInput.setHorizontalAlignment(SwingConstants.RIGHT);
            agepanel.add(ageInput);
            
            agepanel.add(new JLabel("Input your state"));
            addressInput = new JTextField("example: VA", 10);
            addressInput.setHorizontalAlignment(SwingConstants.RIGHT);
            agepanel.add(addressInput);
            
            agepanel.add(new JLabel("Input your income"));
            incomeInput = new JTextField("example: 45,000", 10);
            incomeInput.setHorizontalAlignment(SwingConstants.RIGHT);
            agepanel.add(incomeInput);
            
            agepanel.add(new JLabel("Input the condition or illness you are being treated for"));
            conditionInput = new JTextField("example: sepsis", 10);
            conditionInput.setHorizontalAlignment(SwingConstants.RIGHT);
            agepanel.add(conditionInput);
            
            agepanel.add(new JLabel("Input your expect treatment cost"));
            costInput = new JTextField("example: 12,000", 10);
            costInput.setHorizontalAlignment(SwingConstants.RIGHT);
            agepanel.add(costInput);
            
            agepanel.add(nextbutton);
            
            Infoframe.add(agepanel);
            
            nextbutton.addActionListener
               (
               new ActionListener() 
               {
                  public void actionPerformed(ActionEvent e) 
                  {
                     Infoframe.dispose();
                     new ResultsFrame();
                  }
               }
               );
         }
      }
      
      public class ResultsFrame extends JPanel
      {
         private JLabel resultslabel, dummy1;
         private JTextField ageInput, stateInput, incomeInput, conInput;
      
         public ResultsFrame()
         {
            Resultsframe.getContentPane().setBackground(Color.decode("#d5ebed"));
            Resultsframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Resultsframe.setSize(900,900);
            Resultsframe.setVisible(true);
            
            JPanel resultspanel = new JPanel();
            resultspanel.setLayout(new GridLayout(9,9));
            
            resultspanel.add(new JLabel("Here are the different payment options you matched with:"));
            resultspanel.add(new JLabel(""));
            
            resultspanel.add(new JLabel("Based on your age you qualify for:"));
            ageInput = new JTextField("The Catastrophic Illness in Children Relief Fund; UnitedHealthcare Children's Foundation");
            ageInput.setHorizontalAlignment(SwingConstants.CENTER);
            resultspanel.add(ageInput);
            
            resultspanel.add(new JLabel("Based on your state of residence you qualify for:"));
            stateInput = new JTextField("Virginia Family Access to Medical Insurance Security");
            stateInput.setHorizontalAlignment(SwingConstants.CENTER);
            resultspanel.add(stateInput);
            
            resultspanel.add(new JLabel("Based on your income you qualify for:"));
            incomeInput = new JTextField("The HealthWell Foundation, PAN Foundation, Prosper Health Coverage");
            incomeInput.setHorizontalAlignment(SwingConstants.CENTER);
            resultspanel.add(incomeInput);
            
            resultspanel.add(new JLabel("Based on your medical condition you qualify for:"));
            conInput = new JTextField("Ronald McDonald House, CancerCare, Cancer Financial Assistance Coalition");
            conInput.setHorizontalAlignment(SwingConstants.CENTER);
            resultspanel.add(conInput);
            
            Resultsframe.add(resultspanel);
         }
      }
      
   }
}
