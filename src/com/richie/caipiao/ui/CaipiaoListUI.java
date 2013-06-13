package com.richie.caipiao.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.richie.caipiao.urlReader.CaipiaoUrlReader;
import com.richie.caipiao.vo.CaipiaoVo;

/**
 * 
 * @author Administrator
 *
 */
public class CaipiaoListUI extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String httpUrl ="http://kaijiang.zhcw.com/zhcw/inc/ssq/ssq_wqhg.jsp?pageNum=1";
	private JButton genBtn;
	private JButton clearBtn;
	private JRadioButton radio1;
	private JRadioButton radio2;
	private JRadioButton radio3;
	private  List<CaipiaoVo> datalist;
	public static List<CaipiaoVo> allList;
	
	public static  List<CaipiaoVo> getAllList(){
		if(allList == null || allList.size() ==0){
			CaipiaoUrlReader reader = new CaipiaoUrlReader();
			allList = reader.getList(httpUrl, null);
		}
		return allList;
	}
	private CaipiaoModel model;
	private JTable table;
	private JTable lastTable;

	public JButton getGenBtn() {
		if (genBtn == null) {
			genBtn = new JButton("查询");
		}
		return genBtn;
	}

	public JButton getClearBtn() {
		if (clearBtn == null) {
			clearBtn = new JButton("下载数据");
		}
		return clearBtn;
	}

	public JRadioButton getCheckBox1() {
		if (radio1 == null) {
			radio1 = new JRadioButton("50期", true);
			radio1.setSelected(true);
		}
		return radio1;
	}

	public JRadioButton getCheckBox2() {
		if (radio2 == null) {
			radio2 = new JRadioButton("100期", true);
			radio2.setSelected(true);
		}
		return radio2;
	}

	public JRadioButton getCheckBox3() {
		if (radio3 == null) {
			radio3 = new JRadioButton("150期", true);
			radio3.setSelected(true);
		}
		return radio3;
	}

	public CaipiaoListUI() {
		super();
		initLize();
	}
	 public void fitTableColumns(JTable myTable) {
			myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			JTableHeader header = myTable.getTableHeader();
			int rowCount = myTable.getRowCount();
			Enumeration columns = myTable.getColumnModel().getColumns();
			while (columns.hasMoreElements()) {
				TableColumn column = (TableColumn) columns.nextElement();
				int col = header.getColumnModel().getColumnIndex(
						column.getIdentifier());
				int width = (int) header.getDefaultRenderer()
						.getTableCellRendererComponent(myTable,
								column.getIdentifier(), false, false, -1, col)
						.getPreferredSize().getWidth();
				for (int row = 0; row < rowCount; row++) {
					int preferedWidth = (int) myTable.getCellRenderer(row, col)
							.getTableCellRendererComponent(myTable,
									myTable.getValueAt(row, col), false, false,
									row, col).getPreferredSize().getWidth();
					width = Math.max(width, preferedWidth);
				}
				header.setResizingColumn(column); // 此行很重要118
				if(col == 0){
					column.setWidth(78);
				}else if(col ==1){
					column.setWidth(60);
				}else if(col ==35){
					column.setWidth(35);
				}else{
					column.setWidth(25);
				}
			}
	 }
	 public void fitTableColumns1(JTable myTable) {
			myTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			JTableHeader header = myTable.getTableHeader();
			int rowCount = myTable.getRowCount();
			Enumeration columns = myTable.getColumnModel().getColumns();
			while (columns.hasMoreElements()) {
				TableColumn column = (TableColumn) columns.nextElement();
				int col = header.getColumnModel().getColumnIndex(
						column.getIdentifier());
				int width = (int) header.getDefaultRenderer()
						.getTableCellRendererComponent(myTable,
								column.getIdentifier(), false, false, -1, col)
						.getPreferredSize().getWidth();
				for (int row = 0; row < rowCount; row++) {
					int preferedWidth = (int) myTable.getCellRenderer(row, col)
							.getTableCellRendererComponent(myTable,
									myTable.getValueAt(row, col), false, false,
									row, col).getPreferredSize().getWidth();
					width = Math.max(width, preferedWidth);
				}
				header.setResizingColumn(column); // 此行很重要118
				if(col == 0){
					column.setWidth(79);
				}else if(col ==1){
					column.setWidth(60);
				}else if(col ==35){
					column.setWidth(35);
				}else{
					column.setWidth(25);
				}
			}
	 }
	
	private void initLize() {
		try{
			setBounds(200, 100, 900, 600);
			setLayout(new BorderLayout());
			JPanel btnPanel = new JPanel();
			btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
			btnPanel.add(getGenBtn());
			btnPanel.add(getClearBtn());
//			add(btnPanel, "North");
			JSplitPane centerPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
			JPanel userPanel = new JPanel();
			ButtonGroup group = new ButtonGroup();
			userPanel.add(getCheckBox1());
			group.add(getCheckBox1());
			getCheckBox1().addActionListener(this);
			userPanel.add(getCheckBox2());
			getCheckBox2().addActionListener(this);
			group.add(getCheckBox2());
			userPanel.add(getCheckBox3());
			getCheckBox3().addActionListener(this);
			group.add(getCheckBox3());
			centerPanel.setLeftComponent(userPanel);
			model = new CaipiaoModel(null);
			table = new JTable(model);
			table.setFont(new Font("213",1,15));
			table.setRowHeight(20);
			table.getColumnModel().getColumn(0).setPreferredWidth(200); 
			table.getTableHeader().setReorderingAllowed(false);
			JScrollPane s_pan = new JScrollPane(table);
			centerPanel.setRightComponent(s_pan);
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			panel.add(s_pan,"Center");
			lastTable =  new JTable(model);
			lastTable.setRowHeight(20);
			lastTable.setFont(new Font("213",1,15));
			lastTable.getColumnModel().getColumn(0).setPreferredWidth(200); 
			JViewport viewport = new JViewport(); 
			viewport.setView(lastTable); 
			viewport.setPreferredSize(new Dimension(1200,20));
			panel.add(viewport,"South");
			centerPanel.setRightComponent(panel);
			add(centerPanel, "Center");
			getGenBtn().addActionListener(this);
			getClearBtn().addActionListener(this);
			initData();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
   private void initData() {
	   try{
		   int size = 50;
		   if(getCheckBox1().isSelected()){
			   size = 50;
		   }else if(getCheckBox2().isSelected()){
			   size = 100;
		   }else if(getCheckBox3().isSelected()){
			   size = 150;
		   }
		   List<CaipiaoVo> list = CaipiaoListUI.getAllList();
		   datalist = fillList(list,list.get(0).getCaipiaoNo(),size);
		   CaipiaoModel lastModel = new CaipiaoModel(Caipiao3ListUI.getLastList(datalist));
		   lastTable.setModel(lastModel);
		   model = new CaipiaoModel(Caipiao3ListUI.getList(datalist));
		   table.setModel(model);
		   TableCellRenderer renderer= new CaipiaoCellRenderer();  
		   table.setDefaultRenderer(Class.forName("java.lang.String"),	renderer);
		   lastTable.setDefaultRenderer(Class.forName("java.lang.String"),	renderer);
		   table.updateUI();
		   fitTableColumns(table);
		   fitTableColumns1(lastTable);
	   }catch(Exception e){
		   e.printStackTrace();
	   }
   }
   public static List<CaipiaoVo> fillList( List<CaipiaoVo> list ,String caipiaoNo,int size){
	   List<CaipiaoVo> rList = new ArrayList<CaipiaoVo>();
	   boolean isStart = false;
	   int index =0;
	   for(int i=0;i<200;i++){
		   CaipiaoVo vo = list.get(i);
		   if(caipiaoNo.equals(vo.getCaipiaoNo())){
			   isStart = true;
		   }
		   index++;
		   if(index>size){
			break;   
		   }
		   if(isStart)
			   rList.add(vo);
	   }
	   return rList;
   }
   public static List<CaipiaoVo> fillList( List<CaipiaoVo> list ,int size){
	   List<CaipiaoVo> rList = new ArrayList<CaipiaoVo>();
	   for(int i=0;i<size;i++){
		   CaipiaoVo vo = list.get(i);
		   rList.add(vo);
	   }
	   return rList;
   }
	private void onGenRpt() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getGenBtn()) {
			onGenRpt();
		} else if (e.getSource() == getClearBtn()) {
		}else if (e.getSource() == getCheckBox1()) {
			initData();
		} else if (e.getSource() == getCheckBox2()) {
			initData();
		} else if (e.getSource() == getCheckBox3()) {
			initData();
		} else {
		}
	}



}
