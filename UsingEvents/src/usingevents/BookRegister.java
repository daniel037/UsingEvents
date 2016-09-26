/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usingevents;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 *
 * @author oop
 */
public class BookRegister extends Frame{
    
    private TextField book;
    private Button add;
    private List list;
    private Button remove;
    //-------------------------------------------------
    public BookRegister()
    {
        //border layout viene incluido
        Panel p = new Panel(new BorderLayout());
        book = new TextField();
        add = new Button("add");
        list = new List();
        remove = new Button("Remove");
        
        p.add(new Label("title"), BorderLayout.WEST);
        p.add(book, BorderLayout.CENTER);
        p.add(add, BorderLayout.EAST);
        
        add(p,BorderLayout.NORTH);
        add(list, BorderLayout.CENTER);
        add(remove, BorderLayout.SOUTH);
        
        setTitle("books register");
        setSize(400,300);
        evens();
        setVisible(true);                    
    }
    //---------------------------------------------------
    private void evens(){
        //----------- closing window and system-------------------
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                dispose();
                System.exit(0);
            }
        } );
        //------------------------------------------ 
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(book.getText());
                book.setText("");
            }
        });
        //------------------------------------------------------
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             list.remove(list.getSelectedIndex());     
            }
        });
        //-------------------------------------------------------      
          book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(book.getText());
                book.setText("");
            }
        });               
    }
    //------------------------------------------------
    public static void main(String[] args) {
        new  BookRegister();

    }   
}