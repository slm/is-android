package is.base;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by slmyldz on 22.12.2015.
 */
public class Dates {

    /**
     * @param dateFormat
     * @return formatted current date
     */
    public String getCurrentDate(String dateFormat) {
        Date d = new Date();
        String currentDate = new SimpleDateFormat(dateFormat).format(d.getTime());
        return currentDate;
    }

    /**
     * @return long
     */
    public long getCurrentDateTimeStamp() {
        Date d = new Date();
        return d.getTime();
    }


    /**
     * @param date
     * @return
     */
    public boolean isToday(Date date){
        long epochInMillis = date.getTime();
        Calendar timeToCheck = Calendar.getInstance();
        timeToCheck.setTimeInMillis(epochInMillis);

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());

        if(now.get(Calendar.YEAR) == timeToCheck.get(Calendar.YEAR)) {
            if(now.get(Calendar.DAY_OF_YEAR) == timeToCheck.get(Calendar.DAY_OF_YEAR)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * @return boolean
     */
    public boolean todayIsWeekend(){
        Calendar now = Calendar.getInstance();
        return isWeekend(now.getTime());
    }

    /**
     * @return
     */
    public boolean todayIsWeekday(){
        Calendar now = Calendar.getInstance();
        return isWeekday(now.getTime());
    }

    /**
     * @param date
     * @return
     */
    public boolean isWeekend(Date date){
        long epochInMillis = date.getTime()*1000;
        Calendar timeToCheck = Calendar.getInstance();
        timeToCheck.setTimeInMillis(epochInMillis);
        int day = timeToCheck.get(Calendar.DAY_OF_WEEK);
        return day == Calendar.SUNDAY || day == Calendar.SATURDAY;
    }

    /**
     * @param date
     * @return
     */
    public boolean isWeekday(Date date){
        long epochInMillis = date.getTime()*1000;
        Calendar timeToCheck = Calendar.getInstance();
        timeToCheck.setTimeInMillis(epochInMillis);
        int day = timeToCheck.get(Calendar.DAY_OF_WEEK);
        return day != Calendar.SUNDAY && day != Calendar.SATURDAY;
    }









}
