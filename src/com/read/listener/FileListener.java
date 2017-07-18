package com.read.listener;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;

import com.read.base.ReadController;
import com.read.panel.MainFrame;
import com.read.panel.MarkFrame;
import com.read.panel.MarkListFrame;
import com.read.panel.StatePanel;
import com.read.panel.TextPanel;
import com.read.service.DBService;
import com.read.service.PageService;
import com.read.service.ReadBookService;
import com.read.vo.Bookmark;
import com.read.vo.TextState;

public class FileListener implements ActionListener,MouseWheelListener{

	static int pageNo=1;
	static int height=15;
	static int pageRow=19;
	static int  pageTotal =0;
	public static  String path;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());
		if("打开文件...".equals(arg0.getActionCommand())){
			pageNo=1;
			openFile();
		}else if("添加书签".equals(arg0.getActionCommand())){
			new MarkFrame();
		}else if("载入书签".equals(arg0.getActionCommand())){
			new MarkListFrame();
		}else if("test".equals(arg0.getActionCommand())){
			ReadController.titlePanel.setVisible(false);
			ReadController.statePanel.setVisible(false);
			ReadController.textPanl.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		}
	}
	
	
	public void openFile(){  
		JFileChooser jfc=new JFileChooser();
		jfc.setAcceptAllFileFilterUsed(false);
        jfc.setFileFilter(new javax.swing.filechooser.FileFilter() {  
        	public boolean accept(File f) { // 设定可用的文件的后缀名     
        		if (f.getName().endsWith(".txt") || f.isDirectory()) {  
        			return true;     
        		}    
        		    return false;    
        	}
        	
        	public String getDescription() {   
        		return "TXT文件(*.txt)";  
        	} 
        });   
        jfc.showOpenDialog(null); 
        File file = jfc.getSelectedFile();
        if(file !=null){
        	path = file.getPath();
        	ReadController.textPanl.text.setText(PageService.getPageText(path));
        	ReadController.textPanl.text.selectAll();
        	ReadController.textPanl.text.setSelectionStart(0);
        	ReadController.textPanl.text.setSelectionEnd(0);
        }
	}





	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int max = ReadController.textPanl.scroll.getVerticalScrollBar().getModel().getMaximum()-ReadController.jscrollY;
		if(ReadController.textPanl.scroll.getViewport().getViewPosition().getY()<0){
			JOptionPane.showMessageDialog(null, "已经是第一页了", "提示消息",JOptionPane.WARNING_MESSAGE);
			Point p = new Point();
			p.setLocation(0,0);
			ReadController.textPanl.scroll.getViewport().setViewPosition(p);
			return;
		}if(ReadController.textPanl.scroll.getViewport().getViewPosition().getY()>=max){
			JOptionPane.showMessageDialog(null, "没有更多内容了", "提示消息",JOptionPane.WARNING_MESSAGE);
			Point p = new Point();
			p.setLocation(0,max-1);
			ReadController.textPanl.scroll.getViewport().setViewPosition(p);
			return;
		}
		if(e.getWheelRotation()==1){
			Point p = new Point();
			p.setLocation(0,ReadController.textPanl.scroll.getViewport().getViewPosition().getY()+20);
			ReadController.textPanl.scroll.getViewport().setViewPosition(p);
		}else{
			Point p = new Point();
			p.setLocation(0,ReadController.textPanl.scroll.getViewport().getViewPosition().getY()-20);
			ReadController.textPanl.scroll.getViewport().setViewPosition(p);
	    }
		
		
	}

}
