package com.ketanchoyal.contacts;

import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Main2Activity extends AppCompatActivity {

    EditText message_field;
    TextView contact_name, contact_number;

    ImageView back;

    CircleImageView contact_pic, send_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        contact_name = findViewById(R.id.contact_name);
        contact_number = findViewById(R.id.contact_number);
        message_field = findViewById(R.id.message_field);

        send_btn = findViewById(R.id.send_btn);
        contact_pic = findViewById(R.id.contact_pic);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        contact_number.setText(getIntent().getStringExtra("number"));
        contact_name.setText(getIntent().getStringExtra("name"));

        if(MyAdapter.image != null)
        {
            contact_pic.setImageBitmap(MyAdapter.image);
        }

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendSms(contact_name.getText().toString(),message_field.getText().toString());

            }
        });
    }

    void sendSms(String number,String sms)
    {
        try
        {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number, null, sms, null, null);
            Toast.makeText(getApplicationContext(),"SMS Sent",Toast.LENGTH_LONG).show();

        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),"Try again",Toast.LENGTH_LONG).show();
        }

    }

}
