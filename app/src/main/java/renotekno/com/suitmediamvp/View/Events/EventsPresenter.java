package renotekno.com.suitmediamvp.View.Events;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.Data.Base.HorizontalListItemListener;
import renotekno.com.suitmediamvp.Data.Base.ListItemListener;
import renotekno.com.suitmediamvp.Data.Event.Adapter.EventsAdapter;
import renotekno.com.suitmediamvp.Data.Event.Decoration.Divider;
import renotekno.com.suitmediamvp.Data.Event.Model.Event;
import renotekno.com.suitmediamvp.R;
import renotekno.com.suitmediamvp.View.Base.BasePresenter;

/**
 * Created by zcabez on 11/24/2017.
 */

public class EventsPresenter<V extends EventsMvpView> extends BasePresenter<V> implements EventsMvpPresenter<V>, ListItemListener, HorizontalListItemListener {

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
    public void changeMapPinPoint(int position) {
        if (position < 0 || currentMapPosition == position) return;
        currentMapPosition = position;

        // change map pinPoint here
        getMvpView().changeMapPinPoint(position);

    }

    @Override
    public void onHorizontalItemClick(Event event, int position) {
        getMvpView().horizontalItemClicked(event, position);
    }
}
