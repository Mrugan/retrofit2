package com.test.retrofit2.Service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by spm3 on 9/22/2015.
 */
public class networkDetect extends Service {

    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        getConnectivityStatusString(getApplicationContext());
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public static int getConnectivityStatus(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;

            if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;
        }
        return TYPE_NOT_CONNECTED;
    }

    public static String getConnectivityStatusString(Context context) {
        int conn = networkDetect.getConnectivityStatus(context);
        String status = null;
        if (conn == networkDetect.TYPE_WIFI) {
            status = "Wifi enabled";
            Toast.makeText(context, status, Toast.LENGTH_LONG).show();
        } else if (conn == networkDetect.TYPE_MOBILE) {
            status = "Mobile data enabled";
            Toast.makeText(context,status,Toast.LENGTH_LONG).show();
        } else if (conn == networkDetect.TYPE_NOT_CONNECTED) {
            status = "Not connected to Internet";
            Toast.makeText(context,status,Toast.LENGTH_LONG).show();
        }
        return status;
    }
}
