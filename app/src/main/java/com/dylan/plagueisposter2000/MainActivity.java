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
        EditText[] messages = new EditText[8];
        messages[0] = (EditText) findViewById(R.id.edit_message1);
        messages[1] = (EditText) findViewById(R.id.edit_message2);
        messages[2] = (EditText) findViewById(R.id.edit_message3);
        messages[3] = (EditText) findViewById(R.id.edit_message4);
        messages[4] = (EditText) findViewById(R.id.edit_message5);
        messages[5] = (EditText) findViewById(R.id.edit_message6);
        messages[6] = (EditText) findViewById(R.id.edit_message7);
        messages[7] = (EditText) findViewById(R.id.edit_message8);

        String[] defaults = {"Plagueis", "wise", "Sith", "midi-chorians", "life", "Dark Side", "dying", "his apprentice"};
        String message="";
        for (int i=0; i<messages.length; i++)
        {
            if (i!=0)
            {
                message+="#";
            }
            if (messages[i].getText().toString().equals(""))
            {
                message+=defaults[i];
            }
            else
            {
                message+=messages[i].getText().toString();
            }
        }

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
