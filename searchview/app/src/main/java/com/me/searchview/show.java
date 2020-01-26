package com.me.searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class show extends AppCompatActivity {

    Button btn1;
    ImageView img;
    TextView t1,t2;
    String n,p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        t1=(TextView) findViewById(R.id.name1);
        t2=(TextView) findViewById(R.id.price);
        Intent intent = getIntent();
        n = intent.getStringExtra("name");
        p = intent.getStringExtra("price");
        t1.setText("Name : "+n);
        t2.setText("Price : Rs "+p);
        addListenerOnButton();
    }
    public void addListenerOnButton() {
        btn1 = (Button) findViewById(R.id.btn2);
        btn1.setText("Buy");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(getApplicationContext() , Card.class);
                intent.putExtra( "pri",p);
                startActivity(intent);
            }
        });
    }
}
