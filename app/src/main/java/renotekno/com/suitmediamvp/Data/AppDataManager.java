package renotekno.com.suitmediamvp.Data;

import java.util.Date;

import renotekno.com.suitmediamvp.Data.Event.Model.Event;
import renotekno.com.suitmediamvp.R;

/**
 * Created by zcabez on 11/23/2017.
 */

public class AppDataManager implements DataManager{

    public static final Event[] events = {
            new Event("Tech in Asia", new Date(1511604000000L), R.drawable.event_tech_in_asia),
            new Event("Google I/O", new Date(1514712600000L), R.drawable.event_google_io),
            new Event("Google Launchpad", new Date(1515139200000L), R.drawable.event_gdl),
            new Event("Microsoft Ignite", new Date(1519891200000L), R.drawable.event_microsoft_ignite),
    };

}
