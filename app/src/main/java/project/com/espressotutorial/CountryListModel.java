package project.com.espressotutorial;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bharatghimire on 19/8/16.
 */

public class CountryListModel {
    @SerializedName("countries")
    List<String> countryList;
}
