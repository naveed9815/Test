package com.test_1.network;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by admin on 04/12/2017.
 */

public class AvailNetWork {

    public static boolean isNetWorkAvailable(Context context) {
        final ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return connectivityManager.getActiveNetworkInfo() != null
                && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
