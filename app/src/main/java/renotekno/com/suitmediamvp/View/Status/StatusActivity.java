package renotekno.com.suitmediamvp.View.Status;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.Data.User.User;
import renotekno.com.suitmediamvp.MvpApp;
import renotekno.com.suitmediamvp.R;
import renotekno.com.suitmediamvp.View.Base.BaseActivity;
import renotekno.com.suitmediamvp.View.Events.EventsActivity;
import renotekno.com.suitmediamvp.View.Home.HomeActivity;
import renotekno.com.suitmediamvp.View.Home.HomePresenter;

public class StatusActivity extends BaseActivity implements StatusMvpView{

    StatusPresenter mStatusPresenter;

    @BindView(R.id.nameView)
    TextView mNameView;
    @BindView(R.id.eventChooserBtn)
    Button mEventChooserBtn;
    @BindView(R.id.guestChooserBtn)
    Button mGuestChooserBtn;

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, StatusActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        ButterKnife.bind(this);

        AppDataManager appDataManager = ((MvpApp) getApplication()).getAppDataManager();
        mStatusPresenter = new StatusPresenter(appDataManager);
        mStatusPresenter.onAttach(this);
        mStatusPresenter.bindDataToView(this, savedInstanceState);
    }

    @OnClick(R.id.eventChooserBtn)
    public void openEventActivityChooser () {
        Intent intent = EventsActivity.getStartIntent(this);
        startActivityForResult(intent, EventsActivity.CHOOSE_EVENT_REQ);
    }

    @OnClick(R.id.guestChooserBtn)
    public void openGuestActivityChooser () {

    }

    @Override
    public void setName(String name) {
        mNameView.setText(name);
    }
}
