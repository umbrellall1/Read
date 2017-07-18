package com.read.service;

import java.util.Map;

import com.read.vo.PageVO;
import com.read.vo.TextState;

public class PageService {
	public static PageVO page=new PageVO();;
	static int  pageTextCount = 480;
	static StringBuffer sb =new StringBuffer();
	static ReadBookService readService = new ReadBookService();
	static TextState textState = new TextState();
	static final int PAGECOUNT= 480;
	public static String getPageText(String path){
		page = readService.openTxt(path);
		if(page != null){
			return page.getContent();
		}
		return "Œ¥’“µΩ∏√ ÈºÆ£°";
	}
	
	public static TextState nextPageText(){
		sb.delete(0, sb.length());
		System.out.println(pageTextCount+"  : "+page.getPageSize());
		if(pageTextCount<page.getPageSize()){
			textState.setCotent(page.getContent().substring(pageTextCount,pageTextCount+PAGECOUNT));
			textState.setState(0);
			pageTextCount = pageTextCount+PAGECOUNT;
		}else{
			textState.setState(1);
		}
		return textState;
	}
	
	
	public static TextState previousPageText(){
		sb.delete(0, sb.length());
//		int sum = pageTextCount;
//		pageTextCount = pageTextCount -16;
//		System.out.println(pageTextCount+"  : "+page.getPageSize());
//		if(pageTextCount>0){
//			for (int i = pageTextCount; i <= sum; i++) {
//				System.out.println(i+"     ||     "+page.getTextMap().get(i));
//				sb.append(page.getTextMap().get(i));
//			}
//			textState.setCotent(sb.toString());
//			textState.setState(0);
//			
//		}else{
//			textState.setState(1);
//		}
		return textState;
	}
}
