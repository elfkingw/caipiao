package org.jfree.test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

public class TestQuxian {
	public static void  main(String[] args){
		TimeSeries timeSeries = new TimeSeries("阒胯湝鏋渂log璁块棶閲忕粺璁?, Month.class);
		//镞堕棿镟茬嚎鏁版嵁板嗗悎
		TimeSeriesCollection lineDataset = new TimeSeriesCollection();
		//鏋勯€犳暟鎹泦鍚?
		timeSeries.add(new Month(1, 2007), 1);
		timeSeries.add(new Month(2, 2007), 2);
		timeSeries.add(new Month(3, 2007), 3);
		timeSeries.add(new Month(4, 2007),3);
		timeSeries.add(new Month(5, 2007), 4);
		timeSeries.add(new Month(6, 2007), 5);
		timeSeries.add(new Month(7, 2007), 3);
		timeSeries.add(new Month(8, 2007), 3);
		timeSeries.add(new Month(9, 2007), 3);
		timeSeries.add(new Month(10, 2007), 1);
		timeSeries.add(new Month(11, 2007), 2);
		timeSeries.add(new Month(12, 2007), 0);
		lineDataset.addSeries(timeSeries);
		JFreeChart chart = ChartFactory.createTimeSeriesChart("璁块棶閲忕粺璁℃椂闂寸嚎", "链堜唤", "璁块棶閲?, lineDataset, true, true, true);
		XYPlot plot = (XYPlot) chart.getPlot();
		//璁剧疆缃戞牸鑳屾櫙棰滆壊
		plot.setBackgroundPaint(Color.white);
		//璁剧疆缃戞牸绔栫嚎棰滆壊
		plot.setDomainGridlinePaint(Color.pink);
		//璁剧疆缃戞牸妯嚎棰滆壊
		plot.setRangeGridlinePaint(Color.BLACK);
		//璁剧疆镟茬嚎锲句笌xy杞寸殑璺濈
		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 10D));
		//璁剧疆镟茬嚎鏄惁鏄剧ず鏁版嵁镣?
//		xylineandshaperenderer.setBaseShapesVisible(true);
		//璁剧疆镟茬嚎鏄剧ず鍚勬暟鎹偣镄勫€?
		XYItemRenderer xyitem = plot.getRenderer();  
		//鎶樼偣
//		//绾挎浔绮楃粏
		
		xyitem.setSeriesStroke(0, new BasicStroke(2F));
		xyitem.setBaseItemLabelsVisible(true);   
		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
		plot.setRenderer(xyitem);
		//璁剧疆瀛愭爣棰?
		TextTitle subtitle = new TextTitle("2007骞村害", new Font("榛戜綋", Font.BOLD, 12));
		chart.addSubtitle(subtitle);
		//璁剧疆涓绘爣棰?
		chart.setAntiAlias(true);
	
		//鍒涘缓涓婚镙峰纺  
		   StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		   //璁剧疆镙囬瀛椾綋  
		   standardChartTheme.setExtraLargeFont(new Font("闅朵功",Font.BOLD,20));  
		   //璁剧疆锲句緥镄勫瓧浣? 
		   standardChartTheme.setRegularFont(new Font("瀹嬩功",Font.PLAIN,12));  
		   //璁剧疆杞村悜镄勫瓧浣? 
		   standardChartTheme.setLargeFont(new Font("瀹嬩功",Font.PLAIN,12));  
		   //搴旗敤涓婚镙峰纺  
		   ChartFactory.setChartTheme(standardChartTheme); 
		 
		
		JFrame f = new JFrame();
		f.setSize(300, 300);
		ChartPanel chartpanel = new ChartPanel(chart, true);
		f.add(chartpanel);
		f.setVisible(true);
	}
}
