package com.michealbadu.rssweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LocationPage extends AppCompatActivity {

    Button button, glasgow, london, newYork, mauritius, oman, bangladesh, accra;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_page);

        editText = findViewById(R.id.idParser);
        button = findViewById(R.id.btnSubmitRequest);
        glasgow = findViewById(R.id.btnGetGlasgowData);
        london = findViewById(R.id.btnGetLondonData);
        newYork = findViewById(R.id.btnGetNewYorkData);
        oman = findViewById(R.id.btnGetOmanData);
        mauritius = findViewById(R.id.btnGetMauritiusData);
        bangladesh = findViewById(R.id.btnGetBangladeshData);
        accra = findViewById(R.id.btnGetAccraData);

        // Main button onclick
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get the element and parse an intent filter to the next page

                String valueFromInput = editText.getText().toString().trim();

                if (valueFromInput.length() > 0){

                    Intent i = new Intent(view.getContext(), MainActivity.class);
                    i.putExtra("locationID", valueFromInput);
                    startActivity(i);
                } else {
                    Toast.makeText(
                            getApplicationContext(),
                            "Please Enter An Id In The Location Box",
                            Toast.LENGTH_LONG).show();
                }

            }
        });


        // glasgow
        glasgow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAction(view, "2648579");
            }
        });

        // glasgow
        glasgow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAction(view, "2648579");
            }
        });
        // glasgow
        glasgow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAction(view, "2648579");
            }
        });

        // london
        london.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAction(view, "2643743");
            }
        });
        // newYork
        newYork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAction(view, "5128581");
            }
        });
        // Oman
        oman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAction(view, "287286");
            }
        });
        // Mauritius
        mauritius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAction(view, "934154");
            }
        });
        // Bangladesh
        bangladesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAction(view, "1185241");
            }
        });
        // Accra
        accra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAction(view, "2306104");
            }
        });



    }

    public void doAction (View view, String locationId){
        Intent i = new Intent(view.getContext(), MainActivity.class);
        i.putExtra("locationID", locationId);
        startActivity(i);
    }
}
