package renotekno.com.suitmediamvp.Data.Event.Model;

import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

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
    private double mLat;
    private double mLng;
    private Marker mMarker;
    private boolean mIsSelected = false;

    public Event(String name, Date date, int snap, String[] labels, double lat, double lng) {
        mName = name;
        mDate = date;
        mSnap = snap;
        mLabels = labels;
        mLat = lat;
        mLng = lng;
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

    public double getLat(){
        return mLat;
    }

    public double getLng(){
        return mLng;
    }

    public void setMarker(Marker marker) {
        mMarker = marker;
    }

    public Marker getMarker() {
        return mMarker;
    }

    public void setSelected(boolean selected) {
        mIsSelected = selected;
    }

    public boolean isSelected() {
        return mIsSelected;
    }
}
