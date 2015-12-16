package com.example.vinson_chen.week5_app;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Vinson_Chen on 2015/12/16.
 */
public class Fragment_InternalStorage extends Fragment implements View.OnClickListener {
    @Override
    public void onClick(View v) {

        if(v.getId() == button_is_save.getId()){
            write_file(name_file);
            write_file(phone_file);
        }
    }

    LinearLayout ll;
    String is_name,is_phone,name_file = "is_name.txt", phone_file = "is_phone.txt";
    EditText edittext_is_name,edittext_is_phone;
    Button button_is_save;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.layout_fragment_is, container, false);
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

        edittext_is_name = (EditText) getActivity().findViewById(R.id.editText_is_name);
        edittext_is_phone = (EditText) getActivity().findViewById(R.id.editText_is_phone);
        button_is_save = (Button)getActivity().findViewById(R.id.button_is_save);

        initialUI();
    }

    @Override
    public void onPause(){
        super.onPause();

        write_file(name_file);
        write_file(phone_file);

    }

    private void initialUI() {

        is_name = read_file(name_file);
        is_phone = read_file(phone_file);

        if(!is_name.equals("")){
            edittext_is_name.setText(is_name, TextView.BufferType.EDITABLE);
        }
        if(!is_phone.equals("")){
            edittext_is_phone.setText(is_phone, TextView.BufferType.EDITABLE);
        }

    }

    private void creat_file(String filename){

        File file = new File(getActivity().getFilesDir(), filename);

        FileOutputStream outputStream;

        try {
            outputStream = new FileOutputStream(getActivity().getFilesDir()+filename);
            Log.d("Vinson", "Create "+getActivity().getFilesDir().toString());
            if(filename.equals(name_file))
                outputStream.write(edittext_is_name.getText().toString().getBytes());
            else if (filename.equals(phone_file))
                outputStream.write(edittext_is_phone.getText().toString().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String read_file(String filename){

        FileInputStream inputStream;

        try {
            byte buf[] = new byte[32];
            int bufSize;
            inputStream = new FileInputStream(getActivity().getFilesDir()+filename);
            bufSize = inputStream.read(buf);
            inputStream.close();
            return new String(buf, 0, bufSize);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private void write_file(String filename){

        FileOutputStream outputStream;

        try {
            outputStream = new FileOutputStream(getActivity().getFilesDir()+filename);
            Log.d("Vinson","Write "+getActivity().getFilesDir().toString());
            if(filename.equals(name_file))
                outputStream.write(edittext_is_name.getText().toString().getBytes());
            else if (filename.equals(phone_file))
                outputStream.write(edittext_is_phone.getText().toString().getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            creat_file(filename);
        }

    }

}
