package com.test_1.network;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by admin on 08/29/2017.
 */

public class ServerCall {

    private String TAG= ServerCall.class.getSimpleName();
    public ServerCall(final ServerItem item) {

        JsonObjectRequest request = new JsonObjectRequest(
                item.getMethod(),
                item.getURL()+item.getHeader(),null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        Log.d("HELLO", response.toString());
                        item.getListener().serverOnSuccess(new ServerResponse(response.toString(), item.getTAG()));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                item.getListener().serverOnFailure(error);
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                return item.getParams();
            }

        };

        ServerSingleton.getInstance(item.getContext()).addToRequestQueue(request);
    }

}
