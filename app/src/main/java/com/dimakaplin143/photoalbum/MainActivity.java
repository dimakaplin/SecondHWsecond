package com.dimakaplin143.photoalbum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int activityNumber;
    private final String LOG = "Lifecycle";
    public static int count = 0;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logging("onCreate");
        setContentView(R.layout.activity_main);

        final int min = 1;
        final int max = 100;

        if(activityNumber == 0) {
            activityNumber = rand.nextInt(100);
        }


        Button next = (Button) findViewById(R.id.next);
        Button back = (Button) findViewById(R.id.back);
        TextView number = (TextView) findViewById(R.id.numb);

        String s = String.format("%d", rnd(min, max));

        number.setText(s);

        next.setOnClickListener(v-> {
            count++;
            Intent intent = new Intent(MainActivity.this,
                    MainActivity.class);

            startActivity(intent);
        });

        back.setOnClickListener(v-> {
            if(count > 0) {
                count--;
                finish();
            }
            else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Если вы закорете это окно то всему придет конец", Toast.LENGTH_LONG);
                toast.show();
            }

        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        logging("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logging("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logging("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logging("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logging("onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logging("onRestart");
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        logging("onPostCreate");
    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    private void logging(String message) {
        Log.d(LOG, message + ": " + activityNumber);
    }




}
