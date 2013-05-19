package com.richie.caipiao.ui.chart;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

public class LineChartGen  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CaipiaoChartVo> list;
	private String yTitle;
	private String title;
	private String type;
	public LineChartGen(List<CaipiaoChartVo> dataList,String title1,String yTitle1,String type1){
		list = dataList;
		yTitle = yTitle1;
		title =title1;
		type = type1;
	}
	public LineChartGen(){
		super();
	}
	
	private  CategoryDataset createDataset(int size) {
		DefaultCategoryDataset localDefaultCategoryDataset = new DefaultCategoryDataset();
		if(list == null){
			return null;
		}
		if(size>list.size()){
			size = 0;
		}
		for(int i = list.size()-size;i<list.size();i++){
			CaipiaoChartVo vo = list.get(i);
			localDefaultCategoryDataset.addValue(vo.getValue(), type, vo.getPeriodNo());
		}
		return localDefaultCategoryDataset;
	}
	
	public  JFreeChart createChart(int size) {
		CategoryDataset paramCategoryDataset = createDataset(size);
		// ����������ʽ
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		// ���ñ�������
		standardChartTheme.setExtraLargeFont(new Font("����", Font.BOLD, 20));
		// ����ͼ��������
		standardChartTheme.setRegularFont(new Font("����", Font.PLAIN, 12));
		// �������������
		standardChartTheme.setLargeFont(new Font("����", Font.PLAIN, 12));
		// Ӧ��������ʽ
		ChartFactory.setChartTheme(standardChartTheme);
		JFreeChart localJFreeChart = ChartFactory.createLineChart(title,
				"�ں�", yTitle, paramCategoryDataset, PlotOrientation.VERTICAL,
				true, true, false);
		CategoryPlot localCategoryPlot = (CategoryPlot) localJFreeChart
				.getPlot();
//		SymbolAxis localSymbolAxis = new SymbolAxis("����", new String[] {
//				"0", "1", "2", "3", "4", "5", "6" });
//		localCategoryPlot.setRangeAxis(localSymbolAxis);
		ChartUtilities.applyCurrentTheme(localJFreeChart);
		LineAndShapeRenderer xyitem = (LineAndShapeRenderer) localCategoryPlot
		.getRenderer();
		CategoryPlot plot = (CategoryPlot) localJFreeChart.getPlot();
		//�������񱳾���ɫ
		plot.setBackgroundPaint(Color.white);
		//��������������ɫ
		plot.setDomainGridlinePaint(Color.black);
		//�������������ɫ
		plot.setRangeGridlinePaint(Color.black);
		//��������ͼ��xy��ľ���
		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 0D));

		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(true);
		if("��ֵ".equals(type)){
			rangeAxis.setLowerBound(70);
			rangeAxis.setTickUnit(new   NumberTickUnit(10));
		}else{
			rangeAxis.setLowerBound(0);
			rangeAxis.setTickUnit(new   NumberTickUnit(1));
		}
//		rangeAxis.setUpperMargin(0.20);
		//����������ʾ�����ݵ��ֵ
		xyitem.setBaseItemLabelsVisible(true);   
		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		xyitem.setSeriesStroke(0, new BasicStroke(1.5F));
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));
		xyitem.setSeriesShapesVisible(0, true);
		plot.setRenderer(xyitem);
		return localJFreeChart;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<CaipiaoChartVo> getList() {
		return list;
	}
	public void setList(List<CaipiaoChartVo> list) {
		this.list = list;
	}
	public String getYTitle() {
		return yTitle;
	}
	public void setYTitle(String title) {
		yTitle = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public  static void main(String[] args){
		JFrame f = new JFrame();
		f.setLayout(new BorderLayout());
		f.setSize(300, 300);
		List<CaipiaoChartVo> list = new ArrayList<CaipiaoChartVo>();
		for(int i =0;i<100;i++){
			CaipiaoChartVo vo = new CaipiaoChartVo();
			vo.setPeriodNo((100+i)+"");
			double random = Math.random()*70;
			int a = (int) random +70;
			vo.setValue(a);
			list.add(vo);
		}
		LineChartGen panel = new LineChartGen(list,"��������ͼ","����","ָ��");
		JFreeChart chart = panel.createChart(30);
		ChartPanel chartpanel = new ChartPanel(chart, true);
		f.add(chartpanel,"Center");
		f.setVisible(true);
	}
	
}
