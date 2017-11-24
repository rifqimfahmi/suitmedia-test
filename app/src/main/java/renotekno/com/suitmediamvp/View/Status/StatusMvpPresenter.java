package renotekno.com.suitmediamvp.View.Status;

import android.content.Intent;
import android.os.Bundle;

import renotekno.com.suitmediamvp.View.Base.MvpPresenter;
import renotekno.com.suitmediamvp.View.Base.MvpView;

/**
 * Created by zcabez on 11/24/2017.
 */

public interface StatusMvpPresenter<V extends MvpView> extends MvpPresenter<V> {
    void onActivityResult(int requestCode, int resultCode, Intent data);
    void bindDataToView(StatusActivity statusActivity, Bundle savedInstanceState);
}
