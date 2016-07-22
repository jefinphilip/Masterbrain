package com.example.clement.masterbrain;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by CLemENt on 4/11/2016.
 */
public class navigator extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);
        Toolbar toolbar =(Toolbar)findViewById(R.id.tooolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout=(DrawerLayout)findViewById(R.id.navigation_dryr);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView= (NavigationView)findViewById(R.id.navigation_View);
        navigationView.setNavigationItemSelectedListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);


        ReadRss readRss = new ReadRss(this,recyclerView);
        readRss.execute();



    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

         Integer i= item.getItemId();

        switch(i) {


            case R.id.facebook:

                Toast.makeText(this, "Facebook is selected", Toast.LENGTH_LONG).show();
                return true;


            case R.id.gplus:

                Toast.makeText(this, "google plus is selected", Toast.LENGTH_LONG).show();
                return true;

            case R.id.Instagram:

                Toast.makeText(this, "Instagram is selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.Exit:

                Toast.makeText(this, "App Exiting..... ", Toast.LENGTH_LONG).show();

                Finish();

                return true;
           }

        return false;
    }

    private void Finish() {
        finish();
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

       // if(actionBarDrawerToggle.onOptionsItemSelected(item))
            //return true;
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id) {


            case R.id.rss:

                Toast.makeText(this, "RSS FEED is selected", Toast.LENGTH_LONG).show();
                return true;


            case R.id.youtube:

                Toast.makeText(this, "upload manager is selected", Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_settings:

                Toast.makeText(this, "Settings is selected", Toast.LENGTH_LONG).show();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
