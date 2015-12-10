package com.example.andrew.sunflower.groovy

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
import com.example.andrew.sunflower.R
import com.squareup.otto.Bus
import com.squareup.otto.Subscribe
import groovy.transform.CompileStatic

@CompileStatic
public class LoginActivity extends AppCompatActivity {
    @InjectView(R.id.testingview)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate savedInstanceState
        setContentView R.layout.activity_main
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar)
        setSupportActionBar toolbar
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab)
        fab.onClickListener = {}

        //View Injection
        SwissKnife.inject this
        SwissKnife.loadExtras this
        SwissKnife.restoreState this, savedInstanceState

        Bus bus = BusProvider.getInstance();

        bus.register this

        int i = 0;

        Thread.start {
            while (true) {
                Log.e("warning", currentThread().getName())
                i++
                BusProvider.getInstance().post("count: " + i)
                sleep(1000)
                if (i > 10) {
                    break
                }
            }
        }

        //BusProvider.startCount();
    }

    @Subscribe
    public void answerAvailable(String event) {
        textView.setText event
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

    public setExtras(Bundle bundle) {
        //do nothing heh
    }
}