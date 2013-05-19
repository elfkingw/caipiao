package com.richie.caipiao.vo;

import java.util.ArrayList;
import java.util.List;

public class Xh12RedVo {
	private String meiTiName;
	private List<String> red12Ball;
	private List<String> blue3Ball;
	public String getMeiTiName() {
		return meiTiName;
	}
	public void setMeiTiName(String meiTiName) {
		this.meiTiName = meiTiName;
	}
	public List<String> getRed12Ball() {
		return red12Ball;
	}
	public void setRed12Ball(List<String> red12Ball) {
		this.red12Ball = red12Ball;
	}
	public List<String> getBlue3Ball() {
		return blue3Ball;
	}
	public void setBlue3Ball(List<String> blue3Ball) {
		this.blue3Ball = blue3Ball;
	}

	public void addRad(String no){
		if(red12Ball == null){
			red12Ball = new ArrayList<String>();
		}
		red12Ball.add(no);
	}
	public void addBlue(String no){
		if(blue3Ball == null){
			blue3Ball = new ArrayList<String>();
		}
		blue3Ball.add(no);
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer("");
		sb.append(" 12∫Ï«Ú£∫") ;
		for(String no : red12Ball){
			sb.append(no+"  ");
		}
		sb.append("  3¿∂«Ú£∫") ;
		for(String no : blue3Ball){
			sb.append(no+"  ");
		}
		sb.append("√ΩÃÂ£∫"+getMeiTiName()) ;
		return sb.toString();
	}
}
