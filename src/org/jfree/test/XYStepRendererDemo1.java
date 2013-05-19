package org.jfree.test;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYStepRendererDemo1 extends ApplicationFrame
{
  public XYStepRendererDemo1(String paramString)
  {
    super(paramString);
    JPanel localJPanel = createDemoPanel();
    localJPanel.setPreferredSize(new Dimension(500, 300));
    setContentPane(localJPanel);
  }

  private static JFreeChart createChart(XYDataset paramXYDataset)
  {
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
    JFreeChart localJFreeChart = ChartFactory.createXYLineChart("质数走势图", "期号", "个数", paramXYDataset, PlotOrientation.VERTICAL, true, true, false);
    XYPlot localXYPlot = (XYPlot)localJFreeChart.getPlot();
    localXYPlot.setDomainPannable(true);
    localXYPlot.setRangePannable(true);
    XYStepRenderer localXYStepRenderer = new XYStepRenderer();
    localXYStepRenderer.setBaseShapesVisible(true);
    localXYStepRenderer.setSeriesStroke(0, new BasicStroke(2.0F));
    localXYStepRenderer.setSeriesStroke(1, new BasicStroke(2.0F));
    localXYStepRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
    localXYStepRenderer.setDefaultEntityRadius(6);
    localXYPlot.setRenderer(localXYStepRenderer);
    return localJFreeChart;
  }

  private static XYDataset createDataset()
  {
    XYSeries localXYSeries2 = new XYSeries("质数");
    localXYSeries2.add(112D, 1D);
    localXYSeries2.add(113D, 3D);
    localXYSeries2.add(114D, 2D);
    localXYSeries2.add(115D, 4D);
    localXYSeries2.add(116D, 3D);
    XYSeriesCollection localXYSeriesCollection = new XYSeriesCollection();
    localXYSeriesCollection.addSeries(localXYSeries2);
    return localXYSeriesCollection;
  }

  public static JPanel createDemoPanel()
  {
    JFreeChart localJFreeChart = createChart(createDataset());
    ChartPanel localChartPanel = new ChartPanel(localJFreeChart);
    localChartPanel.setMouseWheelEnabled(true);
    return localChartPanel;
  }

  public static void main(String[] paramArrayOfString)
  {
    XYStepRendererDemo1 localXYStepRendererDemo1 = new XYStepRendererDemo1("JFreeChart: XYStepRendererDemo1.java");
    localXYStepRendererDemo1.pack();
    RefineryUtilities.centerFrameOnScreen(localXYStepRendererDemo1);
    localXYStepRendererDemo1.setVisible(true);
  }
}