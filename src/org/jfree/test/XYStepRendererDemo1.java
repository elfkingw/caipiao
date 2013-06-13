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
    JFreeChart localJFreeChart = ChartFactory.createXYLineChart("璐ㄦ暟璧板娍锲?, "链熷佛", "涓暟", paramXYDataset, PlotOrientation.VERTICAL, true, true, false);
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
    XYSeries localXYSeries2 = new XYSeries("璐ㄦ暟");
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