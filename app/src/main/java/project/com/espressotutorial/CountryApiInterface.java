package project.com.espressotutorial;


import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by bharatghimire on 19/8/16.
 */

public interface CountryApiInterface {
@GET("countries")
    Call<CountryListModel> loadCountryList();
}
