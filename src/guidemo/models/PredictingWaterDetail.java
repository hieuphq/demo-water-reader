/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidemo.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author hieuphan
 */
public class PredictingWaterDetail {
    public Date date;
    public double tcl;
    public double umkd;
    public double brc;
    public double tclBRC;
    
    public PredictingWaterDetail(Date date,
            float tcl,
            float umkd,
            float brc,
            float tclBRC) {
        this.date = date;
        this.tcl = tcl;
        this.umkd = umkd;
        this.brc = brc;
        this.tclBRC = tclBRC;
    }
    
    public static PredictingWaterDetail[] calculateWaterDetail(WaterDetail detail, int numberOfDay) {
        ArrayList<PredictingWaterDetail> rs = new ArrayList<>();
        
        for (int i = 0; i < numberOfDay; i++) {
            int index = i + 1;
            float tcl = (float) (detail.tciIn / (1 + ((detail.tciIn - detail.tciOut) / detail.tciOut) * Math.exp(-6924 * (1/(273+(detail.temperature + 1 / 10 * index)) - 1/(273 + detail.temperature)))));
            float umkd = (float) (-0.0008 * Math.pow(detail.temperature + index / 10, 3) + 0.0419 * Math.pow(detail.temperature + index / 10, 2) - 0.6253 * (detail.temperature + index / 10) + 3.9132 + 0.23);
            float brc = (float) (umkd * ( detail.nh3 - tcl / 5) / ((detail.nh3 - tcl / 5) + 0.18));
            float tclBRC = tcl - brc;
            
            Date newDate = PredictingWaterDetail.addDays(detail.date, index);
            
            PredictingWaterDetail data = new PredictingWaterDetail(newDate, tcl, umkd, brc, tclBRC);
            rs.add(data);
        }
        
        return rs.toArray(new PredictingWaterDetail[rs.size()]);
    }
    
    static public Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
}