package renotekno.com.suitmediamvp.View.Status;

import android.content.Intent;
import android.os.Bundle;

import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.Data.User.User;
import renotekno.com.suitmediamvp.View.Base.BasePresenter;
import renotekno.com.suitmediamvp.View.Events.EventsActivity;
import renotekno.com.suitmediamvp.View.Guests.GuestsActivity;
import renotekno.com.suitmediamvp.View.Splash.SplashMvpPresenter;

/**
 * Created by zcabez on 11/24/2017.
 */

public class StatusPresenter<V extends StatusMvpView> extends BasePresenter<V> implements StatusMvpPresenter<V> {

    public StatusPresenter(AppDataManager appDataManager) {
        super(appDataManager);
    }

    @Override
    public void bindDataToView(StatusActivity statusActivity, Bundle savedInstanceState) {



        Intent intent = statusActivity.getIntent();
        String name = intent.getStringExtra(User.CHOOSED_NAME);
        getMvpView().setName(name);
    }

    @Override
    public void saveState(Bundle outState) {
//        outState.
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case EventsActivity.CHOOSE_EVENT_RES:
                String eventName = data.getStringExtra(User.CHOOSED_EVENT);
                getMvpView().setEventBtn(eventName);
                break;
            case GuestsActivity.CHOOSE_REQ_RES:
                String guestName = data.getStringExtra(User.CHOOSED_GUEST_NAME);
                getMvpView().setGuestBtn(guestName);

                String toastMessage = data.getStringExtra(User.CHOOSED_GUEST_TOAST);
                getMvpView().runToast(toastMessage);
                break;
            default:
                return;
        }
    }
}
