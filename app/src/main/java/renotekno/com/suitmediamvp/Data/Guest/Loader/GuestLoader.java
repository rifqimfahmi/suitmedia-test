package renotekno.com.suitmediamvp.Data.Guest.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v4.content.AsyncTaskLoader;
import android.widget.Toast;

import java.util.List;

import renotekno.com.suitmediamvp.Data.Base.ErrorListener;
import renotekno.com.suitmediamvp.Data.Guest.Model.Guest;
import renotekno.com.suitmediamvp.Util.CommonUtils;
import renotekno.com.suitmediamvp.View.Guests.GuestsMvpView;
import renotekno.com.suitmediamvp.View.Guests.GuestsPresenter;

/**
 * Created by zcabez on 11/24/2017.
 */

public class GuestLoader extends AsyncTaskLoader<List<Guest>> {

    private ErrorListener mErrorListener;
    private Handler mHandler;

    public GuestLoader(Context context, GuestsPresenter errorListener) {
        super(context);
        mHandler = new Handler(context.getMainLooper());
        mErrorListener = errorListener;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Guest> loadInBackground() {

        if (!CommonUtils.isNetworkConnected(getContext())) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mErrorListener.onError("Tidak ada koneksi internet, coba lagi nanti");
                }
            });
            return null;
        }

        return CommonUtils.fetchGuest();
    }
}
