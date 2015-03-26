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
     * the day in integer format (i.e. 1,...,30)
     */
    private int day = 0;

    /**
     * the year in integer format (i.e. 2015)
     */
    private int year = 0;

    /**
     * nullary constructor
     */
    public Date() {
        //
    }

    /**
     * Constructor requiring all date fields
     *
     * @param month
     * @param day
     * @param year
     */
    public Date(String month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /**
     * @param newMonth
     * @param newDay
     * @param newYear
     */
    public void setDate(String newMonth, int newDay, int newYear) {
        month = newMonth;
        day = newDay;
        year = newYear;
    }

    /**
     * @param newMonth
     */
    public void setMonth(String newMonth) {

        month = newMonth;
    }

    /**
     * @param newDay
     */
    public void setDay(int newDay) {

        day = newDay;
    }

    /**
     * @param newYear
     */
    public void setYear(int newYear) {

        year = newYear;
    }

    /**
     * @return
     */
    public String getMonth() {

        return month;
    }

    /**
     * @return
     */
    public int getDay() {

        return day;
    }

    /**
     * @return
     */
    public int getYear() {

        return year;
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
        if (day != 0) {
            return false;
        }
        return true;
    }

    /*
   Verifies that the year is present
   @return Boolean
    */
    public Boolean verifyYear() {
        if (day != 0) {
            return false;
        }
        return true;
    }
}
