package org.lastresponders.weatherundergroundapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import org.lastresponders.weatherundergroundapp.asynctask.FetchCurrentCondition;
import org.lastresponders.weatherundergroundapp.asynctask.FetchHourlyConditions;
import org.lastresponders.weatherundergroundapp.asynctask.FetchThreeDayConditions;
import org.lastresponders.weatherundergroundapp.view.CurrentTabFragment;
import org.lastresponders.weatherundergroundapp.view.HourlyTabFragment;
import org.lastresponders.weatherundergroundapp.view.OnTaskCompleted;
import org.lastresponders.weatherundergroundapp.view.ThreeDayTabFragment;

public class MainActivity extends ActionBarActivity implements ActionBar.TabListener , OnTaskCompleted {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ApplicationState state = ApplicationState.getInstance();
    private FragmentTabHost mTabHost;


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","OnResume");
        if(state.getRefresh() ) {
            Log.d("MainActivity","OnResume:refresh");
            fetchData();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up tabs
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        TabHost.TabSpec spec = mTabHost.newTabSpec("Current").setIndicator("Current");
        mTabHost.addTab(spec,CurrentTabFragment.class, null);
        spec = mTabHost.newTabSpec("ThreeDay").setIndicator("Three Day");
        mTabHost.addTab(spec, ThreeDayTabFragment.class, null);
        spec = mTabHost.newTabSpec("Hourly").setIndicator("Hourly");
        mTabHost.addTab(spec, HourlyTabFragment.class, null);

        //drawerlayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        String[] labels = {"update zipcode"};
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item,
                labels));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        //set up dialog
        final Context context = this;
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_main);
        dialog.setTitle("zipcode");

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButton);
        dialogButton.setText("SUBMIT");

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit=(EditText)dialog.findViewById(R.id.zipCodeEditText);
                String zipCode=edit.getText().toString();

                if(zipCode!=null) {
                    ApplicationState.getInstance().setZipCode(zipCode);
                    ((MainActivity) context).fetchData();
                    dialog.dismiss();
                }
            }
        });

        dialog.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Log.d("MainActivity","actionbar:settings");
            //another popup
            return true;
        } else if (id == R.id.action_refresh) {
            Log.d("MainActivity","actionbar:refresh");
            fetchData ();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        Log.d("MainActivity","onTabSelected");
        //mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        Log.d("MainActivity","onTabUnselected");
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        Log.d("MainActivity","onTabReselected");
    }

    @Override
    public void populateCurrentConditions() {
        Log.d("MainActivity","populateCurrentConditions");
        CurrentTabFragment frag =  (CurrentTabFragment)getSupportFragmentManager().findFragmentByTag("Current");
        if(frag!=null) {
            frag.populate();
        }
    }

    @Override
    public void populateHourlyForecast() {
        Log.d("MainActivity","populateHourlyForecast");
        HourlyTabFragment frag =  (HourlyTabFragment)getSupportFragmentManager().findFragmentByTag("Hourly");
        if(frag!=null) {
            frag.populate();
        }
    }

    @Override
    public void populateThreeDayForecast() {
        Log.d("MainActivity","populateThreeDayForecast");
        ThreeDayTabFragment frag =  (ThreeDayTabFragment)getSupportFragmentManager().findFragmentByTag("ThreeDay");
        if(frag!=null) {
            frag.populate();
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        public DrawerItemClickListener() {
        }

        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            if(position == 0) {
                Intent intent = new Intent(view.getContext(), SettingActivity.class);
                startActivity(intent);
                mDrawerLayout.closeDrawer(mDrawerList);
            }
        }
    }

    void fetchData () {
        Log.d("MainActivity","fetchData");
        if (state.getZipCode() != null ) {
            FetchCurrentCondition task1 = new FetchCurrentCondition(this);
            task1.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, state.getZipCode());

            FetchThreeDayConditions task2 = new FetchThreeDayConditions(this);
            task2.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, state.getZipCode());

            FetchHourlyConditions task3 = new FetchHourlyConditions(this);
            task3.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, state.getZipCode());

            state.setRefresh(false);
        }
    }
}
