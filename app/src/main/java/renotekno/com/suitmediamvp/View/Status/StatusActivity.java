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
import renotekno.com.suitmediamvp.View.Guests.GuestsActivity;
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
        Intent intent = GuestsActivity.getStartIntent(this);
        startActivityForResult(intent, GuestsActivity.CHOOSE_REQ_REQ);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mStatusPresenter.saveState(outState, mEventChooserBtn.getText().toString(), mGuestChooserBtn.getText().toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mStatusPresenter.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void setName(String name) {
        mNameView.setText(name);
    }

    @Override
    public void setEventBtn(String eventName) {
        mEventChooserBtn.setText(eventName);
    }

    @Override
    public void setGuestBtn(String guestName) {
        mGuestChooserBtn.setText(guestName);
    }

    @Override
    public void runToast(String toastMessage) {
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }
}
