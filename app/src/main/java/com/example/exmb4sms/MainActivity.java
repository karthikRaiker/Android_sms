package com.example.exmb4sms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numet,msget;
    Button send,cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numet = findViewById(R.id.number);
        msget = findViewById(R.id.msg);
        send = findViewById(R.id.send);
        cancel = findViewById(R.id.cancel);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = numet.getText().toString();
                String msg = msget.getText().toString();
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(num, null,msg, null,null);
                    Toast.makeText(getApplicationContext(), "sms sent successfully",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(), "sms not sent", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
