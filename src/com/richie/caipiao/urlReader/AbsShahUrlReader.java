package com.richie.caipiao.urlReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public abstract class AbsShahUrlReader {

	private String caiPiaoNo;
	public String getCaiPiaoNo() {
		return caiPiaoNo;
	}
	public void setCaiPiaoNo(String caiPiaoNo) {
		this.caiPiaoNo = caiPiaoNo;
	}
	public AbsShahUrlReader(String caipiaoNo1){
		this.caiPiaoNo = caipiaoNo1;
	}
	/**
	 * 网页地址
	 * @return
	 */
	public abstract String getUrl();

	/**
	 * 读取红球信息
	 * @param reader
	 * @return
	 */
	public abstract List<String> getNos(BufferedReader reader) throws Exception;
	
	public String[] getRedNos() throws Exception {

		// 生成一个URL对象
		URL url = new URL(getUrl());
		// System.out.println(getUrl());
		// 打开URL
		HttpURLConnection urlConnection = (HttpURLConnection) url
				.openConnection();
		// 得到输入流，即获得了网页的内容
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				urlConnection.getInputStream(), "GBK"));
		List<String> nos = getNos(reader);
		String[] redNos =  null;
		if(nos != null && nos.size()>0){
			redNos = new String[nos.size()];
			nos.toArray(redNos);
		}
		return redNos;
	}
	
	public static void main(String args[]){
//		AbsShahUrlReader reader = new Shah360UrlReader("2013016");
		AbsShahUrlReader reader = new OkooShahUrlReader("2013019");
		try {
			String[] nos = reader.getRedNos();
			for (int i = 0; i < nos.length; i++) {
				System.out.println(nos[i]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
