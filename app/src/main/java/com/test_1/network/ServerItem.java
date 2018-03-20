package com.test_1.network;

import android.content.Context;

import com.android.volley.Request;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by admin on 08/29/2017.
 */

public class ServerItem {

//    Map<String, String> header;

    String header;
    Map<String, String> params;

    String URL, TAG;
    Context context;
    int method;

    OnServerListener listener;

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }

    public OnServerListener getListener() {
        return listener;
    }

    public void setListener(OnServerListener listener) {
        this.listener = listener;
    }

//    public Map<String, String> getHeader() {
//        return header;
//    }
//
//    public void setHeader(Map<String, String> header) {
//        this.header = header;
//    }


//    public JSONObject getHeader() {
//        return header;
//    }
//
//    public void setHeader(JSONObject header) {
//        this.header = header;
//    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }
}
