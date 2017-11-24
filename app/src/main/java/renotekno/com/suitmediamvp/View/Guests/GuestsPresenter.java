package renotekno.com.suitmediamvp.View.Guests;

import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.View.Base.BasePresenter;

/**
 * Created by zcabez on 11/24/2017.
 */

public class GuestsPresenter<V extends GuestsMvpView> extends BasePresenter<V> implements GuestsMvpPresenter<V> {
    public GuestsPresenter(AppDataManager appDataManager) {
        super(appDataManager);
    }
}
