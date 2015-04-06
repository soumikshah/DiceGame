package android.cs594.dicegame;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;


public class MainActivity extends ActionBarActivity {

    private FrameLayout frame1, frame2;
    private Button roll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll =(Button)findViewById(R.id.button);
        roll.setOnClickListener(new View.OnClickListener(){

        public void onClick(View v) {
            rollDice();
        }});
        frame1 = (FrameLayout)findViewById(R.id.dice1);
        frame2 = (FrameLayout)findViewById(R.id.dice2);
    }

    //get two random ints between 1 and 6
    public void rollDice(){
        int val1 = (int)(Math.random()*6)+1;
        int val2 = (int)(Math.random()*6)+1;
       setDie(val1,frame1);
        setDie(val2,frame2);
    }

    // set the appropriate pic for each die per int

    public void setDie(int value, FrameLayout layout){
        Drawable pic = null;
        switch(value){
            case 1:
                pic = getResources().getDrawable(R.drawable.die_face_1);
                break;

            case 2:
                pic = getResources().getDrawable(R.drawable.die_face_2);
                break;
            case 3:
                pic = getResources().getDrawable(R.drawable.die_face_3);
                break;
            case 4:
                pic = getResources().getDrawable(R.drawable.die_face_4);
                break;
            case 5:
                pic = getResources().getDrawable(R.drawable.die_face_5);
                break;
            case 6:
                pic = getResources().getDrawable(R.drawable.die_face_6);
                break;
        }
        layout.setBackground(pic);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
