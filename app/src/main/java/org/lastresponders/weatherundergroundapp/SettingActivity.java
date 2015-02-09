package org.lastresponders.weatherundergroundapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by sjan on 2/8/2015.
 */
public class SettingActivity extends Activity {
    EditText editText = null;
    ApplicationState state = ApplicationState.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_layout);

        editText=(EditText)this.findViewById(R.id.zipCodeEditText);
        String zip = state.getZipCode();
        if(zip!=null) {
            editText.setText(zip);
        }
    }

    public void methodCall(View view) {

        if(editText.getText()!=null) {
            String zipCode=editText.getText().toString();
            state.setZipCode(zipCode);
            state.setRefresh(true);
            state.setRefreshTime(Calendar.getInstance().getTime());
            finish();
        }
    }
}
