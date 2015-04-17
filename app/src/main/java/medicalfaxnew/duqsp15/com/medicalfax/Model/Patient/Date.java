package medicalfaxnew.duqsp15.com.medicalfax.Model.Patient;

/**
 * Created by Coder Barbie
 */

/**
 * The Date class contains 3 fields: month, day, year that can be set and
 * retrieved
 */
public class Date {

    /**
     * month in String format (i.e. July, August,...)
     */
    private String month;
    /**
     * the day in string format (i.e. 1,...,30)
     */
    private String day;

    /**
     * the year in string format (i.e. 2015)
     */
    private String year;


    /**
     *
     */
    private String date;

    /**
     * nullary constructor
     */
    public Date() {
        //
    }

    /**
     * Constructor that takes in the date string
     * @param date
     */
    public Date(String date) {
       this.date = date;
    }

    /**
     * Constructor requiring all date fields
     *
     * @param month
     * @param day
     * @param year
     */
    public Date(String month, String day, String year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /**
     * @param newDate set the string date as
     */
    public void setDate(String newDate) {
        date = newDate;
    }

    /**
     * @param newMonth set the month as
     */
    public void setMonth(String newMonth) {

        month = newMonth;
    }


    /**
     * @param newDay set the day as
     */
    public void setDay(String newDay) {

        day = newDay;
    }

    /**
     * @param newYear set the year as
     */
    public void setYear(String newYear) {

        year = newYear;
    }

    /**
     * @return the month
     */
    public String getMonth() {

        return month;
    }

    /**
     * @return the day of the week
     */
    public String getDay() {

        return day;
    }

    /**
     * @return the year
     */
    public String getYear() {

        return year;
    }


    /**
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /*
   Verifies that the date is present
   @return Boolean
    */
    public Boolean verifyDate() {
        if (date.isEmpty()) {
            return false;
        }
        return true;
    }


    /*
    Verifies that the month is present
    @return Boolean
     */
    public Boolean verifyMonth() {
        if (month.isEmpty()) {
            return false;
        }
        return true;
    }

    /*
   Verifies that the day is present
   @return Boolean
    */
    public Boolean verifyDay() {
        if (day.isEmpty()) {
            return false;
        }
        return true;
    }

    /*
   Verifies that the year is present
   @return Boolean
    */
    public Boolean verifyYear() {
        if (day.isEmpty()) {
            return false;
        }
        return true;
    }
}
