package renotekno.com.suitmediamvp.View.Status;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import renotekno.com.suitmediamvp.Data.User.User;
import renotekno.com.suitmediamvp.R;
import renotekno.com.suitmediamvp.View.Base.BaseActivity;
import renotekno.com.suitmediamvp.View.Home.HomeActivity;

public class StatusActivity extends BaseActivity {

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, StatusActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

    }
}
