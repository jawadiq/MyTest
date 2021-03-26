package com.example.mytest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public class MainActivity extends AppCompatActivity {
//   URL Url = new URL( "https://api.darksky.net/forecast/2bb07c3bece89caf533ac9a5d23d8417/"+lng+lat) ;
    double lat = 35.2323;
    double lng;
    private String API_KEY = "2bb07c3bece89caf533ac9a5d23d8417";
    private String latiTude, lonGitude;
    TextView lati, myLocation, myWeather;
    LocationManager locationManager;
    TextView lati, myLocation, myWeather;
    LocationManager locationManager;
    TextView lati, myLocation, myWeather;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLocation();
        lati = (TextView) findViewById(R.id.rsponse);
        myLocation = (TextView) findViewById(R.id.location);
        myWeather = (TextView) findViewById(R.id.weather);

    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    public void GetWeather(View v) {
//        Retrofit retrofit = new Retrofit().Builder()
//                .baseUrl("").addConverterFactory(GsonConverterFactory.create()).build();
    }

    public void getLocation() {
        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 5, locationListenerGPS);
        } catch (Exception e) {

        }
    }

    LocationListener locationListenerGPS = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            lng = location.getLongitude();
            lat = location.getLatitude();
            Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
            try {
                List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                String adress = addresses.get(0).getAddressLine(0);
                lati.setText(adress + "" + String.valueOf(lng) + "" + String.valueOf(lat));
                latiTude = Double.toString(lng);
                lonGitude = Double.toString(lng);
                myWeather.setText(adress);
            } catch (IOException e) {
                e.printStackTrace();
            }
//
        }




    };
}