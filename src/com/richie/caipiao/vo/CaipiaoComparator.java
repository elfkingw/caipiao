package com.richie.caipiao.vo;

import java.util.Comparator;

public class CaipiaoComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		ReportVo vo0 = (ReportVo) o1;
		ReportVo vo1 = (ReportVo) o2;

		// 首先比较年龄，如果年龄相同，则比较名字
		if (vo0.getCaipiaoNo().compareTo(vo1.getCaipiaoNo())<0) {
			return -1;
		} else {
			return 1;
		}
	}
}
