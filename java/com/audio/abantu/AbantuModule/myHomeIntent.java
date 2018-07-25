package com.audio.abantu.AbantuModule;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

public class myHomeIntent extends AppCompatActivity {

    private static DrawerLayout mDrawerLayout;
    private ListView myBookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle("Abantu Audio");
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        myBookList = (ListView) findViewById(R.id.mybooks);
        ArrayList<Card> cardbook_list = new ArrayList<Card>();

        cardbook_list.add(new Card("drawable://" + R.drawable.abantusample1, "Abantu Sample 1"));
        cardbook_list.add(new Card("drawable://" + R.drawable.abantusample4, "Abantu Sample 2"));
        cardbook_list.add(new Card("drawable://" + R.drawable.abantusample5, "Abantu Sample 3"));
        cardbook_list.add(new Card("drawable://" + R.drawable.abantusample4, "Abantu Sample 4"));
        cardbook_list.add(new Card("drawable://" + R.drawable.abantusample5, "Abantu Sample 5"));
        cardbook_list.add(new Card("drawable://" + R.drawable.abantusample1, "Abantu Sample 6"));
        cardbook_list.add(new Card("drawable://" + R.drawable.abantusample4, "Abantu Sample 7"));
        cardbook_list.add(new Card("drawable://" + R.drawable.abantusample5, "Abantu Sample 8"));
        cardbook_list.add(new Card("drawable://" + R.drawable.abantusample4, "Abantu Sample 9"));
        cardbook_list.add(new Card("drawable://" + R.drawable.abantusample5, "Abantu Sample 10"));

        CustomListAdapter adapter = new CustomListAdapter(this, R.layout.carditem, cardbook_list);
        myBookList.setAdapter(adapter);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        if(menuItem.getTitle() == "My Books"){
                            //mDrawerLayout = findViewById(R.id.bookdrawer);
                        }

                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
