package com.read.panel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.read.base.ReadController;
import com.read.listener.FileListener;

public class StatePanel extends JPanel{
	
	JMenu menu1 = new JMenu("文件");
	JMenuBar menubar = new JMenuBar();
	JMenuItem item1;
	JMenuItem item2;
	JMenuItem item3;
	JMenuItem item4;
	public static JLabel pageLabel = new JLabel();
	public StatePanel(){
		this.setBackground(Color.green);
		this.setSize(448, 30);
		this.setLocation(1, 29);
//		pageLabel.setText("======");
		pageLabel.setSize(100, 20);
		pageLabel.setLocation(100,5);
		menubar.add(menu1);
		item1 = new JMenuItem("打开文件...");
		item2 = new JMenuItem("添加书签");
		item3 = new JMenuItem("载入书签");
		item4 = new JMenuItem("test");
		menu1.add(item1);
		menu1.addSeparator();
		menu1.add(item2);
		menu1.addSeparator();
		menu1.add(item3);
		menu1.add(item4);
		menubar.setSize(50, 30);
		menubar.setLayout(null);
		menu1.setSize(50, 30);
//		menubar.setLocation(0, 5);
		this.setLayout(null);
		this.add(menubar);
		this.add(pageLabel);
		
		setAction();
	}
	
	public void setAction(){
		item1.addActionListener(new FileListener());
		item3.addActionListener(new FileListener());
		item2.addActionListener(new FileListener());
		item4.addActionListener(new FileListener());
	}
	
}
