package com.richie.caipiao.ui;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class CaipiaoMainUI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem miAbout;
	private JMenuItem mnXuanhao;
	private JTabbedPane tab;
	public CaipiaoMainUI(){
		super();
		initLize();
	}
	
	private void initLize(){
		setBounds(150,100,1120,650);
		setDefaultCloseOperation(3);
		setLayout(new BorderLayout());
		setTitle("彩票分析");
		ImageIcon ico = new ImageIcon(System.getProperty("user.dir")+"\\img\\logo.jpg");
		setIconImage(ico.getImage());
		JMenuBar menuBar = new JMenuBar();
		JMenu mnXh = new JMenu("选号器");
		menuBar.add(mnXh);
		mnXuanhao = new JMenuItem("选号分析");
		mnXh.add(mnXuanhao);
		JMenu mnHelp = new JMenu("帮助");
		menuBar.add(mnHelp);
		miAbout = new JMenuItem("关于"); 
		mnHelp.add(miAbout);
		miAbout.addActionListener(this);
		mnXuanhao.addActionListener(this);
		this.setJMenuBar(menuBar);
		tab = new JTabbedPane();
		tab.addTab("彩票历史信息", new CaipiaoListUI());
		tab.addTab("彩票余3信息", new Caipiao3ListUI());
		tab.addTab("彩票数据分析", new CaipiaoReportUI());
		tab.addTab("彩票统计图表", new CaipiaoChartUI());
		add(tab,"Center");
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			CaipiaoMainUI ui = new CaipiaoMainUI();
			ui.setVisible(true);
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == miAbout){
			JOptionPane.showMessageDialog(this, "eflkingw版权所有\n 彩票数据来自中彩网http://zhcw.com","提示",JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource() == mnXuanhao){
			CaipiaoXhWin ui = new CaipiaoXhWin();
			ui.setVisible(true);
		}
	}
	
}
