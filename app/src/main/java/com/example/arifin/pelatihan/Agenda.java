package com.example.arifin.pelatihan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Agenda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        ImageView paperNote = (ImageView) findViewById(R.id.paper_note);
        paperNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Agenda.this, ShareActivity.class);
                startActivity(intent);
            }
        });
    }

    // adding slide in/out page transition when moving back from Agenda to TrainingDetails
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }
}
