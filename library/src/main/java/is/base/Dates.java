package is.base;

import java.text.SimpleDateFormat;
import java.util.Date;

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
     * @param timestamp
     * @return boolean
     */
    public boolean isToday(long timestamp){
        long diff = timestamp - getCurrentDateTimeStamp();
        if(Math.abs(diff)> 24*60*60){
            return false;
        }else{
            return true;
        }
    }




}
