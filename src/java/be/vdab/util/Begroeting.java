/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package be.vdab.util;

/**
 *
 * @author pieter.mels
 */
import java.util.Calendar;
public class Begroeting {
    private final String boodschap;
    public Begroeting() {
        Calendar calendar = Calendar.getInstance();
        int uur = calendar.get(Calendar.HOUR_OF_DAY);
        if (uur >= 6 && uur < 12) {
            boodschap = "Goede morgen";
        } else if (uur < 18) {
            boodschap = "Goede middag";
        } else {
            boodschap = "Goede avond";
        }
    }
    
    @Override
    public String toString() {
        return boodschap;
    }
}
