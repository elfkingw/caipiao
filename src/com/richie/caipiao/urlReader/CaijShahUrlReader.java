package com.richie.caipiao.urlReader;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class CaijShahUrlReader extends AbsShahUrlReader{

	public CaijShahUrlReader(String caipiaoNo1) {
		super(caipiaoNo1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getUrl() {
		return "http://zst.cjcp.com.cn/shdd/ssq.php?czid=ssq&type=hq";
	}

	@Override
	public List<String> getNos(BufferedReader reader) throws Exception {
		String line = null;
		List<String> noList = new ArrayList<String>();
		while ((line = reader.readLine()) != null) {
			if(line.contains("charttab_row03") ){
				if(line.contains("charttab_bg") ){
					if(line.contains(getCaiPiaoNo())){
						String[] yiqiStr = line.split("issue_list\">"); 
						for(String caiPiaoNo : yiqiStr){
							if(caiPiaoNo.contains(getCaiPiaoNo())){
								System.out.println(caiPiaoNo);
								String[] nos = caiPiaoNo.split("shahao_number\">");
								for(int i =1;i<nos.length;i++){
									noList.add(nos[i].substring(0,2));
								}
								return noList;
							}
						}
					}
				}else{
					System.out.println(line);
					String[] nos = line.split("winning_red\">");
					for(int i =1;i<nos.length;i++){
						noList.add(nos[i].substring(0,2));
					}
					return noList;
				}
			}
		}
		return noList;
	}

	public static void main(String[] args){
		AbsShahUrlReader reader = new CaijShahUrlReader("2013019");
		try {
			String[] nos = reader.getRedNos();
			for (int i = 0;nos != null &&  i < nos.length; i++) {
				System.out.println(nos[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
