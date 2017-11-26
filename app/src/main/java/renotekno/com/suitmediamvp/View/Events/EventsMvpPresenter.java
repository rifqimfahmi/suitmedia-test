package renotekno.com.suitmediamvp.View.Events;

import renotekno.com.suitmediamvp.View.Base.MvpPresenter;
import renotekno.com.suitmediamvp.View.Base.MvpView;

/**
 * Created by zcabez on 11/24/2017.
 */

public interface EventsMvpPresenter<V extends MvpView> extends MvpPresenter<V> {
    void configToolBar(EventsActivity activity);
}
