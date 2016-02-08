package com.dylan.PlageuisPoster2000;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dylan.plagueisposter2000.MainActivity;
import com.dylan.plagueisposter2000.R;

public class DisplayMessageActivity extends AppCompatActivity {
    private ShareActionProvider mShareActionProvider;
    Intent mShareIntent = new Intent();
    private String finishedPasta="";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);


        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextIsSelectable(true);
        textView.setTextSize(20);
        String[] str = message.split("#", 8);
        finishedPasta="Did you ever hear the Tragedy of Darth "+str[0]+" the "+str[1]+
                         "? I thought not. It's not a story the Jedi would tell you. It's a "+str[2]+" legend. "+
                         "Darth "+str[0]+" was a dark lord of the "+str[2]+" so powerful and so wise, he could use the "+str[3]+
                         " to influence the midi-chlorians to create... "+str[4]+ ". He had such a knowledge of the "+str[5]+
                         ", he could even keep the ones he cared about...from "+str[6]+
                         ". He became so powerful, the only thing he was afraid of was losing his power... which, eventually of course, he did."+
                         " Unfortunately, he taught "+str[7]+" everything he knew. Then "+str[7]+ " killed him in his sleep. Ironic." +
                         " He could save others from "+str[6]+"... but not himself.";

        textView.setText(finishedPasta);
        mShareIntent.setAction(Intent.ACTION_SEND);
        mShareIntent.setType("text/plain");
        mShareIntent.putExtra(Intent.EXTRA_TEXT, finishedPasta);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu resource file.
        getMenuInflater().inflate(R.menu.menu, menu);
        // Locate MenuItem with ShareActionProvider
        MenuItem item = menu.findItem(R.id.menu_item_share);
        // Fetch and store ShareActionProvider
        mShareActionProvider = (ShareActionProvider)  MenuItemCompat.getActionProvider(item);
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(mShareIntent);
        }
        // Return true to display menu
        return true;
    }


}

/*Palpatine: Did you ever hear the Tragedy of Darth PLAGUEIS the WISE?
Anakin:      No.
Palpatine:   I thought not. It's not a story the Jedi would tell you. It's a SITH legend. Darth PLAGUEIS was a Dark Lord of the Sith
             so powerful and so wise, he could use the FORCE to influence the midi-chlorians to create...LIFE.
             He had such a knowledge of the Dark Side, he could even keep the ones he cared about...from dying.
Anakin:      He could actually...save people from death?
Palpatine:   The dark side of the Force is a pathway to many abilities some consider to be unnatural.
Anakin:      What happened to him?
Palpatine:   He became so powerful, the only thing he was afraid of was losing his power...which, eventually of course, he did.
             Unfortunately, he taught HIS APPRENTICE everything he knew. Then HIS APPRENTICE killed him in his sleep. Ironic.
             He could save others from death...but not himself.
Anakin:      Is it possible to learn this power?
Palpatine:   Not from a Jedi.*/
