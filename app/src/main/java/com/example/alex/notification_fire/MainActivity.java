package com.example.alex.notification_fire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity";
    private static final String KEY_DESCOUNT ="key_descount";
    private TextView textView1;
    private Button subcribeAndroid , subcribeFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.descountMessage);
        subcribeAndroid=findViewById(R.id.btnSubcribeAndorid);
        subcribeFirebase=findViewById(R.id.btnSubcribefirebase);

        textView1.setVisibility(View.GONE);

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.w(TAG,"token"+token);

        if(getIntent().getExtras() != null){
            textView1.setVisibility(View.VISIBLE);
            String descount = getIntent().getExtras().getString(KEY_DESCOUNT);
           textView1.append(descount);
        }
    }


    public void subcribeAndroid(View view){
        FirebaseMessaging.getInstance().subscribeToTopic("Android");
        Toast.makeText(this, "estas subcrito a android", Toast.LENGTH_SHORT).show();
    }

    public void subcribeFirebase(View view){
        FirebaseMessaging.getInstance().subscribeToTopic("Firebase");
        Toast.makeText(this, "estas subcrito a firebase", Toast.LENGTH_SHORT).show();
    }


}
