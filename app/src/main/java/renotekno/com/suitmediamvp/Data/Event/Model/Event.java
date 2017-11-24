package renotekno.com.suitmediamvp.Data.Event.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zcabez on 11/23/2017.
 */

public class Event {
    private String mName;
    private Date mDate;
    private int mSnap;

    public Event(String name, Date date, int snap) {
        mName = name;
        mDate = date;
        mSnap = snap;
    }

    public String getName() {
        return mName;
    }

    public String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        return simpleDateFormat.format(mDate);
    }

    public int getSnap() {
        return mSnap;
    }
}
