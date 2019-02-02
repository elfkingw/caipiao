package com.richie.caipiao.ui;


import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import com.richie.caipiao.vo.CaipiaoComparator;
import com.richie.caipiao.vo.CaipiaoVo;
import com.richie.caipiao.vo.ReportVo;

public class CaipiaoReportUI extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton genBtn;
	private JButton clearBtn;
	private JRadioButton radio;
	private JRadioButton radio0;
	private JRadioButton radio1;
	private JRadioButton radio2;
	private JRadioButton radio3;
	private JEditorPane msgText;
	private JComboBox comboxBox;
	public JButton getGenBtn(){
		if(genBtn == null){
			genBtn = new JButton("彩票分析");
		}
		return genBtn;
	}
	public JButton getClearBtn(){
		if(clearBtn == null){
			clearBtn = new JButton("清空消息");
		}
		return clearBtn;
	}
	public JRadioButton getCheckBox(){
		if(radio == null){
			radio = new  JRadioButton("15期",true);
		}
		return radio;
	}
	public JRadioButton getCheckBox0(){
		if(radio0 == null){
			radio0 = new  JRadioButton("25期",true);
			radio0.setSelected(true);
		}
		return radio0;
	}
	public JRadioButton getCheckBox1(){
		if(radio1 == null){
			radio1 = new  JRadioButton("50期",true);
			radio1.setSelected(true);
		}
		return radio1;
	}
	public JRadioButton getCheckBox2(){
		if(radio2 == null){
			radio2 = new  JRadioButton("100期",true);
			radio2.setSelected(true);
		}
		return radio2;
	}
	public JRadioButton getCheckBox3(){
		if(radio3 == null){
			radio3 = new  JRadioButton("150期",true);
			radio3.setSelected(true);
		}
		return radio3;
	}
	public JEditorPane getTextArea(){
		if(msgText == null){
			msgText = new JEditorPane();
		}
		return msgText;
	}
	public CaipiaoReportUI(){
		super();
		initLize();
	}
	
	private void initLize(){
		setBounds(200,100,800,600);
		setLayout(new BorderLayout());
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnPanel.add(getGenBtn());
		btnPanel.add(getClearBtn());
		add(btnPanel,"North");
		JSplitPane centerPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JPanel userPanel = new JPanel();
		JLabel label = new JLabel("分析期号:");
		userPanel.add(label);
		comboxBox = new JComboBox();
		userPanel.add(comboxBox);
		ButtonGroup group = new ButtonGroup();
		userPanel.add(getCheckBox0());
		group.add(getCheckBox0());
		getCheckBox0().setSelected(true);
		userPanel.add(getCheckBox1());
		group.add(getCheckBox1());
		userPanel.add(getCheckBox2());
		group.add(getCheckBox2());
		userPanel.add(getCheckBox3());
		group.add(getCheckBox3());
		centerPanel.setLeftComponent(userPanel);
		JScrollPane msgPanel = new JScrollPane();
		msgPanel.setViewportView(getTextArea());
		centerPanel.setRightComponent(msgPanel);
		add(centerPanel,"Center");
		getGenBtn().addActionListener(this);
		getClearBtn().addActionListener(this);
		initComboBox();
		msgText.setEditable(false);
		msgText.setContentType("text/html");
		msgText.setText("&nbsp;");
		msgText.addHyperlinkListener(new HyperlinkListener() {
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					try {
						Desktop desktop = Desktop.getDesktop();
						desktop.browse(new URI( e.getURL().toString()));
					} catch (Exception ex) {
						ex.printStackTrace();
						System.err.println("connection error");
					}
				}

			}

		});
	}
	

	private void initComboBox(){
		List<CaipiaoVo>  list = CaipiaoListUI.getAllList();
		int size = 50;
		if(getCheckBox0().isSelected()){
			size = 25;
		}else if(getCheckBox1().isSelected()){
			size = 50;
		}else if(getCheckBox2().isSelected()){
			size = 100;
		}else if(getCheckBox3().isSelected()){
			size = 150;
		}
		list = CaipiaoListUI.fillList(list, size);
		for(int i = 0; i<list.size();i++){
			CaipiaoVo vo = list.get(i);
			comboxBox.addItem(vo.getCaipiaoNo());
		}
	}
	public Map<String, Integer> onGenRpt(String caipiaoNo,boolean isYu3,int size){
		Map<String, Integer> allMap = null;
		try{
//			new GoThread().start();
			List<CaipiaoVo>  list = CaipiaoListUI.getAllList();
			
			
			list = CaipiaoListUI.fillList(list, caipiaoNo ,size);
			CaipiaoVo lastVo =  getVo(caipiaoNo,list);
			String msg = "第【"+lastVo.getCaipiaoNo()+"】期【"+lastVo.toString()+"】 分析近【"+size+"】期结果如下：";
			addMsg(msg);
			String[] redNo = lastVo.getRedNo();
			allMap =  new HashMap<String, Integer>();
			boolean isXiao =  isEmpty(lastVo,1);
			boolean isDaqu =  isEmpty(lastVo,3);
			for(int j = 0;j< redNo.length;j++){
				String no = redNo[j];
				Map<String, List<String>> nosMap = new HashMap<String, List<String>>();
				for(int i = list.size()-1 ;i>0;i--){
					CaipiaoVo vo = list.get(i);
					if(vo.getWeek()== lastVo.getWeek()){
						String[] nos = vo.getRedNo();
						for( int k=0;k<nos.length;k++){
							String no1 = nos[k];
							if(no1.equals(no)){
								CaipiaoVo nextVo = list.get(i-1);
								String[] nextNos = nextVo.getRedNo();
								for(int z =0;z<nextNos.length;z++){
									String nextNo = nextNos[z];
									// 不考虑小区大区
//									if(!isYu3 && isXiao && 2== nextVo.getType(no) && 1==nextVo.getType(nextNo)){
//										setMap(allMap, nosMap, vo, nextVo,nextNo);
//									}
//									if(!isYu3 && isDaqu && 2==nextVo.getType(no) && 3==nextVo.getType(nextNo)){
//										setMap(allMap, nosMap, vo, nextVo,nextNo);
//									}
									if(!isYu3 ){
										setMap(allMap, nosMap, vo, nextVo,nextNo);
									}
									if((isYu3 &&(nextVo.getYu3Type(no) ==  nextVo.getYu3Type(nextNo)))){
										setMap(allMap, nosMap, vo, nextVo,nextNo);
									}
								}
							}
						}
					}
				}
				Iterator<String> it = nosMap.keySet().iterator();
				while(it.hasNext()){
					String key = (String) it.next(); 
					List<String> rList =  nosMap.get(key); 
					msg = "号码【"+no+"】后面出现【"+key+"】有【"+rList.size()+"】次:";
					for(int i =0;i<rList.size();i++){
						msg+="&nbsp;&nbsp;&nbsp;&nbsp;"+ rList.get(i);
					}
					addMsg(msg);
				}
			}
			msg = "<font color='red' >总结：<font/><br/>";
			Iterator<String> it = allMap.keySet().iterator();
			List<ReportVo> lis = new ArrayList<ReportVo>();
			while(it.hasNext()){
				ReportVo vo = new ReportVo();
				String key = (String) it.next(); 
				Integer c  =  allMap.get(key); 
				vo.setCaipiaoNo(key);
				vo.setTimes(c.intValue());
				lis.add(vo);
			}
			CaipiaoComparator comparator = new CaipiaoComparator();
			Collections.sort(lis, comparator);
			for(int i =0;i<lis.size();i++){
				msg += "&nbsp;&nbsp;号码【"+lis.get(i).getCaipiaoNo()+"】有【"+lis.get(i).getTimes()+"】次<br/>";
			}
			addMsg(msg);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			getGenBtn().setEnabled(true);
		}
		return allMap;
	}
	private void setMap(Map<String, Integer> allMap,
			Map<String, List<String>> nosMap, CaipiaoVo vo, CaipiaoVo nextVo,
			String nextNo) {
		if(nosMap.containsKey(nextNo)){
			List<String> nList = (List<String>) nosMap.get(nextNo); 
			nList.add(vo.getCaipiaoNo().substring(4) +"-->"+nextVo.getCaipiaoNo().substring(4));
		}else{
			List<String> nList = new ArrayList<String>();
			nList.add(vo.getCaipiaoNo().substring(4) +"-->"+nextVo.getCaipiaoNo().substring(4));
			nosMap.put(nextNo, nList);
		}
		if(allMap.containsKey(nextNo)){
			Integer c =  allMap.get(nextNo); 
			c = c+1;
			allMap.put(nextNo, c);
		}else{
			allMap.put(nextNo, 1);
		}
	}
	
	private boolean isEmpty(CaipiaoVo vo,int type){
		String[] redNos = vo.getRedNo();
		for(int i =0 ;i<redNos.length;i++){
			if(type == vo.getType(redNos[i])){
				return false;
			}
		}
		return true;
	}
	
	private CaipiaoVo getVo(String caipiaoNo,List<CaipiaoVo>  list){
		for(int i =0;i<list.size();i++){
			if(caipiaoNo.equals(list.get(i).getCaipiaoNo())){
				return list.get(i);
			}
		}
		return null;
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == getGenBtn()){
			getGenBtn().setEnabled(false);
			clearMsg();
			addMsg("<font color='red' >重现分析如下：<font/>");
			int size = 50;
			if(getCheckBox0().isSelected()){
				size = 25;
			}else if(getCheckBox1().isSelected()){
				size = 50;
			}else if(getCheckBox2().isSelected()){
				size = 100;
			}else if(getCheckBox3().isSelected()){
				size = 150;
			}
			String caipiaoNo = (String) comboxBox.getSelectedItem();
			Map<String, Integer> map = onGenRpt(caipiaoNo,false,size);
			addMsg("<font color='red' >余3分析如下：<font/>");
			Map<String, Integer> yu3Map = onGenRpt(caipiaoNo,true,size);
			Iterator<String> it = map.keySet().iterator();
			List<ReportVo> lis = new ArrayList<ReportVo>();
			while(it.hasNext()){
				String key = (String) it.next(); 
				if(yu3Map.containsKey(key)){
					ReportVo vo = new ReportVo();
					Integer c  =  map.get(key); 
					Integer d  =  yu3Map.get(key); 
					vo.setCaipiaoNo(key);
					vo.setTimes(c.intValue()+d.intValue());
					lis.add(vo);
				}
			}
			CaipiaoComparator comparator = new CaipiaoComparator();
			Collections.sort(lis, comparator);
			addMsg("两种都出现的号码:");
			String msg = "";
			for(int i =0;i<lis.size();i++){
				msg += "&nbsp;&nbsp;【"+lis.get(i).getCaipiaoNo()+"】一共有【"+lis.get(i).getTimes()+"】次<br/>";
			}
			addMsg(msg);
		}else if(e.getSource() == getClearBtn()){
			clearMsg();
		}
	}
	
	public void addMsg(String msg){
		String msg1 = getTextArea().getText();
		String result = appendHtml(msg1,msg);
		getTextArea().setText(result);
	}
	
	public void clearMsg(){
		getTextArea().setText("");
	}
	class GoThread extends Thread{  
		public void run() {  
			try{
				JOptionPane.showMessageDialog(null, "","提示",JOptionPane.INFORMATION_MESSAGE);
			 }catch(Exception e){
				 JOptionPane.showMessageDialog(null, "生成报表出错："+e.getMessage(),"提示",JOptionPane.INFORMATION_MESSAGE);
				 e.printStackTrace();
			 }finally{
				 getGenBtn().setEnabled(true);
			 }
		 }  
	 }  
	
	public String appendHtml(String html,String appStr){
		int start = html.indexOf("<body>");
		int end = html.indexOf("</body>");
		String s  = html.substring(start+6,end);
		s = s+appStr+"<br/>";
		return s;
	}
	
}
