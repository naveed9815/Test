package com.test_1.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by admin on 08/29/2017.
 */

public class ServerSingleton {

    private static ServerSingleton instance;
    private RequestQueue queue;
    private ServerSingleton(Context context) {
        queue = Volley.newRequestQueue(context.getApplicationContext());
    }


    private RequestQueue getRequestQueue() {
        this.queue.getCache().clear();
        return this.queue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }



    public static  ServerSingleton getInstance(Context context) {
        if (instance == null) {
            instance = new ServerSingleton(context);
        }
        return instance;
    }


}
