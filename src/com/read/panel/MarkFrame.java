package com.read.panel;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.read.base.ReadController;
import com.read.listener.FileListener;
import com.read.service.DBService;
import com.read.vo.Bookmark;

public class MarkFrame extends JFrame implements ActionListener{

	int frameWidth = 300;
	int frameHeight = 120;
	public static JButton ok = new JButton("OK");
	public JLabel text = new JLabel("��ǩ����");
	public JTextField name = new JTextField();
	public JButton cancel = new JButton("ȡ��");
	
	
	public MarkFrame(){
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	    text.setBounds(10, 10, 60, 20);
	    name.setBounds(20,40,250,20);
	    ok.setBounds(190, 70, 70, 25);
	    cancel.setBounds(100, 70, 70, 25);
	    cancel.addActionListener(this);
	    ok.addActionListener(this);
	    addComponent();
	    this.setBounds((width - frameWidth) / 2,(height - frameHeight) / 2, frameWidth, frameHeight); 
	    this.setLayout(null);
	    this.setSize(frameWidth, frameHeight);
	    this.setType(JFrame.Type.UTILITY);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
	    
	}
	
	public void addComponent(){
		 this.add(text);
		 this.add(name);
		 this.add(ok);
		 this.add(cancel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if("OK".equals(e.getActionCommand())){
			if(FileListener.path!=null && name.getText()!=null &&!"".equals(name.getText())){
				
				try {
					Bookmark b = new Bookmark();
					b.setText(name.getText());
					b.setPath(FileListener.path);
					b.setY(ReadController.textPanl.scroll.getViewport().getViewPosition().getY());
					System.out.println(b.getY());
					DBService.db(b);
					JOptionPane.showMessageDialog(null, "����ɹ���", "��ʾ",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}else{
				JOptionPane.showMessageDialog(null, "û���ҵ��ɱ�����鼮��ǩ���߱�ǩ������Ϊ�գ�", "��ʾ",JOptionPane.ERROR_MESSAGE);
			}
			this.dispose();
		}else if("ȡ��".equals(e.getActionCommand())){
			this.dispose();
		}
		
	}

	
	
}
