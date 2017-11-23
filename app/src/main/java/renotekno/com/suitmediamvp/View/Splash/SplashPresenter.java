package renotekno.com.suitmediamvp.View.Splash;

import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.View.Base.BasePresenter;

/**
 * Created by zcabez on 11/23/2017.
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V> {

    public SplashPresenter(AppDataManager appDataManager) {
        super(appDataManager);
    }

    @Override
    public void decideNextActivity() {
        getMvpView().openHomeActivity();
    }
}
