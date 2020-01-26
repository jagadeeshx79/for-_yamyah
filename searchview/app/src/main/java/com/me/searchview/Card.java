package com.me.searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Card extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    TextView tv,tvnum,tvname,tvcvv;
    String pp;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        ed1 =(EditText) findViewById(R.id.num);
        ed2 =(EditText) findViewById(R.id.date);
        ed3 =(EditText) findViewById(R.id.cvv);
        tv=(TextView) findViewById(R.id.tv);
        tvnum =(TextView) findViewById(R.id.tvnum);
        tvname=(TextView) findViewById(R.id.tvname);
        tvcvv= (TextView) findViewById(R.id.tvcvv);

        Intent intent = getIntent();
        pp=intent.getStringExtra("pri");

        tv.setText("Pay : "+pp);
        tvname.setText("enter your card details ");
        tvnum.setText("validity date");
        tvcvv.setText("CVV");
        btn =(Button) findViewById(R.id.b);
        btn.setText("proceed");

    }
}
