/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visdias;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author USER
 */
public class Date {
    public int day;
    public int month;
    public int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Date other = (Date) obj;
        if (this.day != other.day) {
            return false;
        }
        if (this.month != other.month) {
            return false;
        }
        return this.year == other.year;
    }
    
    public int compareTo(Date d){
        if(this.year == d.year)
            if(this.month == d.month)
                if(this.day == d.day)
                    return 0;
                else if(this.day > d.day)
                    return 1;
                else
                    return -1;
            else if(this.month > d.month)
                return 1;
            else
                return -1;
        else if(this.year > d.year)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("0000/00/00");
        String tmp = String.valueOf(year);
        out.replace(4-tmp.length(), 4, tmp);
        tmp = String.valueOf(month);
        out.replace(7-tmp.length(), 7, tmp);
        tmp = String.valueOf(day);
        out.replace(10-tmp.length(), 10, tmp);
        return out.toString();
    }
    
    public String toStringFr() {
        StringBuilder out = new StringBuilder("00/00/0000");
        String tmp = String.valueOf(day);
        out.replace(2-tmp.length(), 2, tmp);
        tmp = String.valueOf(month);
        out.replace(5-tmp.length(), 5, tmp);
        tmp = String.valueOf(year);
        out.replace(10-tmp.length(), 10, tmp);
        return out.toString();
    }
    
    public static Date toDate(String date){
        String[] decompo = date.split("/");
        return new Date(Integer.parseInt(decompo[2]),
                        Integer.parseInt(decompo[1]),
                        Integer.parseInt(decompo[0]));
    }
    
    public static Date getTodayDate(){
        Date tmpDate;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        String ch = dtf.format(now);
        tmpDate = new Date(Integer.parseInt(ch.substring(8, 10)),Integer.parseInt(ch.substring(5, 7)),Integer.parseInt(ch.substring(0, 4)));
        return tmpDate;
    }
}
