package org.jfree.test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;


public class LineChartDemo1 extends ApplicationFrame {
	public LineChartDemo1(String paramString) {
		super(paramString);
		JPanel localJPanel = createDemoPanel();
		localJPanel.setPreferredSize(new Dimension(500, 270));
		setContentPane(localJPanel);
	}

	private static CategoryDataset createDataset() {
		DefaultCategoryDataset localDefaultCategoryDataset = new DefaultCategoryDataset();
		localDefaultCategoryDataset.addValue(0, "质数", "112");
		localDefaultCategoryDataset.addValue(2, "质数", "113");
		localDefaultCategoryDataset.addValue(2, "质数", "114");
		localDefaultCategoryDataset.addValue(3, "质数", "115");
		localDefaultCategoryDataset.addValue(3, "质数", "116");
		localDefaultCategoryDataset.addValue(5, "质数", "117");
		localDefaultCategoryDataset.addValue(2, "质数", "118");
		localDefaultCategoryDataset.addValue(3, "质数", "119");
		localDefaultCategoryDataset.addValue(2, "质数", "120");
		localDefaultCategoryDataset.addValue(2, "质数", "124");
		localDefaultCategoryDataset.addValue(3, "质数", "125");
		localDefaultCategoryDataset.addValue(3, "质数", "126");
		localDefaultCategoryDataset.addValue(3, "质数", "127");
		localDefaultCategoryDataset.addValue(2, "质数", "128");
		localDefaultCategoryDataset.addValue(3, "质数", "129");
		localDefaultCategoryDataset.addValue(2, "质数", "120");
		// localDefaultCategoryDataset.addValue(2.0D, "Series 2", "Category 1");
		// localDefaultCategoryDataset.addValue(4.0D, "Series 2", "Category 2");
		// localDefaultCategoryDataset.addValue(4.0D, "Series 2", "Category 3");
		// localDefaultCategoryDataset.addValue(5.0D, "Series 2", "Category 4");
		// localDefaultCategoryDataset.addValue(2.0D, "Series 2", "Category 5");
		// localDefaultCategoryDataset.addValue(1.0D, "Series 3", "Category 1");
		// localDefaultCategoryDataset.addValue(3.0D, "Series 3", "Category 2");
		// localDefaultCategoryDataset.addValue(5.0D, "Series 3", "Category 3");
		// localDefaultCategoryDataset.addValue(2.0D, "Series 3", "Category 4");
		// localDefaultCategoryDataset.addValue(0.0D, "Series 3", "Category 5");
		return localDefaultCategoryDataset;
	}

	private static JFreeChart createChart(CategoryDataset paramCategoryDataset) {
		// 创建主题样式
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		// 设置标题字体
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
		// 设置图例的字体
		standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 12));
		// 设置轴向的字体
		standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 12));
		// 应用主题样式
		ChartFactory.setChartTheme(standardChartTheme);
		JFreeChart localJFreeChart = ChartFactory.createLineChart("质数走势图",
				"期号", "个数", paramCategoryDataset, PlotOrientation.VERTICAL,
				true, true, false);
		CategoryPlot localCategoryPlot = (CategoryPlot) localJFreeChart
				.getPlot();
//		SymbolAxis localSymbolAxis = new SymbolAxis("个数", new String[] {
//				"0", "1", "2", "3", "4", "5", "6" });
//		localCategoryPlot.setRangeAxis(localSymbolAxis);
		ChartUtilities.applyCurrentTheme(localJFreeChart);
		LineAndShapeRenderer xyitem = (LineAndShapeRenderer) localCategoryPlot
		.getRenderer();
		CategoryPlot plot = (CategoryPlot) localJFreeChart.getPlot();
		//设置网格背景颜色
		plot.setBackgroundPaint(Color.white);
		//设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.black);
		//设置网格横线颜色
		plot.setRangeGridlinePaint(Color.black);
		//设置曲线图与xy轴的距离
		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 0D));
		//设置曲线是否显示数据点
		//设置曲线显示各数据点的值
		xyitem.setBaseItemLabelsVisible(true);   
		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
//		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setSeriesStroke(0, new BasicStroke(1.5F));
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
		xyitem.setSeriesShapesVisible(0, true);
		plot.setRenderer(xyitem);
		
		
//		LineAndShapeRenderer localLineAndShapeRenderer = (LineAndShapeRenderer) localCategoryPlot
//				.getRenderer();
//		//折点
//		localLineAndShapeRenderer.setSeriesShapesVisible(0, true);
//		//线条粗细
//		localLineAndShapeRenderer.setSeriesStroke(0, new BasicStroke(1.5F));
//		localLineAndShapeRenderer.setDrawOutlines(true);
//		localLineAndShapeRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
//		localLineAndShapeRenderer.setBaseItemLabelsVisible(true);
//		localJFreeChart.setAntiAlias(true);
		return localJFreeChart;
	}

	public static JPanel createDemoPanel() {
		JFreeChart localJFreeChart = createChart(createDataset());
		return new ChartPanel(localJFreeChart);
	}

	public static void main(String[] paramArrayOfString) {
		LineChartDemo1 localLineChartDemo8 = new LineChartDemo1(
				"JFreeChart: LineChartDemo8.java");
		localLineChartDemo8.pack();
		RefineryUtilities.centerFrameOnScreen(localLineChartDemo8);
		localLineChartDemo8.setVisible(true);
	}
	
}

/*
 * Location:
 * C:\Users\Administrator\Desktop\jfreechart-1.0.14\jfreechart-1.0.14\jfreechart-1.0.14-demo\
 * Qualified Name: demo.LineChartDemo8 JD-Core Version: 0.6.0
 */