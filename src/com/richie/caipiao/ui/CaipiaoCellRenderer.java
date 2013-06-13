package com.richie.caipiao.ui;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.richie.caipiao.util.DateUtil;

public class CaipiaoCellRenderer extends DefaultTableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
			Component cell = super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);
			String date = (String) table.getModel().getValueAt(row, 0);
			try {
				
				int week = DateUtil.parseDate(date);
				if(week ==2){
					cell.setForeground(Color.blue);
				}else if(week == 4){
					cell.setForeground(Color.red);
				}else{
					cell.setForeground(Color.black);
				}
				if(column==12){
//					cell.setBackground(new Color(255,255,153));
					cell.setBackground(new Color(204,204,255));
				}else if(column==23){
					cell.setBackground(new Color(204,204,255));
				}else if(column==34){
					cell.setBackground(new Color(204,204,255));
				}else{
					cell.setBackground(Color.white);
				}
				if(isSelected){
					cell.setBackground(new Color(204,204,255));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		return cell;
	}
}