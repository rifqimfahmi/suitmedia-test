package renotekno.com.suitmediamvp.View.Splash;
import android.content.Intent;
import android.os.Bundle;

import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.MvpApp;
import renotekno.com.suitmediamvp.R;
import renotekno.com.suitmediamvp.View.Base.BaseActivity;
import renotekno.com.suitmediamvp.View.Home.HomeActivity;

public class SplashActivity extends BaseActivity implements SplashMvpView {

    SplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        AppDataManager dataManager = ((MvpApp) getApplication()).getAppDataManager();

        mSplashPresenter = new SplashPresenter(dataManager);
        mSplashPresenter.onAttach(this);
        mSplashPresenter.decideNextActivity();
    }

    @Override
    public void openHomeActivity() {
        Intent intent = HomeActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }
}
