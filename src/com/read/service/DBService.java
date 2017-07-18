package com.read.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.read.vo.Bookmark;
import com.read.vo.MarkList;

public class DBService {

	private  static MarkList list; 
	
	public static void init() throws Exception{
		if(list == null){
			list = getdb(); 
		}
	}
	
	
	
	
	public static void db(Bookmark b) throws Exception{
		init();
		File file = new File("mark");  
		FileOutputStream fos = new FileOutputStream(file);  
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		list.getMap().put(b.getText(), b);
		oos.writeObject(list);  
		oos.flush();  
		oos.close();  
		fos.close();  
	}
	
	public static MarkList  getdb() {
		//Student对象反序列化过程  
		File file = new File("mark");  
		FileInputStream fis;
		try {
			if(file.exists()){
				fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);  
				MarkList b = (MarkList) ois.readObject(); 
				ois.close();  
				fis.close();
				return b;
			}else{
				MarkList b = new MarkList();
				b.setMap(new HashMap<String,Bookmark>());
				return b;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  
	
	}

}
