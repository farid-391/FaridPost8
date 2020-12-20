package com.example.faridpost8;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "cabangcoffe.db";
    private static int DATABASE_VERSION = 1;

    public DataHelper (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "create table cabang(no integer primary key, nama text null, alamat text null, waktu text null, fasilitas text null)";
        Log.d("Data", "onCreate"+ sql);
        db.execSQL(sql);
        sql = "INSERT INTO cabang (no, nama, alamat, waktu, fasilitas) VALUES ('1001', 'Farid Imogiri', 'Imgogiri Barat', '07:30-09.00', 'WIFI')";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2){
        // TODO Auto-generated method stub
    }
}
