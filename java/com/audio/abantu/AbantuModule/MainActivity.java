package com.audio.abantu.AbantuModule;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
    private static int SPLASH_TIMEOUT = 4000;
    private static DrawerLayout mDrawerLayout;
    private ListView NavList;
    private ArrayList<CustomListAdapter> navArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sintent);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent = new Intent(MainActivity.this, myHomeIntent.class);
                startActivity(myIntent);
                finish();
            }
        }, SPLASH_TIMEOUT);

        /*mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavList = (ListView) findViewById(R.id.navlist);
        CustomListAdapter mDrawerListAdapter = new CustomListAdapter(MainActivity.this);
        NavList.setAdapter(mDrawerListAdapter);*/
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
