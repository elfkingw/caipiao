package org.jfree.test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

public class Test {
	public static void main(String[] args) {
		// row keys...
		String series1 = "First";
		String series2 = "Second";
		String series3 = "Third";

		// column keys...
		String type1 = "Type 1";
		String type2 = "Type 2";
		String type3 = "Type 3";
		String type4 = "Type 4";
		String type5 = "Type 5";
		String type6 = "Type 6";
		String type7 = "Type 7";
		String type8 = "Type 8";

		// create the dataset...
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(1.0, series1, type1);
		dataset.addValue(4.0, series1, type2);
		dataset.addValue(3.0, series1, type3);
		dataset.addValue(5.0, series1, type4);
		dataset.addValue(5.0, series1, type5);
		dataset.addValue(7.0, series1, type6);
		dataset.addValue(7.0, series1, type7);
		dataset.addValue(8.0, series1, type8);

		// dataset.addValue(5.0, series2, type1);
		// dataset.addValue(7.0, series2, type2);
		// dataset.addValue(6.0, series2, type3);
		// dataset.addValue(8.0, series2, type4);
		// dataset.addValue(4.0, series2, type5);
		// dataset.addValue(4.0, series2, type6);
		// dataset.addValue(2.0, series2, type7);
		// dataset.addValue(1.0, series2, type8);
		//
		// dataset.addValue(4.0, series3, type1);
		// dataset.addValue(3.0, series3, type2);
		// dataset.addValue(2.0, series3, type3);
		// dataset.addValue(3.0, series3, type4);
		// dataset.addValue(6.0, series3, type5);
		// dataset.addValue(3.0, series3, type6);
		// dataset.addValue(4.0, series3, type7);
		// dataset.addValue(3.0, series3, type8);

		// create the chart...
		JFreeChart chart = ChartFactory.createLineChart("血压水平分布图", // chart
				"Type", // domain axis label
				"Value", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, // tooltips
				false // urls
				);

		// NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
		// StandardLegend legend = (StandardLegend) chart.getLegend();
		// legend.setDisplaySeriesShapes(true);
		// legend.setShapeScaleX(1.5);
		// legend.setShapeScaleY(1.5);
		// legend.setDisplaySeriesShapeslaySeriesLines(true);
		CategoryPlot plot = chart.getCategoryPlot();
		// customise the range axis...
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(true);
		rangeAxis.setUpperMargin(0.20);
		rangeAxis.setLabelAngle(Math.PI / 2.0);
		LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot
				.getRenderer();

		renderer.setItemLabelsVisible(true);

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

		JFrame f = new JFrame();
		f.setSize(300, 300);
		ChartPanel chartpanel = new ChartPanel(chart, true);
		f.add(chartpanel);
		f.setVisible(true);
	}
}
