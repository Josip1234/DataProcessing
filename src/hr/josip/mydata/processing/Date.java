package hr.josip.mydata.processing;

import java.util.HashMap;
import java.util.Map;

public class Date {
    private int day;
    private int month;
    private int year;
    private char charBetweenNumbers;
    public static boolean errors=false;
    public static Map<Integer,Integer> map;
    //keys going to map
    public String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
    //number of days of months in common year
    public int[] numberOfDaysCommon={31,28,31,30,31,30,31,31,30,31,30,31};
    //number of days of months in leap years
    public int[] numberOfDaysInLeap={31,29,31,30,31,30,31,31,30,31,30,31};

    /**
     * A year will be a leap year if it is divisible by 4 but not by 100. If a year is divisible by 4 and by 100,
     * it is not a leap year unless it is also divisible by 400.
     *
     * Thus years such as 1996, 1992, 1988 and so on are leap years because they are divisible by 4 but not by 100.
     * For century years, the 400 rule is important. Thus, century years 1900, 1800 and 1700 while all still divisible by 4
     * are also exactly divisible by 100. As they are not further divisible by 400, they are not leap years
     * @param year
     */
    public boolean calculateLeapYear(int year){
        boolean isLeap=false;
        if((year%400==0 || year%100!=0 )&&(year%4==0)){
            System.out.println("Leap year");
            isLeap=true;
        }else{
            isLeap=false;
            System.out.println("Not leap year");
        }
        return isLeap;
    }
    //add to map leap or not leap year depending of year
    public Map<String,Integer> addMonthsDays(int year){
        Map<String,Integer> map=new HashMap<String,Integer>();
        if(calculateLeapYear(year)==true){
            //add leap year in map
            for (int i=0;i<months.length;i++){
                map.put(months[i],numberOfDaysInLeap[i]);

            }
        }else{
            //add not leap year in map
            for (int i=0;i<months.length;i++){
                map.put(months[i],numberOfDaysCommon[i]);

            }
        }
        return map;
    }

    public boolean validateDayInput(int day){
        if(day<1 || day>31){
            errors=true;
            System.out.println("Date must be between 1 and 31");
        }else{
            errors=false;
        }
        return errors;
    }
    public boolean validateMonthInput(int month){
        if(month<1 || month>12){
            errors=true;
            System.out.println("Error!!! Month must be between 1 and 12!!!");
        }else{
            errors=false;
        }
        return errors;
    }
    public boolean validateYearInput(int year){
        if(year<1900){
            errors=true;
            System.out.println("Year must be greater than 1900");
        }else{
           errors=false;
        }
        return errors;
    }

    public Date(int day,int month,int year) {
        if(validateDayInput(day)==false) this.day=day;
        else System.out.println("Error!!! Wrong day entered!!!");
        if(validateMonthInput(month)==false)this.month=month;
        else System.out.println("Error!!! Wrong month entered!!!");
        if(validateYearInput(year)==false) this.year=year;
        else System.out.println("Error!!! Wrong year entered!!!");

        this.charBetweenNumbers='.';
    }

    public int getDay() {

        return day;
    }

    public void setDay(int day) {
            if(validateDayInput(day)==false) this.day=day;
            else System.out.println("Error!!! Wrong day entered!!!");


    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(validateMonthInput(month)==false)this.month=month;
        else System.out.println("Error!!! Wrong month entered!!!");
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(validateYearInput(year)==false) this.year=year;
        else System.out.println("Error!!! Wrong year entered!!!");
    }

    public char getCharBetweenNumbers() {
        return charBetweenNumbers;
    }

    public void setCharBetweenNumbers(char charBetweenNumbers) {
        this.charBetweenNumbers = charBetweenNumbers;
    }


    public String getDate() {
        return String.valueOf(getDay())+getCharBetweenNumbers()+String.valueOf(getMonth())+getCharBetweenNumbers()+String.valueOf(getYear());
    }
}
