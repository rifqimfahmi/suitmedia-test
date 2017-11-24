package renotekno.com.suitmediamvp.View.Events;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import renotekno.com.suitmediamvp.R;
import renotekno.com.suitmediamvp.View.Status.StatusActivity;

public class EventsActivity extends AppCompatActivity {

    public static final int CHOOSE_EVENT_REQ = 3;

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, EventsActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
    }
}
