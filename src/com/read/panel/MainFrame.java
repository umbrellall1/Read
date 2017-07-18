package com.read.panel;

import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import com.read.listener.MoveMouseListener;
import com.read.listener.ReadHotkeyListener;
import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import com.read.listener.BookActionListner;

public class MainFrame extends JFrame{
	JPanel mainPanel = new JPanel();    
	int frameWidth = 450;
	int frameHeight = 350;
	public Point tmp = null;
	public TiTlePanel titlePanel = new TiTlePanel();
	public StatePanel statePanel = new StatePanel();
	public TextPanel  textPanel = new TextPanel();
	PopupMenu pop = new PopupMenu(); 
    MenuItem exit = new MenuItem("关闭程序");
	private SystemTray tray=SystemTray.getSystemTray();
	Image icon = getToolkit().getImage(getClass().getResource("/book.png"));  
	TrayIcon trayIcon = new TrayIcon(icon, "上班摸鱼读书", pop);
    Toolkit tk = Toolkit.getDefaultToolkit();  
    
	private MouseAdapter mouseAdapter = new java.awt.event.MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            tmp = new Point(e.getX(), e.getY());
        }
    };
    private MouseMotionAdapter mouseMotionAdapter = new MouseMotionAdapter() {
    	public void mouseDragged(MouseEvent e) {
    		setLocation(new Point(getLocation().x + e.getX() - tmp.x,getLocation().y + e.getY() - tmp.y));
    	}
    };
	public MainFrame() throws AWTException{
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	    int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	    this.setBounds((width - frameWidth) / 2,(height - frameHeight) / 2, frameWidth, frameHeight); 
        this.addMouseListener(mouseAdapter);
        this.addMouseMotionListener(mouseMotionAdapter);
        this.addMouseListener(new MoveMouseListener(this));
        exit.addActionListener(new BookActionListner());  
        pop.add(exit);
        trayIcon.setImageAutoSize(true); 
        tray.add(trayIcon); 
        trayIcon.addMouseListener(new MoveMouseListener(this));
        addComponent();
        this.setType(JFrame.Type.UTILITY);
        this.setUndecorated(true);
//        tk.addAWTEventListener(new Listener(), AWTEvent.KEY_EVENT_MASK); 
        this.setSize(frameWidth, frameHeight);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setVisible(true);
        JIntellitype.getInstance().registerHotKey(0, JIntellitype.MOD_ALT, (int)'E');    
        JIntellitype.getInstance().registerHotKey(1, JIntellitype.MOD_ALT, (int)'X'); 
        JIntellitype.getInstance().registerHotKey(2, JIntellitype.MOD_ALT, (int)'C'); 
        JIntellitype.getInstance().addHotKeyListener(new ReadHotkeyListener()); 
	}

	public void addComponent(){
		this.add(titlePanel);
		this.add(statePanel);
		this.add(textPanel.scroll);
		this.add(mainPanel);
	}
	

	public void openFrame() {  
        setVisible(true);// 设置为可见  
        setAlwaysOnTop(true);
        setExtendedState(JFrame.NORMAL);  
    }
}
