package com.richie.caipiao.ui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import com.richie.caipiao.ui.ball.BallLabel;
import com.richie.caipiao.ui.chart.CaipiaoChartVo;
import com.richie.caipiao.ui.chart.LineChartGen;
import com.richie.caipiao.vo.CaipiaoVo;

public class CaipiaoChartUI extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton genBtn;
	private JButton clearBtn;
	private JRadioButton radio;
	private JRadioButton radio0;
	private JRadioButton radio1;
	private JEditorPane msgText;
	private Box chartPanel;
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
			radio = new  JRadioButton("30期",true);
		}
		return radio;
	}
	public JRadioButton getCheckBox0(){
		if(radio0 == null){
			radio0 = new  JRadioButton("50期",true);
			radio0.setSelected(true);
		}
		return radio0;
	}
	public JRadioButton getCheckBox1(){
		if(radio1 == null){
			radio1 = new  JRadioButton("100期",true);
			radio1.setSelected(true);
		}
		return radio1;
	}
	public JEditorPane getTextArea(){
		if(msgText == null){
			msgText = new JEditorPane();
		}
		return msgText;
	}
	public CaipiaoChartUI(){
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
//		add(btnPanel,"North");
		JSplitPane centerPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JPanel userPanel = new JPanel();
		JLabel label = new JLabel("周期:");
		userPanel.add(label);
//		comboxBox = new JComboBox();
//		userPanel.add(comboxBox);
		ButtonGroup group = new ButtonGroup();
		userPanel.add(getCheckBox());
		group.add(getCheckBox());
		userPanel.add(getCheckBox0());
		group.add(getCheckBox0());
		getCheckBox0().setSelected(true);
		userPanel.add(getCheckBox1());
		group.add(getCheckBox1());
		centerPanel.setLeftComponent(userPanel);
		chartPanel= Box.createVerticalBox();
//		msgPanel.setViewportView();
		centerPanel.setRightComponent(chartPanel);
		add(centerPanel,"Center");
		getGenBtn().addActionListener(this);
		getCheckBox().addActionListener(this);
		getCheckBox0().addActionListener(this);
		getCheckBox1().addActionListener(this);
		getClearBtn().addActionListener(this);
		initComboBox();
		initChart(30);
	}
	

	private void initComboBox(){
//		List<CaipiaoVo>  list = CaipiaoListUI.getAllList();
//		int size = 30;
//		if(getCheckBox0().isSelected()){
//			size = 50;
//		}else if(getCheckBox1().isSelected()){
//			size = 100;
//		}
//		list = CaipiaoListUI.fillList(list, size);
//		for(int i = 0; i<list.size();i++){
//			CaipiaoVo vo = list.get(i);
//			comboxBox.addItem(vo.getCaipiaoNo());
//		}
	}
	
	private void initChart(int size){
		chartPanel.removeAll();
		List<CaipiaoVo>  list = CaipiaoListUI.getAllList();
		List<CaipiaoChartVo>  primeList = new ArrayList<CaipiaoChartVo>();
		List<CaipiaoChartVo>  xiaoshuList = new ArrayList<CaipiaoChartVo>();
		List<CaipiaoChartVo>  jishuList = new ArrayList<CaipiaoChartVo>();
		List<CaipiaoChartVo>  sumList = new ArrayList<CaipiaoChartVo>();
		for(int i =list.size()-1;i>=0;i--){
			CaipiaoVo vo  = list.get(i);
			int primeNo =0;
			int xiaoShuNo =0;
			int jishuNo =0;
			int sum =0;
			String[] redNos = vo.getRedNo();
			for(String no :redNos){
				sum+=Integer.valueOf(no);
				if(BallLabel.isPrime(no)){
					primeNo++;
				}
				if(BallLabel.isJishu(no)){
					jishuNo++;
				}
				if(BallLabel.isXiaoshu(no)){
					xiaoShuNo++;
				}
			}
			CaipiaoChartVo chartVo = new CaipiaoChartVo();
			chartVo.setPeriodNo(vo.getCaipiaoNo().substring(4));
			chartVo.setValue(primeNo);
			primeList.add(chartVo);
			CaipiaoChartVo chartVo1 = new CaipiaoChartVo();
			chartVo1.setPeriodNo(vo.getCaipiaoNo().substring(4));
			chartVo1.setValue(xiaoShuNo);
			xiaoshuList.add(chartVo1);
			CaipiaoChartVo chartVo2 = new CaipiaoChartVo();
			chartVo2.setPeriodNo(vo.getCaipiaoNo().substring(4));
			chartVo2.setValue(jishuNo);
			jishuList.add(chartVo2);
			CaipiaoChartVo chartVo3 = new CaipiaoChartVo();
			chartVo3.setPeriodNo(vo.getCaipiaoNo().substring(4));
			chartVo3.setValue(sum);
			sumList.add(chartVo3);
		}
		LineChartGen primeGen = new LineChartGen(primeList,"质数走势图","个数","质数");
		JFreeChart primChart = primeGen.createChart(size);
		ChartPanel primPanel = new ChartPanel(primChart);
		chartPanel.add(primPanel);
		LineChartGen xiaoshuGen = new LineChartGen(xiaoshuList,"小区走势图","个数","小区");
		JFreeChart xiaoshuChart = xiaoshuGen.createChart(size);
		ChartPanel xiaoshuPanel = new ChartPanel(xiaoshuChart, true);
		chartPanel.add(xiaoshuPanel);
		LineChartGen jishuGen = new LineChartGen(jishuList,"奇数走势图","个数","奇数");
		JFreeChart jishuChart = jishuGen.createChart(size);
		ChartPanel jishuPanel = new ChartPanel(jishuChart, true);
		chartPanel.add(jishuPanel);
		LineChartGen sumGen = new LineChartGen(sumList,"和值走势图","个数","和值");
		JFreeChart sumChart = sumGen.createChart(size);
		ChartPanel sumPanel = new ChartPanel(sumChart, true);
		chartPanel.add(sumPanel);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == getCheckBox()){
			initChart(30);
			chartPanel.updateUI();
			this.updateUI();
		}else if(e.getSource() == getCheckBox0()){
			initChart(50);
		}else if(e.getSource() == getCheckBox1()){
			initChart(100);
		}
	}
	
	
	
	
}
