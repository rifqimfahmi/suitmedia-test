package renotekno.com.suitmediamvp.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import renotekno.com.suitmediamvp.Data.Guest.Model.Guest;

/**
 * Created by zcabez on 11/24/2017.
 */

public class CommonUtils {

    public static final int[] basePrime = {1, 2, 3, 5, 7};

    private CommonUtils () {

    }

    public static boolean isPalindrome(String name){
        String noSpace = name.toLowerCase().replace(" ", "");
        char[] words = noSpace.toCharArray();

        int i = 0;
        int x = words.length - 1;

        while (x > i) {
            if (words[i] != words[x]) {
                return false;
            }
            i++;
            x--;
        }

        return true;
    }

    public static boolean isNameValid(String name) {
        return !name.isEmpty();
    }

    public static boolean isNetworkConnected (Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public static List<Guest> fetchGuest() {
        ANRequest anRequest = AndroidNetworking.get(Guest.GUESTS_LINK)
                .setPriority(Priority.MEDIUM)
                .build();

        ANResponse response = anRequest.executeForJSONArray();

        if (!response.isSuccess()) return null;

        JSONArray guestArray = (JSONArray) response.getResult();

        List<Guest> guests = new ArrayList<>();
        try {
            for (int i = 0; i < guestArray.length(); i++) {
                JSONObject guestObj = guestArray.getJSONObject(i);

                int id = guestObj.getInt("id");
                String name = guestObj.getString("name");
                String birthDate = guestObj.getString("birthdate");
                guests.add(new Guest(id, name, birthDate));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return guests;
    }

    public static boolean isPrime(int num) {
        for (int i = 0; i < CommonUtils.basePrime.length; i ++) {
            int baseNum = CommonUtils.basePrime[i];

            if (num == baseNum) {
                return true;
            }

            if (baseNum == 1) {
                continue;
            }

            if (num % baseNum == 0) {
                return false;
            }
        }
        return true;
    }
}
