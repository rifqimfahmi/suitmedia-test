package renotekno.com.suitmediamvp.View.Status;

import renotekno.com.suitmediamvp.View.Base.MvpView;

/**
 * Created by zcabez on 11/24/2017.
 */

public interface StatusMvpView extends MvpView {
    void setName(String name);
    void setEventBtn(String eventName);
    void setGuestBtn(String guestName);
    void runToast(String toastMessage);
    void showPalindromeStatus(String message);
}
