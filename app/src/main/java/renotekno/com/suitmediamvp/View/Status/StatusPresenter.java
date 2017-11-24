package renotekno.com.suitmediamvp.View.Status;

import android.content.Intent;
import android.os.Bundle;

import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.Data.User.User;
import renotekno.com.suitmediamvp.View.Base.BasePresenter;
import renotekno.com.suitmediamvp.View.Splash.SplashMvpPresenter;

/**
 * Created by zcabez on 11/24/2017.
 */

public class StatusPresenter<V extends StatusMvpView> extends BasePresenter<V> implements StatusMvpPresenter<V> {

    public StatusPresenter(AppDataManager appDataManager) {
        super(appDataManager);
    }

    public void bindDataToView(StatusActivity statusActivity, Bundle savedInstanceState) {
        Intent intent = statusActivity.getIntent();
        String name = intent.getStringExtra(User.CHOOSED_NAME);
        getMvpView().setName(name);
    }
}
