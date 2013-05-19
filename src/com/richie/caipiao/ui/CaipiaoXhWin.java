package com.richie.caipiao.ui;


import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import com.richie.caipiao.combin.Combination;
import com.richie.caipiao.ui.ball.BallLabel;
import com.richie.caipiao.urlReader.AbsShahUrlReader;
import com.richie.caipiao.urlReader.CaijShahUrlReader;
import com.richie.caipiao.urlReader.OkooShahUrlReader;
import com.richie.caipiao.urlReader.Shah360UrlReader;
import com.richie.caipiao.urlReader.Sina12UrlReader;
import com.richie.caipiao.util.DateUtil;
import com.richie.caipiao.vo.CaipiaoComparator;
import com.richie.caipiao.vo.CaipiaoVo;
import com.richie.caipiao.vo.ReportVo;
import com.richie.caipiao.vo.ShaHComparator;
import com.richie.caipiao.vo.Xh12RedVo;

public class CaipiaoXhWin extends JFrame  implements ActionListener{

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
	private JEditorPane shaHText;
	private JEditorPane xuanHText;
	private JComboBox comboxBox;
	private BallLabel[] balls;
	private JCheckBox checkbox;
	private JCheckBox checkbox3;
	private JButton cBtn;
	private JButton cancelBtn;
	private JButton exportBtn;
	private JButton shaHBtn;//红球杀号
	private JButton xuanHBtn;//选号
	
	private JComboBox minJishuBox;
	private JComboBox maxJishuBox;
	private JComboBox minXiaoshuBox;
	private JComboBox maxXiaoshuBox;
	private JComboBox minPrimeBox;//质数个数
	private JComboBox maxPrimeBox;//质数个数
	private JCheckBox checkbox4;//连号
	private JCheckBox checkbox5;//和指过滤
	private JTextField minSum;//和值最小值
	private JTextField maxSum;//和值最大值
	private JCheckBox checkbox6;//最小值
	private JTextField minfrist;//开头最小值
	private JTextField maxfrist;//开头最大值
	
	public JButton getGenBtn(){
		if(genBtn == null){
			genBtn = new JButton("选号分析");
		}
		return genBtn;
	}
	public JButton getClearBtn(){
		if(clearBtn == null){
			clearBtn = new JButton("清空消息");
		}
		return clearBtn;
	}
	public JButton getExportBtn(){
		if(exportBtn == null){
			exportBtn = new JButton("导出分析结果");
		}
		return exportBtn;
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
	public JEditorPane getXuanhTextArea(){
		if(xuanHText == null){
			xuanHText = new JEditorPane();
			xuanHText.setPreferredSize(new Dimension(300, 300));
			xuanHText.setEditable(false);
			xuanHText.setContentType("text/html");
			xuanHText.setText("&nbsp;");
			xuanHText.addHyperlinkListener(new HyperlinkListener() {
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
		return xuanHText;
	}
	
	public JButton getXuanHBtn(){
		if(xuanHBtn == null){
			xuanHBtn = new JButton("12红球");
		}
		return xuanHBtn;
	}
	public JEditorPane getShahTextArea(){
		if(shaHText == null){
			shaHText = new JEditorPane();
			shaHText.setPreferredSize(new Dimension(300, 300));
			shaHText.setEditable(false);
			shaHText.setContentType("text/html");
			shaHText.setText("&nbsp;");
			shaHText.addHyperlinkListener(new HyperlinkListener() {
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
		return shaHText;
	}
	
	public JButton getShaHBtn(){
		if(shaHBtn == null){
			shaHBtn = new JButton("红球杀号分析");
		}
		return shaHBtn;
	}
	public CaipiaoXhWin(){
		super();
		initLize();
	}
	
	private void initLize(){
		setBounds(210,110,1200,500);
		setLayout(new BorderLayout());
		setTitle("选号分析");
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnPanel.add(getGenBtn());
		btnPanel.add(getClearBtn());
		btnPanel.add(getExportBtn());
		add(btnPanel,"North");
		
//		JSplitPane centerPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		northPanel.add(getUserPanel(),"North");
		northPanel.add(getBallPanel(),"Center");
		northPanel.add(getSouthPanel(),"South");
		
		centerPanel.add(northPanel,"North");
		
		JScrollPane msgPanel = new JScrollPane();
		msgPanel.setViewportView(getTextArea());
		msgPanel.setPreferredSize(new Dimension(300, 300));
		centerPanel.add(msgPanel,"West");
		
		centerPanel.add(getshaHPanel(),"East");
		centerPanel.add(getXuanHPanel(),"Center");
		
		add(centerPanel,"Center");
		
		getGenBtn().addActionListener(this);
		getClearBtn().addActionListener(this);
		getExportBtn().addActionListener(this);
		getShaHBtn().addActionListener(this);
		getXuanHBtn().addActionListener(this);
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
	private JPanel getshaHPanel(){
		JPanel panel = new  JPanel(new BorderLayout());
		panel.setSize(400, 300);
		panel.setBorder(BorderFactory.createTitledBorder("红球杀号"));
		JScrollPane msgPanel = new JScrollPane();
		msgPanel.setViewportView(getShahTextArea());
		JPanel northPanel = new JPanel();
		northPanel.add(getShaHBtn());
		panel.add(northPanel,"North");
		panel.add(msgPanel,"Center");
		return panel;
	}
	private JPanel getXuanHPanel(){
		JPanel panel = new  JPanel(new BorderLayout());
		panel.setSize(600, 300);
		panel.setBorder(BorderFactory.createTitledBorder("12红球"));
		JScrollPane msgPanel = new JScrollPane();
		msgPanel.setViewportView(getXuanhTextArea());
		JPanel northPanel = new JPanel();
		northPanel.add(getXuanHBtn());
		panel.add(northPanel,"North");
		panel.add(msgPanel,"Center");
		return panel;
	}
	
	
	private JPanel getBallPanel(){
		JPanel panel = new  JPanel(new BorderLayout());
		JPanel ballPanel = new JPanel(new FlowLayout());
		ballPanel.setBorder(BorderFactory.createTitledBorder("选择号码"));
		balls = new BallLabel[33];
		for(int i =0;i<33;i++){
			BallLabel ballLabel = null;
			if(i<9){
				ballLabel = new BallLabel("0"+(i+1));
				ballPanel.add(ballLabel);
			}else{
				ballLabel= new BallLabel(""+(i+1));
				ballPanel.add(ballLabel);
			}
			addMosuseLisentler(ballLabel);
			balls[i] = ballLabel;
		}
		panel.add(ballPanel,"Center");
		JPanel southPanel = new JPanel();
		JLabel redBall = new JLabel();
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("images/red.png"));//创建图片对象
		redBall.setIcon(img);
		JLabel redLabel = new JLabel("--红色为选中球");
		southPanel.add(redBall);
		southPanel.add(redLabel);
		JLabel volitBall = new JLabel();
		ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("images/violet.png"));//创建图片对象
		volitBall.setIcon(img1);
		JLabel volitLabel = new JLabel("--紫色为必选球（双击）");
		southPanel.add(volitBall);
		southPanel.add(volitLabel);
		panel.add(southPanel,"South");
		return panel;
	}
	private JPanel getUserPanel(){
		JPanel userPanel = new JPanel();
		JLabel label = new JLabel("选号期号:");
		userPanel.add(label);
		comboxBox = new JComboBox();
		userPanel.add(comboxBox);
		
		JLabel clabel = new JLabel("分析类型选择：");
		userPanel.add(clabel);
		checkbox = new JCheckBox("重现");
		userPanel.add(checkbox);
		checkbox3 = new JCheckBox("余3");
		checkbox3.setSelected(true);
		userPanel.add(checkbox3);
		
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
		cBtn = new JButton("确定");
		userPanel.add(cBtn);
		cBtn.addActionListener(this);
		cancelBtn = new JButton("取消选择");
		userPanel.add(cancelBtn);
		cancelBtn.addActionListener(this);
		return userPanel;
	}
	private void addMosuseLisentler(BallLabel ballLabel){
		ballLabel.addMouseListener(new MouseAdapter(){ 
			public void mouseClicked(MouseEvent e){ 
				 BallLabel pitLabel = (BallLabel) e.getSource();
				 if(e.getClickCount()==2){   
					  pitLabel.ondbClick();
				  }else{
					  pitLabel.onClick();
				  }
				}
		}); 
	}
	private JPanel getSouthPanel(){
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("选号条件"));
		panel.setSize(80, 100);
		JLabel label2 = new JLabel("质数个数:");
		panel.add(label2);
		
		JLabel label21 = new JLabel(">=");
		panel.add(label21);
		minPrimeBox = new JComboBox();
		panel.add(minPrimeBox);
		JLabel label22 = new JLabel("<=");
		panel.add(label22);
		maxPrimeBox = new JComboBox();
		panel.add(maxPrimeBox);
		
		JLabel label1 = new JLabel("小区个数:");
		panel.add(label1);
		JLabel label31 = new JLabel(">=");
		panel.add(label31);
		minXiaoshuBox = new JComboBox();
		panel.add(minXiaoshuBox);
		JLabel label32 = new JLabel("<=");
		panel.add(label32);
		maxXiaoshuBox = new JComboBox();
		panel.add(maxXiaoshuBox);
		
		JLabel label = new JLabel("奇数个数:");
		panel.add(label);
		JLabel label41 = new JLabel(">=");
		panel.add(label41);
		minJishuBox = new JComboBox();
		panel.add(minJishuBox);
		JLabel label42 = new JLabel("<=");
		panel.add(label42);
		maxJishuBox = new JComboBox();
		panel.add(maxJishuBox);
		minJishuBox.addItem("");
		maxJishuBox.addItem("");
		minXiaoshuBox.addItem("");
		maxXiaoshuBox.addItem("");
		minPrimeBox.addItem("");
		maxPrimeBox.addItem("");
		for(int i=1;i<6;i++){
			minJishuBox.addItem(i+"");
			maxJishuBox.addItem(i+"");
			minXiaoshuBox.addItem(i+"");
			maxXiaoshuBox.addItem(i+"");
			minPrimeBox.addItem(i+"");
			maxPrimeBox.addItem(i+"");
		}
		
		checkbox4 = new JCheckBox("连号");
		panel.add(checkbox4);
		
		checkbox5 = new JCheckBox("和值范围:");
		panel.add(checkbox5);
		minSum = new JTextField(5);
		minSum.setText("80");
		panel.add(minSum);
		JLabel label11 = new JLabel("到");
		panel.add(label11);
		maxSum = new JTextField(5);
		maxSum.setText("140");
		panel.add(maxSum);
		
		checkbox6 = new JCheckBox("最小数范围:");
		checkbox6.setSelected(true);
		panel.add(checkbox6);
		minfrist = new JTextField(2);
		minfrist.setText("1");
		panel.add(minfrist);
		JLabel label12 = new JLabel("到");
		panel.add(label12);
		maxfrist = new JTextField(2);
		maxfrist.setText("9");
		panel.add(maxfrist);
		return panel;
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
	private Map<String, Integer> getNo(boolean isYu3){
		Map<String, Integer> map = null;
		try{
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
			CaipiaoReportUI reportUI = new CaipiaoReportUI();
			String caipiaoNo = (String) comboxBox.getSelectedItem();
			map = reportUI.onGenRpt(caipiaoNo,isYu3,size);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			getGenBtn().setEnabled(true);
		}
		return map;
	}
	
	public void radomNo(){
		List<String[]> list = dealBall();
		clearMsg();
		String msg = null;
		if(list!= null && list.size()>0){
			if(list.size()>1000){
				msg = "得出排列组合结果为【"+list.size()+"】大于1000，放弃显示";
				JOptionPane.showMessageDialog(this, msg,"提示",JOptionPane.INFORMATION_MESSAGE);
				addMsg(msg);
				return;
			}
			msg = "分析结果如下：<br/>";
			addMsg(msg);
			list = sort(list);
			msg = getList(list);
			addMsg(msg);
			addMsg("一共有"+list.size()+"个排列组合");
		}else{
			msg = "没有符合条件的结果";
			addMsg(msg);
		}
	}
	private List<String[]> dealBall() {
		List<String> selectNos = getSelectNos();
		if(selectNos.size() <=6){
			JOptionPane.showMessageDialog(this, "请选择6个或六个以上红球","提示",JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
		String minjishu = (String) minJishuBox.getSelectedItem();
		String maxjishu = (String) maxJishuBox.getSelectedItem();
		String minxiaoqu = (String) minXiaoshuBox.getSelectedItem();
		String maxxiaoqu = (String) maxXiaoshuBox.getSelectedItem();
		String minprime = (String) minPrimeBox.getSelectedItem();
		String maxprime = (String) maxPrimeBox.getSelectedItem();
		boolean isLianhao = checkbox4.isSelected();
		boolean isSum = checkbox5.isSelected();
		boolean isFrist = checkbox6.isSelected();
		if(!isSelect( minjishu,maxjishu, minxiaoqu,maxxiaoqu,minprime,maxprime)){
			return null;
		}
		List<String[]> list = null;
		if(!"".equals(minprime) || !"".equals(maxprime)){
			list = fill( minprime,maxprime, selectNos,BallLabel.TYPE_PRIME); 
		}
		if(!"".equals(minxiaoqu) || !"".equals(maxxiaoqu)){
			if(list == null){
				list = fill( minxiaoqu, maxxiaoqu,selectNos,BallLabel.TYPE_XIAOQUSHU); 
			}else{
				list = fillXiaoShu(minxiaoqu,maxxiaoqu,list,BallLabel.TYPE_XIAOQUSHU);
			}
		}
		if(!"".equals(minjishu) || !"".equals(maxjishu)){
			if(list == null){
				list = fill( minjishu,maxjishu, selectNos,BallLabel.TYPE_JISHU); 
			}else{
				list = fillXiaoShu(minjishu,maxjishu,list,BallLabel.TYPE_JISHU);
			}
		}
		if(isLianhao){
			list = fillLianhao(list);
		}
		if(isSum){
			int min = Integer.valueOf(minSum.getText()).intValue();
			int max = Integer.valueOf(maxSum.getText()).intValue();
			list = fillSum(list,min,max);
		}
		if(isFrist){
			int min = Integer.valueOf(minfrist.getText()).intValue();
			int max = Integer.valueOf(maxfrist.getText()).intValue();
			list = fillFrist(list,min,max);
		}
		List<BallLabel> specialList = getSpecialNos();
		list = fillspecial(specialList,list);
		return list;
	}
	private List<String[]> sort(List<String[]> list){
		List<String[]> resList = new ArrayList<String[]>();
 		Map<String ,String[]> map = new HashMap<String,String[]>();
		List<String> keys = new ArrayList<String>();
		for(String[] a : list){
			sort(a);
			String key = null;
			for(String no : a){
				key+=no;
			}
			map.put(key, a);
			keys.add(key);
		}
		Collections.sort(keys);
		for(String key :keys){
			String[] nos = map.get(key);
			resList.add(nos);
		}
		return resList;
	}
	private List<String[]> fillLianhao(List<String[]> list){
		List<String[]> lst = new ArrayList<String[]>();
		for(String[] a:list){
			sort(a);
			for(int i=1;i<a.length;i++){
				if(Integer.valueOf(a[i])-Integer.valueOf(a[i-1])==1){
					lst.add(a);
					break;
				}
			}
		}
		return lst;
	}
	private List<String[]> fillFrist(List<String[]> list,int min,int max){
		List<String[]> lst = new ArrayList<String[]>();
		lst = sort(lst);
		for(String[] a:list){
			int sum =Integer.valueOf(a[0]);
			if(sum>=min && sum<=max){
				lst.add(a);
			}
		}
		return lst;
	}
	private List<String[]> fillSum(List<String[]> list,int min,int max){
		List<String[]> lst = new ArrayList<String[]>();
		for(String[] a:list){
			int sum =0;
			for(int i=1;i<a.length;i++){
				sum = sum +Integer.valueOf(a[i]);
			}
			if(sum>=min && sum<=max){
				lst.add(a);
			}
		}
		return lst;
	}
	private List<String[]> fillXiaoShu(String min,String max,List<String[]> list,String type){
		List<String[]> lst = new ArrayList<String[]>();
		for(String[] a:list){
			int xiaoshu = 0;
			for(String s: a){
				if(BallLabel.TYPE_XIAOQUSHU.equals(type)){
					if(BallLabel.isXiaoshu(s)){
						xiaoshu++;
					}
				}else if(BallLabel.TYPE_PRIME.equals(type)){
					if(BallLabel.isPrime(s)){
						xiaoshu++;
					}
				}else if(BallLabel.TYPE_JISHU.equals(type)){
					if(BallLabel.isJishu(s)){
						xiaoshu++;
					}
				}
			}
			int minNo =0;
			int maxNo =6;
			if(!"".equals(min) ){
				minNo = Integer.valueOf(min);
			}
			if(!"".equals(max)){
				maxNo = Integer.valueOf(max);
			}
			if(xiaoshu>=minNo && xiaoshu <= maxNo ){
				lst.add(a);
			}
		}
		return lst;
	}
	private List<String[]> fillspecial(List<BallLabel> specialList,List<String[]> list){
		if(list == null){
			return null;
		}else if(specialList == null || specialList.size() ==0){
			return list;
		}
		List<String[]> lst = new ArrayList<String[]>();
		for(String[] s:list){
			Map<String ,String> map = genMap(s);
			boolean isHas = true;
			for(BallLabel label :specialList){
				if(!map.containsKey(label.getBallNo())){
					isHas = false;
				}
			}
			if(isHas)
				lst.add(s);
		}
		return lst;
	}
	
	private Map<String ,String> genMap(String[] s){
		Map<String ,String> map = new HashMap<String ,String>();
		for(String str :s){
			map.put(str, str);
		}
		return map;
	}
	private List<String[]> fill(String minStr,String maxStr ,List<String> selectNos,String type){
		int min = 0;
		int max = 6;
		if(!"".equals(minStr)){
			min = Integer.valueOf(minStr).intValue();
		}
		if(!"".equals(maxStr)){
			max = Integer.valueOf(maxStr).intValue();
		}
		List<String[]> list = new ArrayList<String[]>();
		for(int i=min;i<=max;i++){
			List<String[]> flist = fillJishu(i,selectNos,type);
			if(flist != null){
				list.addAll(flist);
			}
		}
		return list;
	}
	
	private List<String[]> fillJishu(int jishu,List<String> selectNos,String type){
		List<String[]> resList = new ArrayList<String[]>();
		int js = Integer.valueOf(jishu).intValue();
		int os = 6-js;
		List<String> jishuList = new ArrayList<String>();
		List<String> ouShuList = new ArrayList<String>();
		for(String no:selectNos){
			if(BallLabel.TYPE_JISHU.equals(type)){
				if(BallLabel.isJishu(no)){
					jishuList.add(no);
				}else{
					ouShuList.add(no);
				}
			}else if(BallLabel.TYPE_XIAOQUSHU.equals(type)){
				if(BallLabel.isXiaoshu(no)){
					jishuList.add(no);
				}else{
					ouShuList.add(no);
				}
			}else if(BallLabel.TYPE_PRIME.equals(type)){
				if(BallLabel.isPrime(no)){
					jishuList.add(no);
				}else{
					ouShuList.add(no);
				}
			}
		}
		Combination comb = new Combination();
		if(jishuList.size()<js && js!=0){
			return null;
		}
		comb.mn(jishuList, js);
		List<String[]> jsList = comb.getCombList();
		Combination comb1 = new Combination();
		if(ouShuList.size()<os){
			return null;
		}
		comb1.mn(ouShuList, os);
		List<String[]> osList = comb1.getCombList();
		if(js ==0){
			return osList;
		}
		for(int i =0;i<jsList.size();i++){
			String[] jsArray = jsList.get(i);
			for(int j =0;j<osList.size();j++){
				String[] osArray = osList.get(j);
				String[] rsArray =comb.com(jsArray, osArray);
				resList.add(rsArray);
			}
		}
		return  resList;
	}
	
	private List<String> getSelectNos (){
		List<String> nos = new ArrayList<String>();
		for(int i =0;balls != null &&i<balls.length;i++){
			if(balls[i].isSelected()){
				nos.add(balls[i].getBallNo());
			}
		}
		return nos;
	}
	private List<BallLabel> getSpecialNos (){
		List<BallLabel> nos = new ArrayList<BallLabel>();
		for(int i =0;balls != null &&i<balls.length;i++){
			if(balls[i].isSpecial()){
				nos.add(balls[i]);
			}
		}
		return nos;
	}
	private boolean isSelect(String jishu1,String jishu2,String xiaoqu1,String xiaoqu2,String prime1,String prime2){
		boolean isSelect = true;
		if("".equals(jishu1) && "".equals(jishu2) &&"".equals(xiaoqu1)&&"".equals(xiaoqu2)&& "".equals(prime1)&& "".equals(prime2)){
			JOptionPane.showMessageDialog(this, "必须选一项选号条件否则排列组合太多","提示",JOptionPane.INFORMATION_MESSAGE);
			isSelect = false;
		}
		return isSelect;
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cBtn){
			Map<String, Integer> map = getNo(false);
			Map<String, Integer> map3 = getNo(true);
			clearBall();
			if(checkbox.isSelected()){
				setBall(map);
			}
			if(checkbox3.isSelected()){
				setBall(map3);
			}
		}else if(e.getSource() == genBtn){
			radomNo();
		}else if(e.getSource() == getClearBtn()){
			clearMsg();
		}else if(e.getSource() == cancelBtn){
			for(BallLabel ball: balls){
				ball.setSelected(false);
			}
		}else if(e.getSource() == exportBtn){
			exportFile();
		}else if(e.getSource() == getShaHBtn()){
			shaH();
		}else if(e.getSource() == getXuanHBtn()){
			SinaXh();
		}
	}
	
	private void shaH(){
		getShahTextArea().setText("");
		String caipiaoNo = (String) comboxBox.getSelectedItem();
		String caipiaoNoStr = String.valueOf(Integer.valueOf(caipiaoNo).intValue()+1);
		addSHMsg("期号："+caipiaoNoStr+"杀红球分析如下");
		Map<String,Integer> shaHMap = new HashMap<String,Integer>();
		try{
			AbsShahUrlReader reader = new Shah360UrlReader(caipiaoNoStr);
			String[] redNos  = reader.getRedNos();
			String no360s = "";
//			for (int i = 0; i < redNos.length; i++) {
//				no360s += redNos[i]+" ";
//				setMap(shaHMap, redNos[i]);
//			}
//			
//			addSHMsg("<a href='http://cp.360.cn/shdd/sha/?LotID=220051&ItemID=20343' >360网站</a>："+no360s);
			reader = new OkooShahUrlReader(caipiaoNoStr);
			redNos  = reader.getRedNos();
			no360s = "";
			for (int i = 0; i < redNos.length; i++) {
				no360s += redNos[i]+" ";
				setMap(shaHMap, redNos[i]);
			}
			addSHMsg("<a href='http://www.okooo.com/shuangseqiu/ssqsh/fn/' > 澳客网</a> &nbsp;："+no360s);
			
			reader = new CaijShahUrlReader(caipiaoNoStr);
			redNos  = reader.getRedNos();
			no360s = "";
			for (int i = 0; i < redNos.length; i++) {
				no360s += redNos[i]+" ";
				setMap(shaHMap, redNos[i]);
			}
			addSHMsg("<a href='http://zst.cjcp.com.cn/shdd/ssq.php?czid=ssq&type=hq' > 彩经网</a> &nbsp;："+no360s);
			Iterator<String> it = shaHMap.keySet().iterator();
			List<ReportVo> lis = new ArrayList<ReportVo>();
			while(it.hasNext()){
				ReportVo vo = new ReportVo();
				String key = (String) it.next(); 
				Integer c  =  shaHMap.get(key); 
				vo.setCaipiaoNo(key);
				vo.setTimes(c.intValue());
				lis.add(vo);
			}
			ShaHComparator comparator = new ShaHComparator();
			Collections.sort(lis, comparator);
			for(int i =0;i<lis.size();i++){
				addSHMsg( "&nbsp;&nbsp;号码【"+lis.get(i).getCaipiaoNo()+"】有【"+lis.get(i).getTimes()+"】次");
			}
			addSHMsg( "&nbsp;&nbsp;一共杀号"+lis.size()+"个");
		}catch(Exception e){
			
		}
		
	}
	private void SinaXh(){
		getXuanhTextArea().setText("");
		String caipiaoNo = (String) comboxBox.getSelectedItem();
		String caipiaoNoStr = String.valueOf(Integer.valueOf(caipiaoNo).intValue()+1);
		addXhMsg("期号："+caipiaoNoStr+"12红球分析如下");
		Map<String,Integer> redHMap = new HashMap<String,Integer>();
		Map<String,Integer> blueHMap = new HashMap<String,Integer>();
		try{
			Sina12UrlReader reader = new Sina12UrlReader(caipiaoNoStr);
			List<Xh12RedVo>  redNos  = reader.getRedNos();
			addXhMsg("<a href='http://sports.sina.com.cn/l/ssqleitai/"+reader.getCaiPiaoNo().substring(2)+".html' > 新浪媒体擂台</a> &nbsp;：");
			for(Xh12RedVo vo : redNos){
				addXhMsg(vo.toString());
				List<String> redList = vo.getRed12Ball();
				List<String> blueList = vo.getBlue3Ball();
				for(String red : redList){
					setMap(redHMap, red);
				}
				for(String blue : blueList){
					setMap(blueHMap, blue);
				}
			}
			Iterator<String> it = redHMap.keySet().iterator();
			List<ReportVo> lis = new ArrayList<ReportVo>();
			while(it.hasNext()){
				ReportVo vo = new ReportVo();
				String key = (String) it.next(); 
				Integer c  =  redHMap.get(key); 
				vo.setCaipiaoNo(key);
				vo.setTimes(c.intValue());
				lis.add(vo);
			}
			ShaHComparator comparator = new ShaHComparator();
			Collections.sort(lis, comparator);
			addXhMsg("红球如下：");
			for(int i =0;i<lis.size();i++){
				addXhMsg( "&nbsp;&nbsp;号码【"+lis.get(i).getCaipiaoNo()+"】有【"+lis.get(i).getTimes()+"】次");
			}
			addXhMsg( "&nbsp;&nbsp;一共选号"+lis.size()+"个");
			
			 it = blueHMap.keySet().iterator();
			 lis = new ArrayList<ReportVo>();
			while(it.hasNext()){
				ReportVo vo = new ReportVo();
				String key = (String) it.next(); 
				Integer c  =  blueHMap.get(key); 
				vo.setCaipiaoNo(key);
				vo.setTimes(c.intValue());
				lis.add(vo);
			}
			comparator = new ShaHComparator();
			Collections.sort(lis, comparator);
			addXhMsg("蓝球如下：");
			for(int i =0;i<lis.size();i++){
				addXhMsg( "&nbsp;&nbsp;号码【"+lis.get(i).getCaipiaoNo()+"】有【"+lis.get(i).getTimes()+"】次");
			}
			addXhMsg( "&nbsp;&nbsp;一共选号"+lis.size()+"个");
		}catch(Exception e){
			
		}
	}
	private void setMap(Map<String,Integer> shaHMap,String redNo ){
		if(shaHMap.containsKey(redNo)){
			Integer times = (Integer) shaHMap.get(redNo);
			shaHMap.put(redNo, times+1);
		}else{
			shaHMap.put(redNo, new Integer(1));
		}
	}
	private void exportFile(){
		List<String[]> list = dealBall();
		if(list == null){
			return;
		}
		list = sort(list);
		if(list.size()>30){
			JOptionPane.showMessageDialog(this, "排列组合为【"+list.size()+"】个大于30个不导出文件","提示",JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		File folder = new File("D:\\双色球");
		BufferedWriter output  = null;
		String caipiaoNo = (String) comboxBox.getSelectedItem();
		File file = null;
		try {
			if(!folder.exists()){
				if(folder.mkdir()){
				}
			}
			file = new File("D:\\双色球\\"+(Integer.valueOf(caipiaoNo)+1)+".txt");
			if(!file.exists()){
				file.createNewFile();
			}
			output = new BufferedWriter(new FileWriter(file,true));
			output.write("====================="+DateUtil.format(new Date(System.currentTimeMillis()))+ "分析期号【"+(Integer.valueOf(caipiaoNo)+1)+"】=============================================");
			output.write("\n  分析结果如下：\n");
			output.write(getSelectNo());
			for(String[] balls :list){
				output.write("\n");
				for(String no :balls){
					output.write(no+"  ");
				}
			}
			output.write("\n一共有"+list.size()+"个排列组合\n\n");
			output.flush();
			JOptionPane.showMessageDialog(this, "成功导出文件,文件地址为【D:\\双色球\\"+(Integer.valueOf(caipiaoNo)+1)+".txt】","提示",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(output != null){
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private String getSelectNo(){
		StringBuffer res = new StringBuffer("  可选号为： ");
		String specialNos= "";
		for(int i =0;balls != null &&i<balls.length;i++){
			if(balls[i].isSelected()){
				res.append(balls[i].getBallNo()+" ");
			}
			if(balls[i].isSpecial()){
				specialNos+=" 【"+balls[i].getBallNo()+"】";
			}
		}
		res.append("\n  选号条件：");
		res.append("\n");
		
		if(!"".equals(specialNos)){
			res.append("  必选球为：" + specialNos);
		}
		String minjishu = (String) minJishuBox.getSelectedItem();
		String maxjishu = (String) maxJishuBox.getSelectedItem();
		String minxiaoqu = (String) minXiaoshuBox.getSelectedItem();
		String maxxiaoqu = (String) maxXiaoshuBox.getSelectedItem();
		String minprime = (String) minPrimeBox.getSelectedItem();
		String maxprime = (String) maxPrimeBox.getSelectedItem();
		boolean isLianhao = checkbox4.isSelected();
		boolean isSum = checkbox5.isSelected();
		boolean isFrist = checkbox6.isSelected();
		if(!"".equals(minprime) || !"".equals(maxprime)){
			res.append("  质数个数 ");
			if(!"".equals(minjishu)){
				res.append(" >=【"+minprime+"】 ");
			}
			if(!"".equals(maxprime)){
				res.append(" <=【"+maxprime+"】 ");
			}
		}
		if(!"".equals(minxiaoqu)&&!"".equals(maxxiaoqu)){
			res.append("  小区个数" );
			if(!"".equals(minxiaoqu)){
				res.append(" >=【"+minxiaoqu+"】 ");
			}
			if(!"".equals(maxxiaoqu)){
				res.append(" <=【"+maxxiaoqu+"】 ");
			}
		}
		if(!"".equals(minjishu) || !"".equals(maxjishu)){
			res.append("  奇数个数 ");
			if(!"".equals(minjishu)){
				res.append(" >=【"+minjishu+"】 ");
			}
			if(!"".equals(maxjishu)){
				res.append(" <=【"+maxjishu+"】 ");
			}
		}
		if(isLianhao){
			res.append("  有连号");
		}
		if(isSum){
			int min = Integer.valueOf(minSum.getText()).intValue();
			int max = Integer.valueOf(maxSum.getText()).intValue();
			res.append("  和值大小范围为"+min+"-"+max);
		}
		if(isFrist){
			int min = Integer.valueOf(minfrist.getText()).intValue();
			int max = Integer.valueOf(maxfrist.getText()).intValue();
			res.append("  最小值范围为"+min+"-"+max);
		}
		return res.toString();
	}
	private void setBall(Map<String, Integer> map){
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()){
			String key = (String) it.next(); 
			for(int i =0;i<balls.length;i++){
				if(balls[i].getBallNo().equals(key)){
					balls[i].setSelected(true);
				}
			}
		}
	}
	private void clearBall(){
		for(int i =0;i<balls.length;i++){
			balls[i].setSelected(false);
		}
	}
	private String getList(List<String[]> list){
		StringBuffer sb = new StringBuffer("");
		for(String[] s :list){
			sort(s);
			for(String no:s){
				sb.append(getImg(no));
			}
			sb.append("<br/>");
		}
		return sb.toString();
	}
	private String[] sort(String[] a){
		List<String > list = new ArrayList<String>();
		for(int i = 0;i<a.length;i++){
			list.add(a[i]);
		}
		Collections.sort(list);
		list.toArray(a);
		return a;
	}
	private String getImg(String no){
		List<BallLabel> list  =getSpecialNos();
		boolean isSpecial = false;
		for(BallLabel ball :list){
			if(no.equals(ball.getBallNo())){
				isSpecial = true;
			}
		}
		if(isSpecial){
			return "<img src='"+ClassLoader.getSystemResource("images/violet_"+no+".png")+"'/>";
		}else{
			return "<img src='"+ClassLoader.getSystemResource("images/red_"+no+".png")+"'/>";
		}
	}
	
	public void addMsg(String msg){
		String msg1 = getTextArea().getText();
		String result = appendHtml(msg1,msg);
		getTextArea().setText(result);
	}
	public void addSHMsg(String msg){
		String msg1 = getShahTextArea().getText();
		String result = appendHtml(msg1,msg);
		getShahTextArea().setText(result);
	}
	public void addXhMsg(String msg){
		String msg1 = getXuanhTextArea().getText();
		String result = appendHtml(msg1,msg);
		getXuanhTextArea().setText(result);
	}
	public void clearMsg(){
		getTextArea().setText("");
	}
	
	public String appendHtml(String html,String appStr){
		int start = html.indexOf("<body>");
		int end = html.indexOf("</body>");
		String s  = html.substring(start+6,end);
		s = s+appStr+"<br/>";
		return s;
	}
	
	public static void main(String[] args){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		CaipiaoXhWin win = new CaipiaoXhWin();
		win.setVisible(true);
	}
	
}
