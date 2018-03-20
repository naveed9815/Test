package com.test_1.network;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.GsonBuilder;
import com.test_1.Example;
import com.test_1.R;
import com.test_1.main.MainActivity;

/**
 * Created by ADMIN on 3/19/2018.
 */

public class TimePeriod extends IntentService implements OnServerListener {

    Context context = this;
    public TimePeriod() {
        super(TimePeriod.class.getName());
    }

    String a[];
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        StringBuilder builder = new StringBuilder();
         a= intent.getStringArrayExtra("data");
        for (int i=0; i<4; i++){
            if (!TextUtils.equals(a[i],"")){
                builder.append(a[i]+",");
            }
        }

        ServerItem item = new ServerItem();
        item.setTAG("");
        item.setURL("https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=");
        item.setMethod(Request.Method.GET);
        item.setHeader(builder.toString());
        item.setParams(null);
        item.setContext(context);
        item.setListener(this);
        new ServerCall(item);
    }

    @Override
    public void serverOnSuccess(ServerResponse response) {

        Example example = new GsonBuilder().create()
                .fromJson(response.getResponse(), Example.class);

        Double total = example.getDOGE()+
                       example.getETC()+
                       example.getNXT()+
                       example.getXMR();

        if (Double.compare(total,Double.parseDouble(a[5]))>0){

            Intent intent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

            Notification notification  = new Notification.Builder(this)
                    .setContentTitle("Notification Test")
                    .setContentText("Subject")
                    .setSmallIcon(R.drawable.pencil)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true).build();

            NotificationManager manager = (NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);

            manager.notify(0, notification);
        }

    }

    @Override
    public void serverOnFailure(VolleyError error) {

    }

}
