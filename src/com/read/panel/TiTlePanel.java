package com.read.panel;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TiTlePanel extends JPanel{

	JButton close;
	URL url = TiTlePanel.class.getClassLoader().getResource("colse.png");
	public  TiTlePanel(){
		close = new JButton();
		close.setSize(20,20);
		close.setLocation(415, 5);
		ImageIcon img = new ImageIcon(url);
		img.setImage(img.getImage().getScaledInstance(40, 40,Image.SCALE_DEFAULT ));
		close.setIcon(img);
		close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
		this.add(close);
		this.setBackground(Color.red);
		this.setSize(450, 30);
		this.setLayout(null);
		
	}
	
}
