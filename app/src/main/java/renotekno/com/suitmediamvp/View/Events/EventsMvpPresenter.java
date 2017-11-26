package renotekno.com.suitmediamvp.View.Events;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import renotekno.com.suitmediamvp.Data.Event.Adapter.EventsAdapter;
import renotekno.com.suitmediamvp.View.Base.MvpPresenter;
import renotekno.com.suitmediamvp.View.Base.MvpView;

/**
 * Created by zcabez on 11/24/2017.
 */

public interface EventsMvpPresenter<V extends MvpView> extends MvpPresenter<V> {
    void configToolBar(EventsActivity activity);
    void changeEventOrientation(Context context, EventsAdapter eventsAdapter);
    void changeMapPinPoint(Context context, int position);
    void addMarkers(Context context);
    void goToMarker(Context context, Marker marker);
    void refreshDataMarkerState();
}
