package hr.josip.mydata.processing;

public class Date {
    private int day;
    private int month;
    private int year;
    private char charBetweenNumbers;
    public static boolean errors=false;

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
