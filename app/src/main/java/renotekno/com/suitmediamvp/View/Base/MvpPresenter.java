package renotekno.com.suitmediamvp.View.Base;

/**
 * Created by zcabez on 11/23/2017.
 */

public interface MvpPresenter<V extends MvpView> {
    void onAttach(V mvpView);
}
