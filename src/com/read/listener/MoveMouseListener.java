package com.read.listener;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;

import com.read.panel.MainFrame;
import com.read.panel.MarkFrame;

public class MoveMouseListener implements MouseListener {
	Object obj;
	public MoveMouseListener(Object obj){
		this.obj =obj;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {  
            if (((Frame) obj).getExtendedState() == JFrame.ICONIFIED) {  
            	((MainFrame) obj).openFrame();// »¹Ô­´°¿Ú  
            } else {  
            	((Frame) obj).setExtendedState(JFrame.ICONIFIED);  
            }  
        } 
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
