package com.example.dslab.personal_bio;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /**
     * Creates the content view and toolbar, sets up the tab layout, and sets up a page adapter
     * to manage views in fragments. The user clicks a tab and navigates to the view fragment.
     *
     * @param savedInstanceState Saved instance.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);


        // Create an instance of the tab layout from the view.
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        // Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText("Personal Info"));
        tabLayout.addTab(tabLayout.newTab().setText("Education"));
        tabLayout.addTab(tabLayout.newTab().setText("Project Info"));
        // Set the tabs to fill the entire layout.
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


      final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
     final PagerAdapter adapter = new com.example.dslab.personal_bio.PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
       // Setting a listener for clicks.
       viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
            public void onTabSelected(TabLayout.Tab tab) { viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
           public void onTabReselected(TabLayout.Tab tab) {

          }
       });

    }

    /**
     * Inflates the options menu.
     *
     * @param menu_main Menu to inflate
     * @return Returns true if menu is inflated.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu_main) {
        getMenuInflater().inflate(R.menu.menu_main, menu_main);
        return true;
    }

    /**
     * Handles a click on the Settings item in the options menu.
     *
     * @param item  Item in options menu that was clicked.
     * @return Returns true if the item was Settings.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}