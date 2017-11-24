package renotekno.com.suitmediamvp.View.Home;

import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.View.Base.BasePresenter;

/**
 * Created by zcabez on 11/23/2017.
 */

public class HomePresenter<V extends HomeMvpView> extends BasePresenter<V> implements HomeMvpPresenter<V> {

    public HomePresenter(AppDataManager appDataManager) {
        super(appDataManager);
    }
}
