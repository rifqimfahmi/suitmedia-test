package renotekno.com.suitmediamvp.Data.Guest.Model;

import android.content.Context;

import renotekno.com.suitmediamvp.Util.CommonUtils;

/**
 * Created by zcabez on 11/23/2017.
 */

public class Guest {

    public static final String GUESTS_LINK = "http://dry-sierra-6832.herokuapp.com/api/people";

    private String mName;
    private String mBirthDate;
    private int mId;

    public Guest(int id, String name, String birthDate) {
        mId = id;
        mName = name;
        mBirthDate = birthDate;
    }

    public int getImage(Context context) {
        return context.getResources().getIdentifier(mName.toLowerCase(), "drawable", context.getPackageName());
    }

    public String getName() {
        return mName;
    }

    public boolean isMonthPrime() {
        int month = getMonth();
        return CommonUtils.isPrime(month);
    }

    public String getToastText() {
        int day = getDay();
        String toastText = "";

        if (day <= 1) {
            toastText = "feature phone";
        } else if (isEven(day) && isOdd(day)) {
            toastText = "iOS";
        } else if (isEven(day)) {
            toastText = "blackberry";
        } else if (isOdd(day)) {
            toastText = "android";
        }

        return toastText;
    }

    private int getDay(){
        String[] dateComponent = mBirthDate.split("-");
        return Integer.parseInt(dateComponent[2]);
    }

    private int getMonth() {
        String[] dateComponent = mBirthDate.split("-");
        return Integer.parseInt(dateComponent[1]);
    }

    private boolean isEven(int num) {
        return (num % 2) == 0;
    }

    private boolean isOdd(int num){
        return (num % 3) == 0;
    }
}
