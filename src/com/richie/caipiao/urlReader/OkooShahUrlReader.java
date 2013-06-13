package com.richie.caipiao.urlReader;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
/**
 * 澳客网杀号读取
 * @author wanghua1
 * 2013-2-17下午6:30:51
 *
 */
public class OkooShahUrlReader extends AbsShahUrlReader{

	public OkooShahUrlReader(String caipiaoNo1) {
		super(caipiaoNo1);
	}

	@Override
	public String getUrl() {
		return "http://www.okooo.com/ajax/shahao/SSQ/20/FN/";
	}

	@Override
	public List<String> getNos(BufferedReader reader) throws Exception {
		String line = null;
		List<String> noList = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {
			 JSONParser parser = new JSONParser(); 
			 JSONObject parseObject = (JSONObject)parser.parse(line);
			 JSONObject obj=  (JSONObject) parseObject.get(getCaiPiaoNo());
			 obj = (JSONObject) obj.get("KillNum");
			 System.out.println(obj);
			 @SuppressWarnings("unchecked")
			 Iterator<String> it =obj.keySet().iterator();
			 while(it.hasNext()){
				 String key =  it.next();
				 JSONObject temp = (JSONObject) obj.get(key);
				 Object no = (Object) temp.get("Num");
				 String noStr = no.toString();
				 noList.add(noStr);
			 }
		}
		List<String> resList = new ArrayList<String>();
		for (int i = noList.size()-1; i >=0; i--) {
			resList.add(noList.get(i));
		}
		return resList;
	}

}
