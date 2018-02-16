/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf2demo;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Joshu
 */
@Named(value = "dayOfWeekBean")
@RequestScoped
public class DayOfWeekBean {

    private int year = 1;
    private int month = 1;
    private int[] daysOfmonth;
    private int dayOfmonth = 1;
    private String dayOfweek;
    private String futurePast;
    private String[] monthMap;
    Map<String, Integer> months;
    private String weekDayOutput;

    /**
     * Creates a new instance of DayOfWeekBean
     */
    public DayOfWeekBean() {
        this.months = new HashMap<>();
        months.put("January", 1);
        months.put("February", 2);
        months.put("March", 3);
        months.put("April", 4);
        months.put("May", 5);
        months.put("June", 6);
        months.put("July", 7);
        months.put("August", 8);
        months.put("September", 9);
        months.put("October", 10);
        months.put("November", 11);
        months.put("December", 12);
        this.monthMap = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        daysOfmonth = new int[31];
        for (int i = 1; i <= 31; i++) {
            daysOfmonth[i - 1] = i;
        }
    }

    //public static void main(String[] args) {
    //Scanner input = new Scanner(System.in);
    // Prompt the user to enter a year, month, and day of the month.
    //System.out.print("Enter year: (e.g., 2012): ");
    //int year = input.nextInt();
    //System.out.print("Enter month: 1-12: ");
    //int month = input.nextInt();
    //System.out.print("Enter the day of the month: 1-31: ");
    //int dayOfMonth = input.nextInt();
    // Convert January and February to months 13 and 14 of the previous year
    // Calculate day of the week
    // int 
    // Display reslut
    //  System.out.print ("Day of the week is ");
//}
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int[] getDaysOfmonth() {
        return daysOfmonth;
    }

    public void setDaysOfmonth(int[] daysOfmonth) {
        this.daysOfmonth = daysOfmonth;
    }

    public int getDayOfmonth() {
        return dayOfmonth;
    }

    public void setDayOfmonth(int dayOfmonth) {
        this.dayOfmonth = dayOfmonth;
    }

    public void setDayOfweek(String dayOfweek) {

    }

    public String getDayOfweek() {
        return dayOfweek;
    }

    public void calculate() {
        int thisyear = year;
        if (month == 1 || month == 2) {
            month = (month == 1) ? 13 : 14;
            thisyear--;
        }

        int dayOfWeek = (dayOfmonth + (26 * (month + 1)) / 10 + (thisyear % 100)
                + (thisyear % 100) / 4 + (thisyear / 100) / 4 + 5 * (thisyear / 100)) % 7;

        switch (dayOfWeek) {
            case 0:
                this.dayOfweek = "Saturday";
                break;
            case 1:
                this.dayOfweek = "Sunday";
                break;
            case 2:
                this.dayOfweek = "Monday";
                break;
            case 3:
                this.dayOfweek = "Tuesday";
                break;
            case 4:
                this.dayOfweek = "Wednesday";
                break;
            case 5:
                this.dayOfweek = "Thursday";
                break;
            case 6:
                this.dayOfweek = "Friday";
                break;
        }

        //this.dayOfweek = dayOfweek;
    }

    public String getFuturePast() {
        LocalDate currentTime = LocalDate.now();
        int thismonth = month;
                if (month == 13 || month == 14) {
            thismonth = (month == 1) ? 1 : 2;
           
        }
        
        LocalDate date = LocalDate.of(year, thismonth, dayOfmonth);

        if (currentTime.compareTo(date) > 0) {

            return "Past";

        } else if (currentTime.compareTo(date) < 0) {

            return "Future";

        } else if (currentTime.compareTo(date) == 0) {

            return "Now";

        } else {

            return "not";

        }

    }

    public void setFuturePast(String futurePast) {

        this.futurePast = futurePast;
    }

    public String[] getMonthMap() {
        return monthMap;
    }

    public void setMonthMap(String[] monthMap) {
        this.monthMap = monthMap;
    }

    public Map< String, Integer> getMonths() {
        return months;
    }

    public void setMonths(Map<String, Integer> months) {
        this.months = months;
    }

}
