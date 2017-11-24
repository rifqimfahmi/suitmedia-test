package renotekno.com.suitmediamvp.View.Home;

import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.View.Base.BasePresenter;
import renotekno.com.suitmediamvp.View.Base.MvpView;
import renotekno.com.suitmediamvp.View.Splash.SplashMvpPresenter;
import renotekno.com.suitmediamvp.View.Splash.SplashMvpView;

/**
 * Created by zcabez on 11/23/2017.
 */

public class HomePresenter<V extends HomeMvpView> extends BasePresenter<V> implements HomeMvpPresenter<V> {

    public HomePresenter(AppDataManager appDataManager) {
        super(appDataManager);
    }


}
