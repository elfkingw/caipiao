package com.richie.caipiao.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import com.richie.caipiao.vo.CaipiaoVo;

public class Caipiao3Model extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CaipiaoVo> caipiaoList;
	private String[] title_name = { "开奖日期", "期号", "3", "6", "9", "12", "15", "18",
			"21", "24", "27", "30", "33", "1", "4", "7", "10", "13", "16", "19",
			"22", "25", "28", "31", "2", "5", "8", "11", "14", "17", "20",
			"23", "26", "29", "32",  "蓝球" };

	
	public Caipiao3Model(List<CaipiaoVo> list) {
		caipiaoList = list;
	}
	
	@SuppressWarnings("unchecked")
	public Class getColumnClass(int column) {
		return String.class;
	}

	public int getColumnCount() {
		return title_name.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String value = null;
		if (caipiaoList == null || caipiaoList.size() == 0) {
			return "";
		}
		CaipiaoVo vo = caipiaoList.get(caipiaoList.size() - 1 - rowIndex);
		if (columnIndex == 0) {
			value = vo.getDate();
		} else if (columnIndex == 1) {
			value = vo.getCaipiaoNo();
		} else if (columnIndex > 1 && columnIndex < 35) {
			int t=  Integer.valueOf(title_name[columnIndex]).intValue();
			value = vo.getRedNo(t);
		} else if (columnIndex > 1 && columnIndex == 35) {
			value = vo.getBlue_no();
		}else{
			value ="";
		}
		return value;
	}

	public String getColumnName(int col) {
		return title_name[col];
	}

	public int getRowCount() {
		if (caipiaoList == null)	
			return 0;
		else
			return caipiaoList.size();
	}
	 public boolean isCellEditable(int row, int column) {
	        return false;
	    }
}
