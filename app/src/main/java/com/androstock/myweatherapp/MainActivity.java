package com.androstock.myweatherapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView cityField, currentTemperatureField, updatedField, altitudeField;

    public double altitude;
    public double longitude;
    public double latitude;

    public String longi;
    public String lati;
    public String alti;

    MyDBHandler dbHandler;
    TextView buckysText;

    static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        cityField = (TextView)findViewById(R.id.city_field);
        updatedField = (TextView)findViewById(R.id.updated_field);
        currentTemperatureField = (TextView)findViewById(R.id.current_temperature_field);
        altitudeField = (TextView)findViewById(R.id.altitude_field);

        buckysText = (TextView) findViewById(R.id.buckysText);
        dbHandler = new MyDBHandler(this, null, null, 1);
        //printDatabase();

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {


                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);

        }


        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);


        // Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Called when a new location is found by the network location provider.
                altitude = location.getAltitude();
                longitude = location.getLongitude();
                latitude = location.getLatitude();

                longi = Double.toString(longitude);
                lati = Double.toString(latitude);
                alti = Double.toString(altitude);

                updateView();

            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}

            public void onProviderEnabled(String provider) {}

            public void onProviderDisabled(String provider) {}

        };

        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        updateView();

    }

    public void updateView () {
        Function.placeIdTask asyncTask =new Function.placeIdTask(new Function.AsyncResponse() {
            public void processFinish(String weather_city, String weather_temperature,String weather_updatedOn) {

                cityField.setText(weather_city);
                updatedField.setText(weather_updatedOn);
                currentTemperatureField.setText(weather_temperature);

            }
        });
        if (latitude == 0 && longitude == 0){
            Toast.makeText(this, "Waiting for GPS signal...", Toast.LENGTH_LONG).show();
        } else {
            altitudeField.setText(alti + " meters above sea level");
            asyncTask.execute(lati, longi); //  asyncTask.execute("Latitude", "Longitude")
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // Register the listener with the Location Manager to receive location updates


                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }

    /*
    public void addToDatabaseClicked(View view) {
        String city = cityField.getText().toString();
        String updated = updatedField.getText().toString();
        String temperature = currentTemperatureField.getText().toString();

        WeatherData row = new WeatherData(city, updated, lati, longi, alti, temperature);
        dbHandler.addRow(row);
        printDatabase();


    }

    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        buckysText.setText(dbString);

    }
    */


     //Called when the user clicks the Map button

    public void goToMap(View view) {
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        Bundle b = new Bundle();
        b.putDouble("lat", latitude);
        b.putDouble("lng", longitude);
        intent.putExtras(b);
        startActivity(intent);
    }

}
