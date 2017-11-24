package renotekno.com.suitmediamvp.Util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

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
    private CommonUtils () {

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
}
