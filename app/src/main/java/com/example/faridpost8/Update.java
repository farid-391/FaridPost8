package com.example.faridpost8;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText nomor, nama, alamat, waktu, fasilitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        dbHelper = new DataHelper(this);
        nomor = (EditText) findViewById(R.id.update_nocab);
        nama = (EditText) findViewById(R.id.update_namacab);
        alamat = (EditText) findViewById(R.id.update_alamatcab);
        waktu = (EditText) findViewById(R.id.update_waktu);
        fasilitas = (EditText) findViewById(R.id.update_fasilitas);
        btn1 = (Button) findViewById(R.id.btn_update_save);
        btn2 = (Button) findViewById(R.id.btn_update_back);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM cabang WHERE nama = '" +
        getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
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
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update cabang set nama='"+
                                nama.getText().toString() +"', alamat='" +
                                alamat.getText().toString()+"', waktu='"+
                                waktu.getText().toString() +"', fasilitas='" +
                                fasilitas.getText().toString() + "' where no='" +
                        nomor.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Data Berhasil Diupdate", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }
}