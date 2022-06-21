package com.neuresys.formation.java8.lambda.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Swing {
	public static void main(String[] args) {  
        JTextField tf=new JTextField();  
        tf.setBounds(50, 50,150,20);  
        JButton b=new JButton("click");  
        b.setBounds(80,100,70,30);  
        b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
        });
        b.addActionListener(event->{
        	
        });
}
};
