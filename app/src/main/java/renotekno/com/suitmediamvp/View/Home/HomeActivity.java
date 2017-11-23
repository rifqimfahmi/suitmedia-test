package renotekno.com.suitmediamvp.View.Home;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import renotekno.com.suitmediamvp.R;
import renotekno.com.suitmediamvp.View.Base.BaseActivity;

public class HomeActivity extends BaseActivity {

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
