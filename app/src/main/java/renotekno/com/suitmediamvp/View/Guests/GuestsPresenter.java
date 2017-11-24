package renotekno.com.suitmediamvp.View.Guests;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.Data.Base.ErrorListener;
import renotekno.com.suitmediamvp.Data.Base.ListItemListener;
import renotekno.com.suitmediamvp.Data.Guest.Adapter.GuestsAdapter;
import renotekno.com.suitmediamvp.Data.Guest.Loader.GuestLoader;
import renotekno.com.suitmediamvp.Data.Guest.Model.Guest;
import renotekno.com.suitmediamvp.View.Base.BasePresenter;

/**
 * Created by zcabez on 11/24/2017.
 */

public class GuestsPresenter<V extends GuestsMvpView> extends BasePresenter<V> implements GuestsMvpPresenter<V>,
        LoaderManager.LoaderCallbacks<List<Guest>>,
        ErrorListener,
        ListItemListener{

    private Context mContext;

    public GuestsPresenter(AppDataManager appDataManager, Context context) {
        super(appDataManager);
        mContext = context;
    }

    @Override
    public void loadGuestsData(GuestsActivity guestsActivity) {
        getMvpView().showLoadingIndicator();
        guestsActivity.getSupportLoaderManager().initLoader(GuestsActivity.CHOOSE_LOADER_ID, null, this);
    }

    @Override
    public void configRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2, LinearLayoutManager.VERTICAL, false);
        GuestsAdapter guestsAdapter = new GuestsAdapter(this, mContext);
        getMvpView().initRecyclerView(gridLayoutManager, guestsAdapter);
    }

    @Override
    public void reloadData(GuestsActivity guestsActivity) {
        guestsActivity.getSupportLoaderManager().restartLoader(GuestsActivity.CHOOSE_LOADER_ID, null, this);
    }

    @Override
    public void onError(String message) {
        getMvpView().showErrorToast(message);
        getMvpView().hideLoadingIndicator();
    }

    /***
     *
     * Loader Callbacks
     *
     */

    @Override
    public Loader<List<Guest>> onCreateLoader(int id, Bundle args) {
        return new GuestLoader(mContext, this);
    }

    @Override
    public void onLoadFinished(Loader<List<Guest>> loader, List<Guest> data) {
        getMvpView().hideLoadingIndicator();

        if (data == null) {
            getMvpView().showErrorToast("Terjadi kesalahan coba lagi nanti");
            getMvpView().showEmptyView();
            return;
        }

        if (data.size() == 0) {
            // tidak ada guest view
            getMvpView().showEmptyView();
            return;
        }

        if (getMvpView().isEmptyView()) getMvpView().hideEmptyView();

        AppDataManager.mGuests.clear();
        AppDataManager.mGuests.addAll(data);

        getMvpView().notifyDataLoaded();
    }

    @Override
    public void onLoaderReset(Loader<List<Guest>> loader) {

    }

    @Override
    public void onListItemClick(Object object) {
        if (!(object instanceof Guest)) return;
        Guest guest = (Guest) object;
        getMvpView().guestChoosed(guest);
    }
}
