package com.richie.caipiao.urlReader;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
/**
 * 360杀号解析
 * @author wanghua1
 * 2013-2-17下午6:31:16
 *
 */
public class Shah360UrlReader extends AbsShahUrlReader{

	public Shah360UrlReader(String caipiaoNo) {
		super(caipiaoNo);
	}

	@Override
	public String getUrl() {
		return "http://cp.360.cn/shdd/sha/?LotID=220051&ItemID=20343";
	}

	@Override
	public List<String> getNos(BufferedReader reader) throws Exception {
		String line = null;
		List<String> noList = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {
			if(line.contains("t55 tbg")&& line.contains(getCaiPiaoNo()) ){
//				System.out.println(line);
				if(line.contains("tbg3\">")){
					String[] c = line.split("tbg3\">");
					for (int i = 2; i < c.length; i++) {
//						System.out.println(c[i].substring(0,2));
						noList.add(c[i].substring(0,2));
					}
				}else if(line.contains("t2\"></td><td >")){
					String[] c = line.split("</td> <td class=\"t37\">");
					for (int i = 0; i < c.length-1; i++) {
//						System.out.println(c[i].substring(0,2));
						noList.add(c[i].substring(c[i].length()-2,c[i].length()));
					}
				}
				break;
			}
		}
		return noList;
	}

}
