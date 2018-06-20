package com.acadview.shared;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView name,cls,age;
    String username,userclass,userage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //get the reference
        name = findViewById(R.id.batman);
        cls = findViewById(R.id.harward);
        age = findViewById(R.id.superman);

        //get sharedpreferenve

        SharedPreferences sp = getSharedPreferences("data",MODE_PRIVATE);

        username = sp.getString("name","none");
        userclass = sp.getString("class","none");
        userage = sp.getString("age","none");

        //set the values to textView
        name.setText(username);
        cls.setText(userclass);
        age.setText(userage);


    }
}
