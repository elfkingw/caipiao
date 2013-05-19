package com.richie.caipiao.ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.richie.caipiao.vo.CaipiaoVo;

public class CaipiaoModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CaipiaoVo> caipiaoList;
	private String[] title_name = { "开奖日期", "期号", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
			"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
			"29", "30", "31", "32", "33", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "10", "11", "12", "13", "14", "15", "16" };

	
	public CaipiaoModel(List<CaipiaoVo> list) {
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
			value = vo.getRedNo(columnIndex - 1);
		} else if (columnIndex >= 35 ) {
			if(Integer.valueOf(vo.getBlue_no()).intValue() == (columnIndex-34))
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

}
