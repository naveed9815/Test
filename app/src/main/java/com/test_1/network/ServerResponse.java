package com.test_1.network;

import org.json.JSONObject;

/**
 * Created by admin on 08/29/2017.
 */

public class ServerResponse {

    String response;
    String TAG;

    public ServerResponse(String response, String tag) {
        setResponse(response);
        setTAG(tag);
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }
}
