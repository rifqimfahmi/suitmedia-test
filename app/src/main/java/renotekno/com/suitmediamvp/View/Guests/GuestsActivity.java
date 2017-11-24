package renotekno.com.suitmediamvp.View.Guests;

import android.os.Bundle;

import renotekno.com.suitmediamvp.R;
import renotekno.com.suitmediamvp.View.Base.BaseActivity;

public class GuestsActivity extends BaseActivity implements GuestsMvpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guests);
    }
}
