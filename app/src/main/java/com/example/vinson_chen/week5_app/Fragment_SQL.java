package com.example.vinson_chen.week5_app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Vinson_Chen on 2015/12/16.
 */
public class Fragment_SQL extends Fragment implements View.OnClickListener {
    @Override
    public void onClick(View v) {

    }

    LinearLayout ll;
    String sql_name,sql_phone;
    EditText edittext_sql_name,edittext_sql_phone;
    Button button_sql_save;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.layout_fragment_sql, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onStart(){
        super.onStart();

    }

    @Override
    public void onResume(){
        super.onResume();

        edittext_sql_name = (EditText) getActivity().findViewById(R.id.editText_sql_name);
        edittext_sql_phone = (EditText) getActivity().findViewById(R.id.editText_sql_phone);
        button_sql_save = (Button)getActivity().findViewById(R.id.button_sql_save);

        initialUI();
    }

    @Override
    public void onPause(){
        super.onPause();

        //TODO internal save

    }

    private void initialUI() {

        //TODO internal read
//        sp_name = sharedPref.getString(getString(R.string.data_sp_name), "");
//        sp_phone = sharedPref.getString(getString(R.string.data_sp_phone), "");
        if(!sql_name.equals("")){
            edittext_sql_name.setText(sql_name, TextView.BufferType.EDITABLE);
        }
        if(!sql_phone.equals("")){
            edittext_sql_phone.setText(sql_phone, TextView.BufferType.EDITABLE);
        }

    }

}
