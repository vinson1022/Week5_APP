package com.example.vinson_chen.week5_app;

import android.app.Fragment;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Vinson_Chen on 2015/12/16.
 */
public class Fragment_SQL extends Fragment implements View.OnClickListener {
    @Override
    public void onClick(View v) {

        if(v.getId() == button_sql_save.getId()){
            save_data();
        }
    }

    LinearLayout ll;
    String sql_name,sql_phone;
    EditText edittext_sql_name,edittext_sql_phone;
    Button button_sql_save;
    private SQLliteHelper SQLH = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.layout_fragment_sql, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        SQLH = new SQLliteHelper(getActivity());

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
        button_sql_save.setOnClickListener(this);

        initialUI();
    }

    @Override
    public void onPause(){
        super.onPause();

        save_data();
    }

    private void initialUI() {

//        Cursor results = getBiggestInTheColumn();
        Cursor results = SQLH.getWritableDatabase().query(
                SQLliteHelper._TableName, null, null, null, null, null, null, null);
        results.moveToLast();
        sql_name = results.getString(1);
        sql_phone = results.getString(2);
        if(!sql_name.equals("")){
            edittext_sql_name.setText(sql_name, TextView.BufferType.EDITABLE);
        }
        if(!sql_phone.equals("")){
            edittext_sql_phone.setText(sql_phone, TextView.BufferType.EDITABLE);
        }

    }

    private void save_data(){
        SQLiteDatabase db = SQLH.getWritableDatabase();
        ContentValues values = new ContentValues();
        if(edittext_sql_name.getText().equals("")){
            Toast.makeText(getActivity(),"Name can't be null",Toast.LENGTH_LONG);
            return;
        }
        values.put("_NAME", edittext_sql_name.getText().toString());
        values.put("_PHONE", edittext_sql_phone.getText().toString());
        db.insert(SQLliteHelper._TableName, null, values);
    }

    public Cursor getBiggestInTheColumn() {
        SQLiteDatabase db = SQLH.getReadableDatabase();
        return db.rawQuery("SELECT MAX(_id) FROM " + SQLliteHelper._TableName, null);
    }

}
