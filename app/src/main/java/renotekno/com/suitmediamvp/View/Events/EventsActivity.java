package renotekno.com.suitmediamvp.View.Events;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.Data.Event.Adapter.EventsAdapter;
import renotekno.com.suitmediamvp.Data.Event.Decoration.Divider;
import renotekno.com.suitmediamvp.Data.Event.Model.Event;
import renotekno.com.suitmediamvp.Data.User.User;
import renotekno.com.suitmediamvp.MvpApp;
import renotekno.com.suitmediamvp.R;
import renotekno.com.suitmediamvp.View.Base.BaseActivity;

public class EventsActivity extends BaseActivity implements EventsMvpView {

    EventsPresenter mEventsPresenter;

    @BindView(R.id.eventsList)
    RecyclerView mEventsList;

    public static final int CHOOSE_EVENT_REQ = 3;
    public static final int CHOOSE_EVENT_RES = 3200;

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, EventsActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        ButterKnife.bind(this);

        AppDataManager appDataManager = ((MvpApp) getApplication()).getAppDataManager();
        mEventsPresenter = new EventsPresenter(appDataManager);
        mEventsPresenter.onAttach(this);
        mEventsPresenter.configRecyclerView(this);
    }

    @Override
    public void eventChoosed(Event event) {
        Intent intent = new Intent();
        intent.putExtra(User.CHOOSED_EVENT, event.getName());
        setResult(EventsActivity.CHOOSE_EVENT_RES, intent);
        finish();
    }

    @Override
    public void initEventsList(LinearLayoutManager manager, EventsAdapter adapter, Divider divider) {
        mEventsList.setHasFixedSize(true);
        mEventsList.setLayoutManager(manager);
        mEventsList.setAdapter(adapter);
        mEventsList.addItemDecoration(divider);
    }
}
