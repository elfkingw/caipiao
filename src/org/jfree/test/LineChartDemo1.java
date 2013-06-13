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
		localDefaultCategoryDataset.addValue(0, "璐ㄦ暟", "112");
		localDefaultCategoryDataset.addValue(2, "璐ㄦ暟", "113");
		localDefaultCategoryDataset.addValue(2, "璐ㄦ暟", "114");
		localDefaultCategoryDataset.addValue(3, "璐ㄦ暟", "115");
		localDefaultCategoryDataset.addValue(3, "璐ㄦ暟", "116");
		localDefaultCategoryDataset.addValue(5, "璐ㄦ暟", "117");
		localDefaultCategoryDataset.addValue(2, "璐ㄦ暟", "118");
		localDefaultCategoryDataset.addValue(3, "璐ㄦ暟", "119");
		localDefaultCategoryDataset.addValue(2, "璐ㄦ暟", "120");
		localDefaultCategoryDataset.addValue(2, "璐ㄦ暟", "124");
		localDefaultCategoryDataset.addValue(3, "璐ㄦ暟", "125");
		localDefaultCategoryDataset.addValue(3, "璐ㄦ暟", "126");
		localDefaultCategoryDataset.addValue(3, "璐ㄦ暟", "127");
		localDefaultCategoryDataset.addValue(2, "璐ㄦ暟", "128");
		localDefaultCategoryDataset.addValue(3, "璐ㄦ暟", "129");
		localDefaultCategoryDataset.addValue(2, "璐ㄦ暟", "120");
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
		// 鍒涘缓涓婚镙峰纺
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		// 璁剧疆镙囬瀛椾綋
		standardChartTheme.setExtraLargeFont(new Font("闅朵功", Font.BOLD, 20));
		// 璁剧疆锲句緥镄勫瓧浣?
		standardChartTheme.setRegularFont(new Font("瀹嬩功", Font.PLAIN, 12));
		// 璁剧疆杞村悜镄勫瓧浣?
		standardChartTheme.setLargeFont(new Font("瀹嬩功", Font.PLAIN, 12));
		// 搴旗敤涓婚镙峰纺
		ChartFactory.setChartTheme(standardChartTheme);
		JFreeChart localJFreeChart = ChartFactory.createLineChart("璐ㄦ暟璧板娍锲?,
				"链熷佛", "涓暟", paramCategoryDataset, PlotOrientation.VERTICAL,
				true, true, false);
		CategoryPlot localCategoryPlot = (CategoryPlot) localJFreeChart
				.getPlot();
//		SymbolAxis localSymbolAxis = new SymbolAxis("涓暟", new String[] {
//				"0", "1", "2", "3", "4", "5", "6" });
//		localCategoryPlot.setRangeAxis(localSymbolAxis);
		ChartUtilities.applyCurrentTheme(localJFreeChart);
		LineAndShapeRenderer xyitem = (LineAndShapeRenderer) localCategoryPlot
		.getRenderer();
		CategoryPlot plot = (CategoryPlot) localJFreeChart.getPlot();
		//璁剧疆缃戞牸鑳屾櫙棰滆壊
		plot.setBackgroundPaint(Color.white);
		//璁剧疆缃戞牸绔栫嚎棰滆壊
		plot.setDomainGridlinePaint(Color.black);
		//璁剧疆缃戞牸妯嚎棰滆壊
		plot.setRangeGridlinePaint(Color.black);
		//璁剧疆镟茬嚎锲句笌xy杞寸殑璺濈
		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 0D));
		//璁剧疆镟茬嚎鏄惁鏄剧ず鏁版嵁镣?
		//璁剧疆镟茬嚎鏄剧ず鍚勬暟鎹偣镄勫€?
		xyitem.setBaseItemLabelsVisible(true);   
		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
//		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setSeriesStroke(0, new BasicStroke(1.5F));
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
		xyitem.setSeriesShapesVisible(0, true);
		plot.setRenderer(xyitem);
		
		
//		LineAndShapeRenderer localLineAndShapeRenderer = (LineAndShapeRenderer) localCategoryPlot
//				.getRenderer();
//		//鎶樼偣
//		localLineAndShapeRenderer.setSeriesShapesVisible(0, true);
//		//绾挎浔绮楃粏
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