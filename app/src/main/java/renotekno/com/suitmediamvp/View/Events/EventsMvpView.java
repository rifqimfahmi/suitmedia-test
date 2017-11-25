package renotekno.com.suitmediamvp.View.Events;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import renotekno.com.suitmediamvp.Data.Event.Adapter.EventsAdapter;
import renotekno.com.suitmediamvp.Data.Event.Decoration.Divider;
import renotekno.com.suitmediamvp.Data.Event.Model.Event;
import renotekno.com.suitmediamvp.View.Base.MvpView;

/**
 * Created by zcabez on 11/24/2017.
 */

public interface EventsMvpView extends MvpView {
    void eventChoosed(Event event);
    void initEventsList(LinearLayoutManager manager, EventsAdapter adapter, @Nullable Divider divider);
}
