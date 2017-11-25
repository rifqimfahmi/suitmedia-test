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
    private String[] mLabels;

    public Event(String name, Date date, int snap, String[] labels) {
        mName = name;
        mDate = date;
        mSnap = snap;
        mLabels = labels;
    }

    public String getName() {
        return mName;
    }

    public String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        return simpleDateFormat.format(mDate);
    }

    public String[] getLabels() {
        return mLabels;
    }

    public int getSnap() {
        return mSnap;
    }
}
