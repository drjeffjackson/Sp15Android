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
    public Date(String month, String day, String year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /**
     * @param newMonth
     * @param newDay
     * @param newYear
     */
    public void setDate(String newMonth, String newDay, String newYear) {
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
    public void setDay(String newDay) {

        day = newDay;
    }

    /**
     * @param newYear
     */
    public void setYear(String newYear) {

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
    public String getDay() {

        return day;
    }

    /**
     * @return
     */
    public String getYear() {

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
