package com.richie.caipiao.ui.ball;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BallLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String TYPE_JISHU ="1";
	public static final String TYPE_XIAOQUSHU ="2";
	public static final String TYPE_PRIME ="3";
	public BallLabel(String no) {
		this.isSelected = false;
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("images/gray_"+no+".png"));//创建图片对象
		this.setIcon(img);
		this.ballNo = no;
	}

	public BallLabel(String no, boolean isSelect) {
		this.isSelected = isSelect;
		if(isSelect){
			ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("images/red_"+no+".png"));//创建图片对象
			this.setIcon(img);
		}else{
			ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("images/gray_"+no+".png"));//创建图片对象
			this.setIcon(img);
		}
	}

	private String ballNo;
	private boolean isSelected;
	private boolean isSpecial;

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
		if(isSelected){
			ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("images/red_"+this.getBallNo()+".png"));//创建图片对象
			this.setIcon(img);
		}else{
			ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("images/gray_"+this.getBallNo()+".png"));//创建图片对象
			this.setIcon(img);
		}
		isSpecial = false;
	}
	public void onClick(){
		if(!isSelected){
			ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("images/red_"+this.getBallNo()+".png"));//创建图片对象
			this.setIcon(img);
			isSelected = true;
		}else{
			ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("images/gray_"+this.getBallNo()+".png"));//创建图片对象
			this.setIcon(img);
			isSelected = false;
		}
		isSpecial = false;
	}
	public void ondbClick(){
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("images/violet_"+this.getBallNo()+".png"));//创建图片对象
		this.setIcon(img);
		isSelected = true;
		isSpecial = true;
	}

	public String getBallNo() {
		return ballNo;
	}

	public void setBallNo(String ballNo) {
		this.ballNo = ballNo;
	}

	public boolean isSpecial() {
		return isSpecial;
	}

	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	public static boolean isJishu(String bNo){
		int no = Integer.valueOf(bNo).intValue();
		if(no%2 ==0){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean isXiaoshu(String bNo){
		int no = Integer.valueOf(bNo).intValue();
		if(no>16){
			return false;
		}else{
			return true;
		}
	}
	public static boolean isPrime(String bNo){
		int no = Integer.valueOf(bNo).intValue();
		for(int i =2;i<33;i++){
			if(no != i){
				if(no%i==0){
					return false;
				}
			}
		}
		return true;
	}
	
	public  static void main(String[] args){
		System.out.print(isPrime("29"));
	}
}
