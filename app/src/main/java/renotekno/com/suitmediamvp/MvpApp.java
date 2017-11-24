package renotekno.com.suitmediamvp;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

import renotekno.com.suitmediamvp.Data.AppDataManager;

/**
 * Created by zcabez on 11/23/2017.
 */

public class MvpApp extends Application {

    AppDataManager mAppDataManager;

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidNetworking.initialize(getApplicationContext());
        mAppDataManager = new AppDataManager();
    }

    public AppDataManager getAppDataManager(){
        return mAppDataManager;
    }
}
