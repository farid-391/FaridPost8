package com.example.faridpost8;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lihat extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1;
    TextView nomor, nama, alamat, waktu, fasilitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        dbHelper = new DataHelper(this);
        nomor = (TextView) findViewById(R.id.lihat_nocab);
        nama = (TextView) findViewById(R.id.lihat_namacab);
        alamat = (TextView) findViewById(R.id.lihat_alamatcab);
        waktu = (TextView) findViewById(R.id.lihat_waktu);
        fasilitas = (TextView) findViewById(R.id.lihat_fasilitas);
        btn1 = (Button) findViewById(R.id.btn_lihat_back);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM cabang WHERE nama = '" +
        getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            nomor.setText(cursor.getString(0).toString());
            nama.setText(cursor.getString(1).toString());
            alamat.setText(cursor.getString(2).toString());
            waktu.setText(cursor.getString(3).toString());
            fasilitas.setText(cursor.getString(4).toString());
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }
}