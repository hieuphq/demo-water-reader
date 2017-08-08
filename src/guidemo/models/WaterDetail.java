/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidemo.models;

import java.util.Date;

public class WaterDetail {
    Date date; // B
    float tciIn; // C
    float tciOut; // D
    float temperature; // E
    float nh3; // F
    float no2; // G
    float dosed; // O - 0.5 or empty
    
    public WaterDetail(Date date,
            float tciIn,
            float tciOut,
            float temperature,
            float nh3,
            float no2,
            float dosed) {
        this.date = date;
        this.tciIn = tciIn;
        this.tciOut = tciOut;
        this.temperature = temperature;
        this.nh3 = nh3;
        this.no2 = no2;
        this.dosed = dosed;
    }

    @Override
    public String toString() {
        return String.format("WaterDetail (%s, %.2f, %.2f, %.2f, %.2f, %.2f, %.2f)", date,
                tciIn, tciOut, temperature, nh3, no2, dosed);
    }
    
    
}
