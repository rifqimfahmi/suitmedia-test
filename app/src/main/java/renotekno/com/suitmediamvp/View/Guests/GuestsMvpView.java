package renotekno.com.suitmediamvp.View.Guests;

import android.support.v7.widget.GridLayoutManager;

import java.util.List;

import renotekno.com.suitmediamvp.Data.Guest.Adapter.GuestsAdapter;
import renotekno.com.suitmediamvp.Data.Guest.Model.Guest;
import renotekno.com.suitmediamvp.View.Base.MvpView;

/**
 * Created by zcabez on 11/24/2017.
 */

public interface GuestsMvpView extends MvpView {
    void showLoadingIndicator();
    void showErrorToast(String message);
    void hideLoadingIndicator();
    void notifyDataLoaded();
    void showEmptyView();
    void hideEmptyView();
    boolean isEmptyView();
    void initRecyclerView(GridLayoutManager gridLayoutManager, GuestsAdapter guestsAdapter);
    void guestChoosed(Guest guest);
}
