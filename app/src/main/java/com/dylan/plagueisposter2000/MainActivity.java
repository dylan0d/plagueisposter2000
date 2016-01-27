package com.dylan.plagueisposter2000;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dylan.PlageuisPoster2000.DisplayMessageActivity;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText part1 = (EditText) findViewById(R.id.edit_message1);
        EditText part2 = (EditText) findViewById(R.id.edit_message2);
        EditText part3 = (EditText) findViewById(R.id.edit_message3);
        EditText part4 = (EditText) findViewById(R.id.edit_message4);
        EditText part5 = (EditText) findViewById(R.id.edit_message5);
        EditText part6 = (EditText) findViewById(R.id.edit_message6);
        String message = part1.getText().toString();
        message += "#"+part2.getText().toString();
        message += "#"+part3.getText().toString();
        message += "#"+part4.getText().toString();
        message += "#"+part5.getText().toString();
        message += "#"+part6.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
