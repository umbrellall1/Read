package com.read.panel;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import com.read.base.ReadController;
import com.read.listener.FileListener;
import com.read.main.BookMain;

public class TextPanel{
	public  JTextArea text = new JTextArea();
	public  JScrollPane scroll;
	private Point tmp = null;
	public TextPanel(){
		Font font=new Font("黑体",Font.PLAIN,12);
		text.setFont(font);
		text.setSize(150, 289);
		text.setLocation(1, 60);
		text.setWrapStyleWord(true);
		text.setBorder(new LineBorder(null,0));
		text.setLineWrap(true); 
		scroll = new JScrollPane(text); 
		scroll.setBorder(new LineBorder(null,0));
		scroll.setBounds(1, 60, 448, 289);
		scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		text.setEditable(false);
		text.requestFocus();
		text.grabFocus();
		text.addMouseWheelListener(new FileListener());
		text.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                tmp = new Point(e.getX(), e.getY());
            }
        });
		text.addMouseMotionListener(new MouseMotionAdapter() {
        	 public void mouseDragged(MouseEvent e) {
        		 ReadController.mainFrame.setLocation(new Point(ReadController.mainFrame.getLocation().x + e.getX() - tmp.x,ReadController.mainFrame.getLocation().y + e.getY() - tmp.y));
             }
        });
		
		text.setText("ALT+C 开启摸鱼模式\r\n ALT+E  隐藏窗口  \r\n ALT+X 显示窗口");
		
	}
}
