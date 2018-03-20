package com.test_1.main;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.test_1.network.TimePeriod;

import java.util.ArrayList;

/**
 * Created by ADMIN on 3/19/2018.
 */

public class MainPresenterImp implements MainPresenter {


    @Override
    public void onSubmit(String arr[]){

        AlarmManager manager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, TimePeriod.class);
        intent.putExtra("data" , arr);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
                1000 * Integer.parseInt(arr[4])*60 , pendingIntent);
   }

    Context context;

    public MainPresenterImp(Context context) {
        this.context = context;
    }
}
