package com.read.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.read.vo.PageVO;
import com.read.vo.TextState;
//1008
public class ReadBookService {
	
	public static List<String> txt = new ArrayList<String>();
	
	public static  final int  STRCOUNT=1008;
	
	int pageNo = 1;
	
	int pageCount =0;
	
	final int ROW =16;
	
	final int COLUMN=63;
	
//	public PageVO openTxt(String path){
//         try {
//        	 PageVO page=new PageVO();
//        	 File file = new File(path);
//        	 Reader reader = new InputStreamReader(new FileInputStream(file));
//        	 StringBuffer sb = new StringBuffer();
//        	 int tempchar;
//        	 while ((tempchar = reader.read()) != -1 ) {
//        		 String  temp =   ((char)tempchar)+"";
//        		 txt.add(temp);
//        		 sb.append(new String (temp.getBytes(),"utf-8"));
//        		 sb.append(temp);
//        	 }
//        	reader.close(); 
//			page.setPageSize(txt.size());
//			System.out.println(sb.toString());
//			page.setContent(sb.toString());
//			return page;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//        
//	}
	
	public PageVO openTxt(String path){
		try {
        	PageVO page=null;
       	 	File file = new File(path);
       	 	if(file!=null){
       	 		page=new PageVO();
       	 		byte buffer[] = new byte[(int) file.length()];
       	 		FileInputStream fileinput = new FileInputStream(file);
       	 		fileinput.read(buffer);//读取文件中的内容到buffer中
       	 		String strType = getEncoding(new String(buffer));
       	 		String s = new String(buffer,strType);
       	 		page.setPageSize(0);
       	 		page.setContent(s);
       	 		fileinput.close();
       	 		return page;
       	 	}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
       
	}
	
	 public static String getEncoding(String str){  
	        String encode = "GB2312";  
	        try {  
	            if (str.equals(new String(str.getBytes(encode), encode))) {  
	                String s = encode;  
	                return s;  
	            }  
	        } catch (Exception exception) {  
	        }  
	        encode = "ISO-8859-1";  
	        try {  
	            if (str.equals(new String(str.getBytes(encode), encode))) {  
	                String s1 = encode;  
	                return s1;  
	            }  
	        } catch (Exception exception1) {  
	        }  
	        encode = "UTF-8";  
	        try {  
	            if (str.equals(new String(str.getBytes(encode), encode))) {  
	                String s2 = encode;  
	                return s2;  
	            }  
	        } catch (Exception exception2) {  
	        }  
	        encode = "GBK";  
	        try {  
	            if (str.equals(new String(str.getBytes(encode), encode))) {  
	                String s3 = encode;  
	                return s3;  
	            }  
	        } catch (Exception exception3) {  
	        }  
	        return "";  
	    }  
	
	

//	
//	public TextState nextPageText(){
//		TextState textState = new TextState();
//		int endCount = pageNo*pageCount;
//		int tempCount = pageCount;
//		StringBuffer sb = new StringBuffer();
//		if(pageCount <=txt.size()){
//			int count = STRCOUNT;
//			for(int i=tempCount;i < endCount;i++){
//				char  temp =   txt.get(i);
//				if(count > 0){;
//					sb.append(temp);
//					if((temp+"").matches("[\u4e00-\u9faf]")){
//						count =count-2;
//	       		 	}else{
//	       		 		count--;
//	       		 	} 
//					pageCount++;
//				}
//			}
//			textState.setCotent(sb.toString());
//			textState.setState(0);
//			return textState;
//		}else{
//			textState.setState(1);
//			return textState;
//		}
//	}
//	
//	public String typeSet(int start){
//		StringBuffer sb = new StringBuffer();
//		int tempRow = ROW;
//		int count = 0;
//		sb.append("0");
//		for (int i = start; i < txt.size(); i++) {
//			char temp = txt.get(i);
//			if(tempRow > 0){
//				sb.append(temp);
//				if(temp ==13||temp ==10){
//					sb.append(txt.get(i+1));
//					sb.append(count);
//					tempRow--;
//					count = 0;
//					sb.append(" "+count);
//					i++;
//				}
//				if(count >COLUMN){
//					sb.append("\r\n"+":"+count);
//					count = 0;
//					if((tempRow-1)==0){
//						return sb.toString();
//					}
//				}
//				if((temp+"").matches("[\u4e00-\u9faf]")){
//					count =count+2;
//				}else{
//					count++;
//				}
//			
//			}else{
//				return sb.toString();
//			}
//		}
//		return sb.toString();
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
}
