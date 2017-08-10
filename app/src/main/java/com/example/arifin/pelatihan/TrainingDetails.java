package com.example.arifin.pelatihan;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.GregorianCalendar;


public class TrainingDetails extends AppCompatActivity {
    private TextView tpccMap, schedule, agenda, javaText;
    private Button buttondaftar;
    private ImageButton buttonmaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        tpccMap = (TextView) findViewById(R.id.tpcc_map);
        schedule = (TextView) findViewById(R.id.schedule);
        agenda = (TextView) findViewById(R.id.android_agenda);
        javaText = (TextView) findViewById(R.id.java_text);
        buttondaftar = (Button) findViewById(R.id.buttondaftar);
        buttonmaps = (ImageButton) findViewById(R.id.buttonmaps);

        tpccMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrainingDetails.this, Agenda.class);//harusnya MapsActivity
                startActivity(intent);
            }
        });

        schedule.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                Intent calIntent = new Intent(Intent.ACTION_INSERT);
                calIntent.setType("vnd.android.cursor.item/event");
                calIntent.putExtra(CalendarContract.Events.TITLE, "Android Developer Training");
                calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Telkom PCC");
                calIntent.putExtra(CalendarContract.Events.DESCRIPTION, "A 5-day series Dev Bootcamp");

                GregorianCalendar calDate = new GregorianCalendar(2016, 10, 31);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        calDate.getTimeInMillis());
                calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                        calDate.getTimeInMillis());

                startActivity(calIntent);
            }
        });

        try {
            agenda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), Agenda.class);
                    startActivity(intent);
                    // adding cross-fade effect page transition from TrainingDetails to Agenda
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                }
            });
        } catch (Exception e) {
            Toast.makeText(TrainingDetails.this, "Error " + e, Toast.LENGTH_LONG).show();
        }

        javaText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.udacity.com/learn/java"));
                startActivity(intent);
            }
        });
        buttondaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrainingDetails.this, MainActivity.class);
                startActivity(intent);
            }
        });
        buttonmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri geoLocation = Uri.parse("geo:0,0?q=-6.870563, 107.594126(TPCC Telkom)?z=23");
                showMap(geoLocation);

            }
        });
    }

    private void showMap(Uri geoLocation) {
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(geoLocation);
        if (mapIntent.resolveActivity(getPackageManager()) != null) startActivity(mapIntent);
    }
}
