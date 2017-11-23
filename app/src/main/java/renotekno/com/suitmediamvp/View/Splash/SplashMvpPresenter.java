package renotekno.com.suitmediamvp.View.Splash;

import renotekno.com.suitmediamvp.View.Base.MvpPresenter;
import renotekno.com.suitmediamvp.View.Base.MvpView;

/**
 * Created by zcabez on 11/23/2017.
 */

public interface SplashMvpPresenter<V extends MvpView> extends MvpPresenter<V> {
    void decideNextActivity();
}
