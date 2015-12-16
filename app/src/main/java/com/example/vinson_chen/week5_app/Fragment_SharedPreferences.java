package com.example.vinson_chen.week5_app;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
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
public class Fragment_SharedPreferences extends Fragment {

    LinearLayout ll;
    String sp_name,sp_phone;
    EditText edittext_sp_name,edittext_sp_phone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.layout_fragment_sp,container, false);

        return inflater.inflate(R.layout.layout_fragment_sp, container, false);
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

        edittext_sp_name = (EditText) getActivity().findViewById(R.id.editText_sp_name);
        edittext_sp_phone = (EditText) getActivity().findViewById(R.id.editText_sp_phone);

        initialUI();
    }

    @Override
    public void onPause(){
        super.onPause();

        SharedPreferences sharedPref = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.data_sp_name), edittext_sp_name.getText().toString());
        editor.putString(getString(R.string.data_sp_phone),edittext_sp_phone.getText().toString());
        editor.commit();

    }

    private void initialUI() {

        SharedPreferences sharedPref = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        sp_name = sharedPref.getString(getString(R.string.data_sp_name), "");
        sp_phone = sharedPref.getString(getString(R.string.data_sp_phone), "");
        if(!sp_name.equals("")){
            edittext_sp_name.setText(sp_name, TextView.BufferType.EDITABLE);
        }
        if(!sp_phone.equals("")){
            edittext_sp_phone.setText(sp_phone, TextView.BufferType.EDITABLE);
        }

    }

}
