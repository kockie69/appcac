package kitchendroid.packtpub.com.appcac;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Settings {
    public String host;
    public Integer port;

    Context context;

    Settings(Context c) {
       context = c;
    }

    public void loadPref() {

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);

        host = sharedPref.getString("host_preference", "192.168.2.17");
        port = Integer.parseInt(sharedPref.getString("port_preference", "10747"));
    }
}
