package com.acadview.shared;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,cls,age ;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.email1);
        cls= findViewById(R.id.email2);
        age = findViewById(R.id.email3);

        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(name.getText().toString())) {
                    name.setError("enter your name");
                    return;
                }
                if(TextUtils.isEmpty(cls.getText().toString())) {
                    name.setError("enter your class");
                    return;
                }
                if(TextUtils.isEmpty(age.getText().toString())) {
                    name.setError("enter your age");
                    return;
                }

                String username,userclass,userage;
                username =name.getText().toString();
                userclass =cls.getText().toString();
                userage =age.getText().toString();

              //for entering data into sharedpreference

                //shared preference
                SharedPreferences  sp = getSharedPreferences("data",MODE_PRIVATE);

                //get the editor

                SharedPreferences.Editor editor = sp.edit();

                //adding values

                editor.putString("name",username);
                editor.putString("class",userclass);
                editor.putString("age",userage);

                //close editor

                editor.commit();

             //get the alert dialog

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Submit conformation");
                builder.setMessage("Are you sure to continue");

                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(intent);

                        finish();
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();


                if(TextUtils.isEmpty(name.getText().toString()))
                    name.setError("enter your");
                    return;







            }
        });




    }
}
