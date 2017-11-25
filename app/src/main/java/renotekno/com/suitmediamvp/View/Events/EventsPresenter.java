package renotekno.com.suitmediamvp.View.Events;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;

import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.Data.Base.ListItemListener;
import renotekno.com.suitmediamvp.Data.Event.Adapter.EventsAdapter;
import renotekno.com.suitmediamvp.Data.Event.Decoration.Divider;
import renotekno.com.suitmediamvp.Data.Event.Model.Event;
import renotekno.com.suitmediamvp.R;
import renotekno.com.suitmediamvp.View.Base.BasePresenter;

/**
 * Created by zcabez on 11/24/2017.
 */

public class EventsPresenter<V extends EventsMvpView> extends BasePresenter<V> implements EventsMvpPresenter<V>, ListItemListener {
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
}
