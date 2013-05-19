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
	 * 1��start ��һ��trueƬ�ε���ʼλ��end��ֹλ
	 * 2���ѵ�һ��trueƬ�ζ���false
	 * 3�������0�±���ʼ���Ե�һ��trueƬ��Ԫ��������һΪ�±��λ�ö���true
	 * 4���ѵ�һ��trueƬ��end��ֹλ��true
	 * 
	 * @param bs �����Ƿ���ʾ�ı�־λ
	 * @param m ���鳤��
	 * @return boolean �Ƿ����������
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
	 * ������ɵ���Ͻ��
	 * 
	 * @param array ����
	 * @param bs ����Ԫ���Ƿ���ʾ�ı�־λ����
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