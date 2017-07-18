package com.read.main;

import java.awt.AWTException;

import com.read.base.ReadController;
import com.read.panel.MainFrame;

public class BookMain extends ReadController{

	public static void main(String[] args) throws AWTException {
		mainFrame  = new MainFrame();
		ReadController.mainFrame =mainFrame;
		ReadController.statePanel = mainFrame.statePanel;
		ReadController.textPanl = mainFrame.textPanel;
		ReadController.titlePanel = mainFrame.titlePanel;
	}
	
	
	
}
