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
		TimeSeries timeSeries = new TimeSeries("阿蜜果blog访问量统计", Month.class);
		//时间曲线数据集合
		TimeSeriesCollection lineDataset = new TimeSeriesCollection();
		//构造数据集合
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
		JFreeChart chart = ChartFactory.createTimeSeriesChart("访问量统计时间线", "月份", "访问量", lineDataset, true, true, true);
		XYPlot plot = (XYPlot) chart.getPlot();
		//设置网格背景颜色
		plot.setBackgroundPaint(Color.white);
		//设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.pink);
		//设置网格横线颜色
		plot.setRangeGridlinePaint(Color.BLACK);
		//设置曲线图与xy轴的距离
		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 10D));
		//设置曲线是否显示数据点
//		xylineandshaperenderer.setBaseShapesVisible(true);
		//设置曲线显示各数据点的值
		XYItemRenderer xyitem = plot.getRenderer();  
		//折点
//		//线条粗细
		
		xyitem.setSeriesStroke(0, new BasicStroke(2F));
		xyitem.setBaseItemLabelsVisible(true);   
		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
		plot.setRenderer(xyitem);
		//设置子标题
		TextTitle subtitle = new TextTitle("2007年度", new Font("黑体", Font.BOLD, 12));
		chart.addSubtitle(subtitle);
		//设置主标题
		chart.setAntiAlias(true);
	
		//创建主题样式  
		   StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
		   //设置标题字体  
		   standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
		   //设置图例的字体  
		   standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,12));  
		   //设置轴向的字体  
		   standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,12));  
		   //应用主题样式  
		   ChartFactory.setChartTheme(standardChartTheme); 
		 
		
		JFrame f = new JFrame();
		f.setSize(300, 300);
		ChartPanel chartpanel = new ChartPanel(chart, true);
		f.add(chartpanel);
		f.setVisible(true);
	}
}
