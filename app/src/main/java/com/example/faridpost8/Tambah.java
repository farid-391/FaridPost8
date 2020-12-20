package com.example.faridpost8;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tambah extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button btn1, btn2;
    EditText nomor, nama, alamat, waktu, fasilitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        dbHelper = new DataHelper(this);
        nomor = (EditText) findViewById(R.id.tambah_nocab);
        nama = (EditText) findViewById(R.id.tambah_namacab);
        alamat = (EditText) findViewById(R.id.tambah_alamatcab);
        waktu = (EditText) findViewById(R.id.tambah_waktu);
        fasilitas = (EditText) findViewById(R.id.tambah_fasilitas);
        btn1 = (Button) findViewById(R.id.btn_tambah_save);
        btn2 = (Button) findViewById(R.id.btn_tambah_back);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into cabang(no, nama, alamat, waktu, fasilitas) values('" +
                        nomor.getText().toString()+"','"+
                        nama.getText().toString() +"','" +
                        alamat.getText().toString()+"','"+
                        waktu.getText().toString() +"','" +
                        fasilitas.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Data Berhasil Ditambahkan", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//            // Inflate the main; this adds items to the action bar if it is present.
//                getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
}