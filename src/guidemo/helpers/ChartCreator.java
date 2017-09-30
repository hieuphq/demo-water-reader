/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidemo.helpers;

import guidemo.models.PredictingWaterDetail;
import guidemo.models.ReticEntry;
import guidemo.models.WaterDetail;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.data.time.Day;
import org.jfree.data.time.Minute;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.Styler;

/**
 *
 * @author hieuphan
 */
public class ChartCreator {
    static public JPanel generateNitrificationPotentialChart(WaterDetail[] data) {
        
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        
        TimeSeries no2Series = new TimeSeries("NO2", Day.class);
        TimeSeries tclSeries = new TimeSeries("TCl-BRC", Day.class);
        TimeSeries tabletSeries = new TimeSeries("Tablet", Day.class);
        
        for (WaterDetail dt : data) {
            no2Series.addOrUpdate(new Day(dt.date), dt.no2);
            tclSeries.addOrUpdate(new Day(dt.date), dt.tclBRC);
            
            double tablet = 0;
            
            if (dt.dosed == true) {
                tablet = 0.5;
            }else {
                tablet = 0;
            }
            tabletSeries.addOrUpdate(new Day(dt.date), tablet);
        }
        
        dataset.addSeries(no2Series);
        dataset.addSeries(tclSeries);
        dataset.addSeries(tabletSeries);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Nitrification Potential within the reservoir", "Date", "Nitrification Potential Indicator", dataset);
        XYPlot plot = (XYPlot) chart.getPlot();
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        
        return new ChartPanel(chart);
    }
    
    static public JPanel generateChloramineChart(WaterDetail[] data){
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        TimeSeries krtSeries = new TimeSeries("KRT 20");
        
        for (WaterDetail dt : data) {
            krtSeries.addOrUpdate(new Minute(dt.date), dt.krt20);
        }
        
        dataset.addSeries(krtSeries);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Chloramine decay behaviour", "Date", "Chloramine Stability", dataset);
        XYPlot plot = (XYPlot) chart.getPlot();
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        
        return new ChartPanel(chart);
    }
    static public JPanel generateForecastingChart(WaterDetail[] data){
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        TimeSeries tclSeries = new TimeSeries("TCL");
        TimeSeries tclBRCSeries = new TimeSeries("TCL BRC");
        
        int index = data.length - 1;
        
        if (index < 0) {
            return new JPanel();
        }
        
        PredictingWaterDetail[] predictingData = PredictingWaterDetail.calculateWaterDetail(data[index], 7);
        
        // Series
        for (PredictingWaterDetail dt : predictingData) {
            tclSeries.addOrUpdate(new Day(dt.date), dt.tcl);
            tclBRCSeries.addOrUpdate(new Day(dt.date), dt.tclBRC);
        }
        
        dataset.addSeries(tclBRCSeries);
        dataset.addSeries(tclSeries);
        
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Forecasting residual without interference", "Date", "Predicting Data", dataset);
        XYPlot plot = (XYPlot) chart.getPlot();
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        
        return new ChartPanel(chart);
    }
    static public JPanel generateReticChart(ReticEntry[] reticData){
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        TimeSeries NO2Series = new TimeSeries("NO2");
        TimeSeries nitrificationBRCSeries = new TimeSeries("Nitrification Potential Indicator");
        
        for (ReticEntry dt : reticData) {
            NO2Series.addOrUpdate(new Day(dt.date), dt.no2);
            nitrificationBRCSeries.addOrUpdate(new Day(dt.date), dt.nitrificationPotentialIndicator);
        }
                    
        dataset.addSeries(nitrificationBRCSeries);
        dataset.addSeries(NO2Series);
        
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Retic system behaviour", "Date", "Nitrification Potential Indicator", dataset);
        XYPlot plot = (XYPlot) chart.getPlot();
        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        
        return new ChartPanel(chart);
    }
    
    static public JPanel generateChloramineChartOldVer(WaterDetail[] data) {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800)
                .height(600).title("Chloramine decay behaviour")
                .yAxisTitle("Chloramine Stability").xAxisTitle("Date").build();

        // Customize Chart
        chart.getStyler().setDefaultSeriesRenderStyle(org.knowm.xchart.XYSeries.XYSeriesRenderStyle.Line);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);

        // Series
        List<Date> xData = new ArrayList<>();
        List<Double> yKrt20 = new ArrayList<>();

        for (WaterDetail dt : data) {
            xData.add(dt.date);
            yKrt20.add(dt.krt20);
        }

        chart.addSeries("KRT 20", xData, yKrt20);

        // Show it
        return new XChartPanel<>(chart);
    }
}
