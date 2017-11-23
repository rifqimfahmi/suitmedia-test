package renotekno.com.suitmediamvp.View.Base;

import renotekno.com.suitmediamvp.Data.AppDataManager;

/**
 * Created by zcabez on 11/23/2017.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    AppDataManager mAppDataManager;
    private V mMvpView;

    public BasePresenter (AppDataManager appDataManager) {
        mAppDataManager = appDataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public AppDataManager getAppDataManager() {
        return mAppDataManager;
    }
}
