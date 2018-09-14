package com.example.dabuff.objectdetectionadvanced.appdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.dabuff.objectdetectionadvanced.navigation.NavigationDrawerFragment;
import com.example.dabuff.objectdetectionadvanced.objectdetect.ObjectDetect;
import com.example.dabuff.objectdetectionadvanced.voicedetect.voicedemo.VoiceDetect;
import com.example.dabuff.objectdetectionadvanced.waitingfor.Waiting;

public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    public static final String LOG_TAG = "ObjectDetect";
    private NavigationDrawerFragment navigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence title;

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(title);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        title = getTitle();

        //Set up the drawer
        navigationDrawerFragment.setUp(R.id.navigation_drawer,(DrawerLayout)findViewById(R.id.drawer_layout));
        //drawer.closeDrawers();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        //update the main content by replacing fragments
        //drawer.closeDrawers();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();


        switch (position){
            case 0: fragmentTransaction.replace(R.id.container, new Index()); break;
            case 1: fragmentTransaction.replace(R.id.container, new ObjectDetect());break;
            case 2: fragmentTransaction.replace(R.id.container, new VoiceDetect());break;
            case 3: fragmentTransaction.replace(R.id.container, new Waiting());break;
        }

        fragmentTransaction.commit();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        if (!navigationDrawerFragment.isDrawerOpen()){
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        return super.onOptionsItemSelected(item);
    }
}
