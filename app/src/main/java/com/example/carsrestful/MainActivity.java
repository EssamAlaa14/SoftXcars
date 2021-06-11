package com.example.carsrestful;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.carsrestful.adapter.CarsAdapter;
import com.example.carsrestful.model.Cars;
import com.example.carsrestful.model.CarsResponse;
import com.example.carsrestful.rest.CarsApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName(); //Getting class Name
    //API data
    public static final String BASE_URL = "http://demo1585915.mockable.io/"; //Base url of API
    private final static String API_URL_KEY = "1"; // Page Number
    private static Retrofit retrofit = null; //Retrofit object
    //Properties that will be used to bind recyclerview with its adapter
    private RecyclerView recyclerView = null;
    private CarsAdapter carsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        connectAndGetCarsData();
    }

    // A method to get the response and show it
    private void connectAndGetCarsData() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        CarsApiService carsApiService = retrofit.create(CarsApiService.class);
        Call<CarsResponse> call = carsApiService.getCars(API_URL_KEY);
        call.enqueue(new Callback<CarsResponse>() {
            @Override
            public void onResponse(Call<CarsResponse> call, Response<CarsResponse> response) {
                List<Cars> carsList = response.body().getData();
                carsAdapter = new CarsAdapter(carsList,R.layout.cars_item,getApplicationContext());
                recyclerView.setAdapter(carsAdapter);
                Log.d(TAG, "Number of cars received: " + carsList.size());
            }

            @Override
            public void onFailure(Call<CarsResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}