package com.richie.caipiao.urlReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.richie.caipiao.util.DateUtil;
import com.richie.caipiao.vo.CaipiaoVo;
/**
 * 
 * @author wanghua
 *
 */
public class CaipiaoUrlReader {
	
	private final int maxPage = 10;
	
	public List<CaipiaoVo> getList(String httpUrl , List<CaipiaoVo> eList){
		List<CaipiaoVo> list = new ArrayList<CaipiaoVo>();
		if(eList != null && eList.size()>0){
			list.addAll(eList);
		}
		try{
			// 生成一个URL对象
			URL url = new URL(httpUrl);
//			System.out.println(httpUrl);
			// 打开URL
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			// 得到输入流，即获得了网页的内容
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream(), "utf-8"));
			// 读取输入流的数据，并显示
			String line = null;
			CaipiaoVo vo = null;
			while ((line = reader.readLine()) != null) {
//				System.out.println(line);
				if(line.contains("<td align=\"center\">20") && line.contains("-")){
					vo = new CaipiaoVo();
					int index  = line.indexOf("</");
					String date = line.substring(index-10,index);
					vo.setDate(date);
					DateUtil dateUtil = new DateUtil();
					vo.setWeek(dateUtil.parseDate(date));
					list.add(vo);
				}else if(line.contains("<td align=\"center\">20")){
					int index  = line.indexOf("</");
					String no = line.substring(index-7,index);
					vo.setCaipiaoNo(no);
				}else if(line.contains("class=\"rr\">")){
					int index  = line.indexOf("</");
					String no = line.substring(index-2,index);
					int i = Integer.valueOf(no).intValue();
					vo.setRedNo(i);
				}else if(line.contains("<em>")){
					int index  = line.indexOf("</");
					String no = line.substring(index-2,index);
					vo.setBlue_no(no);
				}else if(line.contains("<p class=\"pg\">")){
					int index = httpUrl.indexOf("=")+1;
					String no = httpUrl.substring(index);
					int page = Integer.valueOf(no).intValue();
					String Url = httpUrl.substring(0, index)+(page+1);
					if(page < maxPage){
						return getList( Url , list);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args){
		CaipiaoUrlReader reader = new CaipiaoUrlReader();
		String httpUrl ="http://kaijiang.zhcw.com/zhcw/inc/ssq/ssq_wqhg.jsp?pageNum=1";
		List<CaipiaoVo>  list = reader.getList(httpUrl,null);
		for(int i=0;i<list.size();i++){
			CaipiaoVo vo = list.get(i);
			System.out.println(vo);
			
		}
	}
}
