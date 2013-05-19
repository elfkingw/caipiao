package com.richie.caipiao.vo;

import java.util.Comparator;

public class ShaHComparator  implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		ReportVo vo0 = (ReportVo) o1;
		ReportVo vo1 = (ReportVo) o2;

		if (vo0.getTimes()>vo1.getTimes()) {
			return -1;
		} else {
			return 1;
		}
	}
}
