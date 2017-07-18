package com.read.panel;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.read.base.ReadController;
import com.read.listener.FileListener;
import com.read.service.DBService;
import com.read.service.PageService;
import com.read.vo.Bookmark;
import com.read.vo.MarkList;

public class MarkListFrame extends JFrame implements ActionListener{

	int frameWidth = 300;
	int frameHeight = 120;
	public static JButton ok = new JButton("OK");
	public JLabel text = new JLabel("书签名称");
	public JButton cancel = new JButton("取消");
	JComboBox comboBox=new JComboBox(); 
	MarkList list;
	public MarkListFrame(){
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	    text.setBounds(10, 10, 60, 20);
	    initText();
        comboBox.setBounds(20,40,250,20);
	    ok.setBounds(190, 70, 70, 25);
	    cancel.setBounds(100, 70, 70, 25);
	    cancel.addActionListener(this);
	    ok.addActionListener(this);
	    this.add(text);
	    this.add(comboBox);
	    this.add(ok);
	    this.add(cancel);
	    this.setBounds((width - frameWidth) / 2,(height - frameHeight) / 2, frameWidth, frameHeight); 
	    this.setLayout(null);
	    this.setSize(frameWidth, frameHeight);
	    this.setType(JFrame.Type.UTILITY);
        this.setUndecorated(true);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if("OK".equals(e.getActionCommand())){
			new Thread(){
				public void run(){
					Bookmark b = list.getMap().get(comboBox.getSelectedItem());
					FileListener.path = b.getPath();
					ReadController.textPanl.text.setText(PageService.getPageText(b.getPath()));
					Point p = new Point();
					p.setLocation(0,b.getY());
					while(true){
						ReadController.textPanl.scroll.getViewport().setViewPosition(p);
						if(ReadController.textPanl.scroll.getViewport().getViewPosition().getY()==b.getY()){
							dispose();
							return;
						}
					}
				}
			}.start();;
		}else if("取消".equals(e.getActionCommand())){
			this.dispose();
		}
	}
	
	public void initText(){
		list =DBService.getdb();
		Map<String,Bookmark> map = list.getMap();
		Set<String> set = map.keySet();
		for (String str:set) {
			comboBox.addItem(str);  
		}
	}
	
}
