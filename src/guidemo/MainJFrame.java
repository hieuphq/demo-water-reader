/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidemo;

import guidemo.helpers.XlsReader;
import guidemo.models.ReticEntry;
import guidemo.models.WaterDetail;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;

public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        this.currDirectoryPath = "";
        initComponents();
        initLogo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        filePathTextField = new javax.swing.JTextField();
        browserFileButton = new javax.swing.JButton();
        reticDataEntryTable = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableReticData = new javax.swing.JTable();
        jButtonAddReticData = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        nitrificationChart = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        chrloraminChart = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        forecastingChart = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        reticChart = new javax.swing.JPanel();
        jPanelLogo = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Read xls file");

        jLabel1.setText("File Path");
        jLabel1.setToolTipText("File path lead to xls file");

        filePathTextField.setEditable(false);
        filePathTextField.setToolTipText("");

        browserFileButton.setText("Browser");
        browserFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browserFileButtonActionPerformed(evt);
            }
        });

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "TCI_in", "TCLI_out", "Temp", "NH3-N", "NO2-N", "Tablet Dosed", "Selected"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dataTable);
        if (dataTable.getColumnModel().getColumnCount() > 0) {
            dataTable.getColumnModel().getColumn(0).setMinWidth(120);
        }

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1292, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAdd)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
        );

        reticDataEntryTable.addTab("Reservior Data Entry", jPanel1);

        jTableReticData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Total Chlorine", "Temperature", "NH3-N", "Nitrification Potential Indicator"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableReticData);

        jButtonAddReticData.setText("Add");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(1211, Short.MAX_VALUE)
                .addComponent(jButtonAddReticData)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonAddReticData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
        );

        reticDataEntryTable.addTab("Retic Data Entry", jPanel2);

        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        nitrificationChart.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nitrificationChart, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nitrificationChart, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.add(jPanel10);

        chrloraminChart.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chrloraminChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chrloraminChart, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.add(jPanel9);

        forecastingChart.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(forecastingChart, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(forecastingChart, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.add(jPanel8);

        reticChart.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reticChart, javax.swing.GroupLayout.DEFAULT_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reticChart, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.add(jPanel7);

        reticDataEntryTable.addTab("Diagrams", jPanel6);

        javax.swing.GroupLayout jPanelLogoLayout = new javax.swing.GroupLayout(jPanelLogo);
        jPanelLogo.setLayout(jPanelLogoLayout);
        jPanelLogoLayout.setHorizontalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
        );
        jPanelLogoLayout.setVerticalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(reticDataEntryTable)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(browserFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(filePathTextField))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(browserFileButton))
                    .addComponent(jPanelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reticDataEntryTable))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void initLogo() {
        String pathToImage = "resources/logo.jpg";
        
        ImageIcon logoIcon = new ImageIcon(getClass().getClassLoader().getResource(pathToImage));
        Image scaledIcon;
        scaledIcon = logoIcon.getImage().getScaledInstance(
                this.jLabelLogo.getWidth(),
                this.jLabelLogo.getHeight(),
                Image.SCALE_SMOOTH);
                
        this.jLabelLogo.setIcon(new ImageIcon(scaledIcon));
    }
    
    private void setDataToTable(WaterDetail[] data) {
        DefaultTableModel model = (DefaultTableModel) this.dataTable.getModel();

        if (model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(i);
            }
        }

        for (WaterDetail dt : data) {
            model.addRow(new Object[]{
                dt.getDateString(),
                dt.tciIn,
                dt.tciOut,
                dt.temperature,
                dt.nh3,
                dt.no2,
                dt.dosed,
                false
            });
        }
    }
    
    private void setDataToReticTable(ReticEntry[] data) {
        DefaultTableModel model = (DefaultTableModel) this.jTableReticData.getModel();

        if (model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(i);
            }
        }

        for (ReticEntry dt : data) {
            model.addRow(new Object[]{
                dt.getDateString(),
                dt.totalChlorine,
                dt.temperature,
                dt.nh3,
                dt.no2,
                dt.nitrificationPotentialIndicator
            });
        }
    }

    private void generateReticChart(WaterDetail[] data) {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800)
                .height(600).title("Retic system behaviour")
                .yAxisTitle("Nitrification Potential Indicator").xAxisTitle("Date").build();

        // Customize Chart
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Line);
        chart.getStyler().setLegendPosition(LegendPosition.InsideNW);

        // Series
        List<Date> xData = new ArrayList<>();
        List<Float> yNH3 = new ArrayList<>();
        List<Float> yNO2 = new ArrayList<>();

        for (WaterDetail dt : data) {
            xData.add(dt.date);
            yNH3.add(dt.nh3);
            yNO2.add(dt.no2);
        }

        chart.addSeries("NH3", xData, yNH3);
        chart.addSeries("NO2", xData, yNO2);

        // Show it
        JPanel chartView = new XChartPanel<XYChart>(chart);
        this.reticChart.removeAll();
        this.reticChart.add(chartView, BorderLayout.CENTER);
        this.reticChart.validate();
    }

    private void generateForecastingChart(WaterDetail[] data) {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800)
                .height(600).title("Forecasting residual without interference")
                .yAxisTitle("X").xAxisTitle("Date").build();

        // Customize Chart
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Line);
        chart.getStyler().setLegendPosition(LegendPosition.InsideNW);

        // Series
        List<Date> xData = new ArrayList<>();
        List<Double> ytciBRC = new ArrayList<>();

        for (WaterDetail dt : data) {
            xData.add(dt.date);
            ytciBRC.add(dt.tclBRC);
        }

        chart.addSeries("TCl-BRC", xData, ytciBRC);

        // Show it
        JPanel chartView = new XChartPanel<XYChart>(chart);
        this.forecastingChart.removeAll();
        this.forecastingChart.add(chartView, BorderLayout.CENTER);
        this.forecastingChart.validate();
    }

    private void generateChloramineChart(WaterDetail[] data) {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800)
                .height(600).title("Chloramine decay behaviour")
                .yAxisTitle("Chloramine Stability").xAxisTitle("Date").build();

        // Customize Chart
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Line);
        chart.getStyler().setLegendPosition(LegendPosition.InsideNW);

        // Series
        List<Date> xData = new ArrayList<>();
        List<Double> yKrt20 = new ArrayList<>();

        for (WaterDetail dt : data) {
            xData.add(dt.date);
            yKrt20.add(dt.krt20);
        }

        chart.addSeries("KRT 20", xData, yKrt20);

        // Show it
        JPanel chartView = new XChartPanel<XYChart>(chart);
        this.chrloraminChart.removeAll();
        this.chrloraminChart.add(chartView, BorderLayout.CENTER);
        this.chrloraminChart.validate();
    }

    private void generateNitrificationChart(WaterDetail[] data) {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800)
                .height(600).title("Nitrification Potential within the reservoir")
                .yAxisTitle("Nitrification Potential Indicator").xAxisTitle("Date").build();

        // Customize Chart
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Line);
        chart.getStyler().setLegendPosition(LegendPosition.InsideNW);

        // Series
        List<Date> xData = new ArrayList<>();
        List<Float> yNo2 = new ArrayList<>();
        List<Double> tcl = new ArrayList<>();
//        List<Float> tablet = new ArrayList<>();

        for (WaterDetail dt : data) {
            xData.add(dt.date);
            tcl.add(dt.tclBRC);
            //tablet.add(dt.dosed);
            yNo2.add(dt.no2);
        }

        chart.addSeries("NO2", xData, yNo2);
        chart.addSeries("TCl-BRC", xData, tcl);
//        XYSeries seriesTablet = chart.addSeries("Tablet", xData, tablet);
//        seriesTablet.setXYSeriesRenderStyle(XYSeriesRenderStyle.Scatter);

        // Show it
        JPanel chartView = new XChartPanel<>(chart);
        this.nitrificationChart.removeAll();
        this.nitrificationChart.add(chartView, BorderLayout.CENTER);
        this.nitrificationChart.validate();
    }

    private String currDirectoryPath;
    private String currFileName;
    private ArrayList<WaterDetail> detailArray = new ArrayList<>();
    private void browserFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browserFileButtonActionPerformed
        // TODO add your handling code here:

        JFileChooser fileChooser = new JFileChooser(currDirectoryPath);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "XLSX Files", "xlsx", "xls");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(MainJFrame.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            this.currDirectoryPath = file.getParent();
            this.filePathTextField.setText(file.getAbsolutePath());
            this.currFileName = file.getAbsolutePath();

            // Load file
            WaterDetail[] data = XlsReader.readWaterInfo(currFileName, 3, 0);
            ReticEntry[] reticData = XlsReader.readReticInfo(currFileName, 3, 0);

            setDataToTable(data);
            setDataToReticTable(reticData);
            generateNitrificationChart(data);
            generateChloramineChart(data);
            generateForecastingChart(data);
            generateReticChart(data);
            
            this.detailArray = new ArrayList<>(Arrays.asList(data));
        }
    }//GEN-LAST:event_browserFileButtonActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        
        if (this.detailArray.size() > 0) {
            WaterDetail newData = new WaterDetail(
                    new Date(), 0, 0, 0, 0, 0, ""
            );
            this.detailArray.add(newData);
            
            WaterDetail[] newArray = this.detailArray.toArray(new WaterDetail[this.detailArray.size()]);
            setDataToTable(newArray);
            
            this.dataTable.scrollRectToVisible(
                    this.dataTable.getCellRect(
                            this.dataTable.getRowCount() - 1, 0, true
                    )
            );
//            generateNitrificationChart(newArray);
//            generateChloramineChart(newArray);
//            generateForecastingChart(newArray);
//            generateReticChart(newArray);
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browserFileButton;
    private javax.swing.JPanel chrloraminChart;
    private javax.swing.JTable dataTable;
    private javax.swing.JTextField filePathTextField;
    private javax.swing.JPanel forecastingChart;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAddReticData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelLogo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableReticData;
    private javax.swing.JPanel nitrificationChart;
    private javax.swing.JPanel reticChart;
    private javax.swing.JTabbedPane reticDataEntryTable;
    // End of variables declaration//GEN-END:variables
}
