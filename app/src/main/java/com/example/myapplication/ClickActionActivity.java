package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
public class ClickActionActivity extends AppCompatActivity {
    TextView txtDisplayNameAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_action);
        txtDisplayNameAction = findViewById(R.id.txtDisplayNameAction);
        Intent intent = getIntent();
        //String name = intent.getExtras().getString("username");
        //String username = intent.getStringExtra("username");
        //txtDisplayNameAction.setText("Hello, "+username);
                      //type casting
        Student std = (Student)intent.getExtras().getSerializable("student");
        String st ="ID: "+std.getId()+"\n"+
                    "Name: "+std.getName()+"\n"+
                    "Email: "+std.getEmail()+"\n";
        txtDisplayNameAction.setText(st);
    }
}