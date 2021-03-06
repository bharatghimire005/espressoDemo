package project.com.espressotutorial;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerViewCountry;
    private Activity mActivity;
    private List<String> list;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;
        mRecyclerViewCountry = (RecyclerView) findViewById(R.id.recyclerview_country);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);

       // retrofitApiRequest();
    }


    private void retrofitApiRequest(){

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.population.io:80/1.0/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        CountryApiInterface countryApiInterface = retrofit.create(CountryApiInterface.class);
        Call<CountryListModel> countryListModelCall = countryApiInterface.loadCountryList();
        countryListModelCall.enqueue(new Callback<CountryListModel>() {
            @Override
            public void onResponse(Call<CountryListModel> call, Response<CountryListModel> response) {
                mProgressBar.setVisibility(View.GONE);
                mRecyclerViewCountry.setVisibility(View.VISIBLE);
                int responseCode = response.code();
                CountryListModel countryListModel = response.body();
                list = countryListModel.countryList;
                Log.i(TAG, "onResponse: " + countryListModel.countryList.get(0));
                setAdapter();
            }

            @Override
            public void onFailure(Call<CountryListModel> call, Throwable t) {
                mProgressBar.setVisibility(View.GONE);
                Log.i(TAG, "onResponse: " + t);
            }
        });
    }

    private void setAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        mRecyclerViewCountry.setLayoutManager(manager);
        CountryAdapter countryAdapter = new CountryAdapter(list,mActivity);
        mRecyclerViewCountry.setAdapter(countryAdapter);

    }

    private void addCountryList(){
        list.add("India");
        list.add("Pakistan");
        list.add("Bhutan");
        list.add("Malaysia");
    }
}
