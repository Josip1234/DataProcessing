package hr.josip.mydata.processing;

public class Date {
    private int day;
    private int month;
    private int year;
    private char charBetweenNumbers;

    public Date(int day,int month,int year) {
        this.day=day;
        this.month=month;
        this.year=year;
        this.charBetweenNumbers='.';
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
