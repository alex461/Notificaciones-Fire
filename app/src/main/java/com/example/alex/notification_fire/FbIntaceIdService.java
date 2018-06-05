package com.example.alex.notification_fire;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FbIntaceIdService extends FirebaseInstanceIdService {
    private static final String TAG ="AlexIdService" ;

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.w(TAG,"tokenRefresh"+token);

    }
}
