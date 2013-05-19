package com.richie.caipiao.combin;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

public class Combination {
	
	private ArrayList<String[]> combList= new ArrayList<String[]>();

	public void mn(List<String> array, int n) {
		int m = array.size();
		if (m < n)
			throw new IllegalArgumentException("Error   m   <   n");
		BitSet bs = new BitSet(m);
		for (int i = 0; i < n; i++) {
			bs.set(i, true);
		}
		do {
			printAll(array, bs);
		} while (moveNext(bs, m));

	}
	/**
	 * 1、start 第一个true片段的起始位，end截止位
	 * 2、把第一个true片段都置false
	 * 3、数组从0下标起始到以第一个true片段元素数量减一为下标的位置都置true
	 * 4、把第一个true片段end截止位置true
	 * 
	 * @param bs 数组是否显示的标志位
	 * @param m 数组长度
	 * @return boolean 是否还有其他组合
	 */
	private boolean moveNext(BitSet bs, int m) {
		int start = -1;
		while (start < m)
			if (bs.get(++start))
				break;
		if (start >= m)
			return false;

		int end = start;
		while (end < m)
			if (!bs.get(++end))
				break;
		if (end >= m)
			return false;
		for (int i = start; i < end; i++)
			bs.set(i, false);
		for (int i = 0; i < end - start - 1; i++)
			bs.set(i);
		bs.set(end);
		return true;
	}
	
	/**
	 * 输出生成的组合结果
	 * 
	 * @param array 数组
	 * @param bs 数组元素是否显示的标志位集合
	 */
	private void printAll(List<String> array, BitSet bs) {
		String[] res = null; 
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < array.size(); i++)
			if (bs.get(i)) {
				list.add(array.get(i));
			}
	
		if(list.size()>0){
			res = new String[list.size()];
			list.toArray(res);
			combList.add(res);
		}

	}
	
	public ArrayList<String[]> getCombList() {
		return combList;
	}
	
	public String[] com(String[] a,String[] b){
		int length = a.length+b.length;
		String[] res = new String[length];
		for(int i = 0;i<a.length;i++){
			res[i] =a[i];
		}
		for(int j = 0;j<b.length;j++){
			res[a.length+j] = b[j];
		}
		return res;
	}
	
	
	public static void main(String[] args) throws Exception {
		Combination comb = new Combination();
		String[] a = new String[]{"01","02","13","14","15","16","19","26"};
		List<String> list = new ArrayList<String>();
		for(int z =0;z<a.length;z++){
			list.add(a[z]);
		}
		comb.mn(list, 5);
		for (int i = 0; i < comb.getCombList().size(); i++) {
			String[] res = comb.getCombList().get(i);
			for(int j =0;j<res.length;j++){
				System.out.print(res[j]+" ");
			}
			System.out.println();
//			String[] list = comb.getCombList().get(i).split(",");
//			Arrange ts = new Arrange();
//			ts.perm(list, 0, list.length-1);
//			for (int j = 0; j < ts.getArrangeList().size(); j++) {
//				System.out.println(ts.getArrangeList().get(j));
//			}
		}
		System.out.println(comb.getCombList().size()+" ");
		
	}
	
}