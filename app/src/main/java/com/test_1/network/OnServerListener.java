package com.test_1.network;


import com.android.volley.VolleyError;

/**
 * Created by admin on 03/23/2017.
 */

public interface OnServerListener {
    public void serverOnSuccess(ServerResponse response);
    public void serverOnFailure(VolleyError error);
}
