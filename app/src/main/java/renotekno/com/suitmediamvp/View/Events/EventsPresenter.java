package renotekno.com.suitmediamvp.View.Events;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.IconGenerator;

import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.Data.Base.ListItemListener;
import renotekno.com.suitmediamvp.Data.Event.Adapter.EventsAdapter;
import renotekno.com.suitmediamvp.Data.Event.Model.Event;
import renotekno.com.suitmediamvp.View.Base.BasePresenter;

/**
 * Created by zcabez on 11/24/2017.
 */

public class EventsPresenter<V extends EventsMvpView> extends BasePresenter<V> implements EventsMvpPresenter<V>, ListItemListener {

    private int currentMapPosition = 0;

    public EventsPresenter(AppDataManager appDataManager) {
        super(appDataManager);
    }

    public void configRecyclerView(Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        EventsAdapter eventsAdapter = new EventsAdapter(this);
//        Divider divider = new Divider(ContextCompat.getDrawable(context, R.drawable.list_divider));
        getMvpView().initEventsList(linearLayoutManager, eventsAdapter, null);
    }

    @Override
    public void onListItemClick(Object object) {
        if (!(object instanceof Event)) return;
        Event event = (Event) object;
        getMvpView().eventChoosed(event);
    }

    @Override
    public void configToolBar(EventsActivity activity) {
        if (activity.getSupportActionBar() == null) return;

        activity.getSupportActionBar().setTitle("MESSAGE FROM CODI");
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public void changeEventOrientation(Context context, EventsAdapter eventsAdapter) {
        if ( !eventsAdapter.isCardVerticalView() ) return;
        eventsAdapter.changeOrientation();

        LinearLayoutManager horizontalLM = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        LinearSnapHelper snapHelper = new LinearSnapHelper();
        getMvpView().changeOrientation(horizontalLM, snapHelper, eventsAdapter);
    }

    @Override
    public void changeMapPinPoint(Context context, int newPosition) {
        if (newPosition < 0 || currentMapPosition == newPosition) return;
        if ( AppDataManager.events[newPosition].isSelected() ) return;
        Log.d("RUN_ONCE", "run");
        unselectMarker(context, currentMapPosition);

        currentMapPosition = newPosition;

        moveCamera(newPosition);
        selectMarker(context, currentMapPosition);
    }

    private void selectMarker(Context context, int currentMapPosition) {
        changeMarkerColor(context, currentMapPosition, IconGenerator.STYLE_GREEN);
    }

    private void unselectMarker(Context context, int currentMapPosition) {
        changeMarkerColor(context, currentMapPosition, IconGenerator.STYLE_ORANGE);
    }

    private void changeMarkerColor(Context context, int currentMapPosition, int IGColor) {
        Event event = AppDataManager.events[currentMapPosition];

        IconGenerator iconGenerator = new IconGenerator(context);
        iconGenerator.setStyle(IGColor);
        event.getMarker().setIcon(BitmapDescriptorFactory.fromBitmap(iconGenerator.makeIcon(event.getName())));

        switch (IGColor) {
            case IconGenerator.STYLE_GREEN:
                event.setSelected(true);
                break;
            case IconGenerator.STYLE_ORANGE:
                event.setSelected(false);
                break;
        }
    }

    @Override
    public void addMarkers(Context context) {
        for (int i = 0; i < AppDataManager.events.length; i++) {
            Event event = AppDataManager.events[i];
            IconGenerator iconGenerator = new IconGenerator(context);
            if (i == 0) {
                iconGenerator.setStyle(IconGenerator.STYLE_GREEN);
            } else {
                iconGenerator.setStyle(IconGenerator.STYLE_ORANGE);
            }

            MarkerOptions markerOpt = new MarkerOptions();
            LatLng latLng = new LatLng(event.getLat(), event.getLng());
            markerOpt.icon(BitmapDescriptorFactory.fromBitmap(iconGenerator.makeIcon(event.getName())));
            markerOpt.anchor(iconGenerator.getAnchorU(), iconGenerator.getAnchorV());
            markerOpt.position(latLng);

            getMvpView().addMarker(event, markerOpt);
        }

        moveMapCameraToFirst();
    }

    @Override
    public void goToMarker(Context context, Marker marker) {
        String markerId = marker.getId();
        int markerPosition = 0;
        for (int i = 0; i < AppDataManager.events.length; i++) {
            if (markerId.equals(AppDataManager.events[i].getMarker().getId())) {
                markerPosition = i;
                break;
            }
        }

        changeMapPinPoint(context, markerPosition);
        getMvpView().smoothScrollTo(markerPosition);
    }

    @Override
    public void refreshDataMarkerState() {
        for (int i = 0; i < AppDataManager.events.length; i++) {
            AppDataManager.events[i].setSelected(false);
        }
    }

    private void moveMapCameraToFirst() {
        moveCamera(0);
    }

    private void moveCamera(int position) {
        LatLng latLng = new LatLng(AppDataManager.events[position].getLat(), AppDataManager.events[position].getLng());
        CameraPosition cameraPosition = CameraPosition.builder().zoom(16).target(latLng).build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        getMvpView().flyTo(cameraUpdate);
    }
}
