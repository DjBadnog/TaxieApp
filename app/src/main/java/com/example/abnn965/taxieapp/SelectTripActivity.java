package com.example.abnn965.taxieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SelectTripActivity extends AppCompatActivity {

    private Spinner departLocationSpinner;
    private Spinner dropOffLocationSpinner;
    ArrayAdapter<CharSequence> departAdapter;
    ArrayAdapter<CharSequence>dropAdapter;

    private TextView tvDepart;
    private TextView tvDropOff;
    private TextView tvPrice;
    private TextView tvDuartion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_trip);

        departLocationSpinner = (Spinner) findViewById(R.id.departLocationSpinner);
        dropOffLocationSpinner = (Spinner) findViewById(R.id.dropOffLocationSpinner);
        tvDepart = (TextView) findViewById(R.id.tvDepart);
        tvDropOff = (TextView)findViewById(R.id.tvDropOff);
        tvPrice = (TextView) findViewById(R.id.tvPrice);
        tvDuartion = (TextView) findViewById(R.id.tvDuration);

        departAdapter = ArrayAdapter.createFromResource(this, R.array.depart_Locations, android.R.layout.simple_spinner_item);
        departAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departLocationSpinner.setAdapter(departAdapter);
        departLocationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(), "You selected " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        dropAdapter = ArrayAdapter.createFromResource(this, R.array.dropOff_Location, android.R.layout.simple_spinner_item);
        dropAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropOffLocationSpinner.setAdapter(dropAdapter);
        dropOffLocationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(), "You selected " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void tripDetails(View view){

        tvDepart.setText(departLocationSpinner.getSelectedItem().toString());
        tvDropOff.setText(dropOffLocationSpinner.getSelectedItem().toString());

        if (tvDepart.getText().toString().equals("Johannesburg") && tvDropOff.getText().toString().equals("Pretoria")) {
            tvDuartion.setText("40 Minutes");
            tvPrice.setText("R 35");
        }
        else if (tvDepart.getText().toString().equals("Johannesburg") && tvDropOff.getText().toString().equals("Nelspruit")){
            tvDuartion.setText("3 Hours");
            tvPrice.setText("R 200");
        }
        else if (tvDepart.getText().toString().equals("Pretoria") && tvDropOff.getText().toString().equals("Johannesburg")){
            tvDuartion.setText("40 Minutes");
            tvPrice.setText("R 35");
        }
        else if (tvDepart.getText().toString().equals("Nelspruit") && tvDropOff.getText().toString().equals("Johannesburg")){
            tvDuartion.setText("3 Hours");
            tvPrice.setText("R 200");
        }

    }

    public void onClicknewActivity(View view){
        Intent newIntent = new Intent(SelectTripActivity.this, TripDetailsActivity.class);
        startActivity(newIntent);
    }

}
