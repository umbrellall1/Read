package com.read.listener;


import javax.swing.JScrollPane;

import com.melloware.jintellitype.HotkeyListener;
import com.read.base.ReadController;  
public class ReadHotkeyListener implements HotkeyListener{

	static boolean isShow=true;
	
	@Override
	public void onHotKey(int arg0) {
		
		switch (arg0) { 
        	case 0: 
        		System.out.println("1");
        		ReadController.mainFrame.setVisible(false);  
        		break;    
        	case 1:    
        		System.out.println("2");
        		ReadController.mainFrame.setVisible(true);
        		ReadController.mainFrame.setAlwaysOnTop(true);
            break; 
        	case 2: 
        		System.out.println("3");
        		switchWin();  
            break;
        }   
	}

	
	public void switchWin(){
		if(isShow){
			double y = ReadController.textPanl.scroll.getViewport().getViewPosition().getY();
			ReadController.titlePanel.setVisible(false);
			ReadController.statePanel.setVisible(false);
			ReadController.textPanl.scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			ReadController.textPanl.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			ReadController.mainFrame.setSize(430, 289);
			ReadController.textPanl.scroll.setSize(430, 289);
			ReadController.textPanl.scroll.setLocation(0, 0);
			 isShow = false;
			 System.out.println(ReadController.textPanl.scroll.getViewport().getViewPosition().getY());
		}else{
			double y = ReadController.textPanl.scroll.getViewport().getViewPosition().getY();
			ReadController.titlePanel.setVisible(true);
			ReadController.statePanel.setVisible(true);
			ReadController.textPanl.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			ReadController.textPanl.scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			ReadController.jscrollY=ReadController.textPanl.scroll.getHeight();
			isShow = true;
			ReadController.mainFrame.setSize(450, 350);
			ReadController.textPanl.scroll.setSize(448, 289);
			ReadController.textPanl.scroll.setLocation(1, 60);
		}
	}
	
	
}
