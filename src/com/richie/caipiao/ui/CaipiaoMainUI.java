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
		setTitle("��Ʊ����");
		ImageIcon ico = new ImageIcon(System.getProperty("user.dir")+"\\img\\logo.jpg");
		setIconImage(ico.getImage());
		JMenuBar menuBar = new JMenuBar();
		JMenu mnXh = new JMenu("ѡ����");
		menuBar.add(mnXh);
		mnXuanhao = new JMenuItem("ѡ�ŷ���");
		mnXh.add(mnXuanhao);
		JMenu mnHelp = new JMenu("����");
		menuBar.add(mnHelp);
		miAbout = new JMenuItem("����"); 
		mnHelp.add(miAbout);
		miAbout.addActionListener(this);
		mnXuanhao.addActionListener(this);
		this.setJMenuBar(menuBar);
		tab = new JTabbedPane();
		tab.addTab("��Ʊ��ʷ��Ϣ", new CaipiaoListUI());
		tab.addTab("��Ʊ��3��Ϣ", new Caipiao3ListUI());
		tab.addTab("��Ʊ���ݷ���", new CaipiaoReportUI());
		tab.addTab("��Ʊͳ��ͼ��", new CaipiaoChartUI());
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
			JOptionPane.showMessageDialog(this, "eflkingw��Ȩ����\n ��Ʊ���������в���http://zhcw.com","��ʾ",JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getSource() == mnXuanhao){
			CaipiaoXhWin ui = new CaipiaoXhWin();
			ui.setVisible(true);
		}
	}
	
}
