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
    //Validate date after input
    public boolean validateDate(int day,int month,int year){
        //get map of how many days have one month
        Map<String,Integer> map=addMonthsDays(year);
        //set the search key to find a month with days
        String key=findInField(month);
        //after key is found, search a map and get the value of days
        int daysInMonth=map.get(key);
        //if day is greather than days in that month
        //error
        if(day>daysInMonth){
            errors=true;
            System.out.println("Error!!! That number of day is greather then sum of numbers in that month!!!");
        }else{
            errors=false;
        }
        return errors;
    }
    //find name of month with input parameter
    //return name of month
    //get map as parameter
    public String findInField(int value){
        String monthName="";
        for (int count=0;count<months.length;count++){
            if((value-1)==count){
                monthName=months[count];

                break;
            }
        }
        return monthName;
    }
    //this function validates day input you
    //cant input day greather than 31 and less than zero
    public boolean validateDayInput(int day){
        if(day<1 || day>31){
            errors=true;
            System.out.println("Date must be between 1 and 31");
        }else{
            errors=false;
        }
        return errors;
    }
    //this function validates month input you cant
    //input months that are less than 1 and greather than 12
    public boolean validateMonthInput(int month){
        if(month<1 || month>12){
            errors=true;
            System.out.println("Error!!! Month must be between 1 and 12!!!");
        }else{
            errors=false;
        }
        return errors;
    }
    //this function validates year
    //you cant input year less than 1900
    public boolean validateYearInput(int year){
        if(year<1900){
            errors=true;
            System.out.println("Year must be greater than 1900");
        }else{
           errors=false;
        }
        return errors;
    }
    //consturctor constructs date
    //it have a validation
    //it will be called when date is set and input
    //was made
    //if there is no errors
    //set values
    public Date(int day,int month,int year) {
        if((validateDayInput(day)==false)&&(validateDate(day, month, year)==false)) this.day=day;
        else System.out.println("Error!!! Wrong day entered!!!");
        if((validateMonthInput(month)==false)&&(validateDate(day, month, year)==false))this.month=month;
        else System.out.println("Error!!! Wrong month entered!!!");
        if((validateYearInput(year)==false)&&(validateDate(day, month, year)==false)) this.year=year;
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

    public static void parseDate(String date){
        String newDate="";
        String day="";
        String month="";
        String year="";
        int positionOfFirstFullStop=0;
        int positionOfSecondFullStop=0;
        int numOfFullStopAccessed=0;
        for(int i=0;i<date.length();i++){

            if(date.charAt(i)=='.'){
                numOfFullStopAccessed++;
                if(numOfFullStopAccessed==1){
                    positionOfFirstFullStop=i;
                    //System.out.println("Position of first full stop:"+positionOfFirstFullStop);
                }else if(numOfFullStopAccessed==2){
                    positionOfSecondFullStop=i;
                    //System.out.println("Position of second full stop:"+positionOfSecondFullStop);
                }
                continue;
            }else{
                newDate+=date.charAt(i);
            }

        }
        System.out.println(newDate);
        String temp="";
        for (int j=0;j<newDate.length();j++){

                if(j==positionOfFirstFullStop){
                    day=temp;
                    temp="";
                } else{
                    temp+=newDate.charAt(j);

                }



        }
        System.out.println(day);

        System.out.println(month);


        for (int count=positionOfSecondFullStop-1;count<newDate.length();count++){
            year+=newDate.charAt(count);
        }
        System.out.println(year);




    }

    public String getDate() {
        return String.valueOf(getDay())+getCharBetweenNumbers()+String.valueOf(getMonth())+getCharBetweenNumbers()+String.valueOf(getYear());
    }
}
