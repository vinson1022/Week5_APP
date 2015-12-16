package com.example.vinson_chen.week5_app;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button_fragment_sp,button_fragment_is,button_fragment_sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setView();
        setListener();

        Fragment_SharedPreferences fragment = new Fragment_SharedPreferences();
        getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment).commit();

    }

    private void setListener() {

        button_fragment_sp.setOnClickListener(this);
        button_fragment_is.setOnClickListener(this);
        button_fragment_sql.setOnClickListener(this);

    }

    private void setView() {

        button_fragment_sp = (Button)findViewById(R.id.button_sp);
        button_fragment_is = (Button)findViewById(R.id.button_is);
        button_fragment_sql = (Button)findViewById(R.id.button_sql);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == button_fragment_sp.getId()){
            Fragment_SharedPreferences fragment = new Fragment_SharedPreferences();
            getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment).commit();
        }else if(v.getId() == button_fragment_is.getId()){
            Fragment_InternalStorage fragment = new Fragment_InternalStorage();
            getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment).commit();
        }else if(v.getId() == button_fragment_sql.getId()){
            Fragment_SQL fragment = new Fragment_SQL();
            getFragmentManager().beginTransaction().replace(R.id.fragment_content, fragment).commit();
        }
    }
}
