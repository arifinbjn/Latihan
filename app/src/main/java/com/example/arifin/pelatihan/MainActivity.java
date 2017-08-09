package com.example.arifin.pelatihan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    Button buttonoke;
    EditText editnama, editemail, editalamat, editsekolah;
    EditText hasilnama, hasilemail, hasilalamat, hasilsekolah, hasiljurusan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//atur supaya layout sesuai dengan activity_main
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ada di Start sekarang");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: kembali aktif resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: app di pause dulu");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ada di tahap Stop berhenti dulu");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onResrat: app jalan kembali Restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: sudah berakhir ter-Destroy");

    }
}
