package com.richie.caipiao.urlReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.richie.caipiao.vo.Xh12RedVo;

public class Sina12UrlReader {
	private String caiPiaoNo;
	public String getCaiPiaoNo() {
		return caiPiaoNo;
	}
	public void setCaiPiaoNo(String caiPiaoNo) {
		this.caiPiaoNo = caiPiaoNo;
	}
	public Sina12UrlReader(String caipiaoNo1) {
		caiPiaoNo = caipiaoNo1;
	}
	public String getUrl() {
		return "http://sports.sina.com.cn/l/ssqleitai/"+getCaiPiaoNo().substring(2)+".html";
	}

	public List<Xh12RedVo> getRedNos() throws Exception {

		// 生成一个URL对象
		URL url = new URL(getUrl());
		// System.out.println(getUrl());
		// 打开URL
		HttpURLConnection urlConnection = (HttpURLConnection) url
				.openConnection();
		// 得到输入流，即获得了网页的内容
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				urlConnection.getInputStream(), "GBK"));
		List<Xh12RedVo> redNos =  getNos(reader);
		return redNos;
	}
	public List<Xh12RedVo> getNos(BufferedReader reader) throws Exception {
		String line = null;
		List<Xh12RedVo>  noList = new ArrayList<Xh12RedVo>();
		Xh12RedVo vo = null;
		while ((line = reader.readLine()) != null) {
//			System.out.println(line);
			if(line.contains("width=\"87\" id=\"line_f\">") ){
				vo = new Xh12RedVo();
				noList.add(vo);
				System.out.println("++++"+line);
				String[] name = line.split("line_f\">"); 
				vo.setMeiTiName(name[1].substring(0, name[1].length()-5));
				
			}else if(line.trim().startsWith("<div id=\"red\">") || line.trim().startsWith("<div id=\"grey\">")){
				System.out.println("++++"+line);
				String[] reds = line.split("</div>");
				for (int i = 0; i < reds.length-1; i++) {
					vo.addRad(reds[i].substring(reds[i].length()-2,reds[i].length()));
				}
			}else if(line.contains("width=\"67\" >")|| line.trim().startsWith("<div id=\"grey\">")){
				System.out.println("++++"+line);
				String[] blues = line.split("</div>");
				for (int i = 0; i < blues.length-1; i++) {
					vo.addBlue(blues[i].substring(blues[i].length()-2,blues[i].length()));
				}
			}
		}
		return noList;
	}
	
	public static void main(String[] args){
		Sina12UrlReader reader = new Sina12UrlReader("2013020");
		try {
			List<Xh12RedVo> nos = reader.getRedNos();
			for(Xh12RedVo vo :nos){
				System.out.println(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
