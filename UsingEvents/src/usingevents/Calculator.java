/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingevents;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 *
 * @author OSCAR DANIEL SALAZAR CEBALLOS... codigo  2140341356
 */
public class Calculator extends JFrame{
    public static int NUMBRER =1;
    public  static int OPERATOR = 2;
    
    //--------------------------------------------------------------------------
    private JLabel display;
    private JButton numbers[];
    private JButton operators[];
    private JButton clear;
    private int previews;
    
    public Calculator()
    {
        super("Calculator");  //ejecuta el constructor de la super clase...
        setSize(300,300);
        widgets();
        evens();
        setVisible(true);
    }
    //--------------------------------------------------------------------------
    private void widgets()
    {
        JPanel p = new JPanel(new GridLayout(4,4) );
        display = new JLabel("0",JLabel.RIGHT);
        
        numbers = new JButton[10];
        for(int i=0;i<10;i++)
        {
            numbers[i] = new JButton(""+i);
        }
        
        operators = new JButton[5];
        String op[] = {"=","+","-","*","/"};
        for(int i=0;i<5;i++)
        {
            operators[i] = new JButton(op[i]);
        }
        
        clear = new JButton("C");
        
        add( display, BorderLayout.NORTH);
        add(p, BorderLayout.CENTER);
        
        p.add(numbers[7]);
        p.add(numbers[8]);
        p.add(numbers[9]);
        p.add(operators[1]);
        
        p.add(numbers[4]);
        p.add(numbers[5]);
        p.add(numbers[6]);
        p.add(operators[2]);
        
        p.add(numbers[1]);
        p.add(numbers[2]);
        p.add(numbers[3]);
        p.add(operators[3]);
        
        p.add(numbers[0]);
        p.add(clear);
        p.add(operators[0]);
        p.add(operators[4]);   
    }
    //--------------------------------------------------------------------------
    private void evens()
    {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }   
        });
        //----------------------------------------------------------------------
        for(int i = 0; i<10; i++)
        {
            numbers[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(previews == NUMBRER )
                    { 
                        display.setText( display.getText() + e.getActionCommand());
                    }
                    else
                    {
                        display.setText(e.getActionCommand());
                        previews = NUMBRER;
                    }
                }
            });
        }
        //----------------------------------------------------------------------
        for(int i=0; i<5; i++)
        {
            operators[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    previews = OPERATOR;
               
                }
            });
        }
    }
    //--------------------------------------------------------------------------
    public static void main(String[] args) 
    {
        new Calculator();
    }
}