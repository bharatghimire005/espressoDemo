package loader;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;

import project.com.espressotutorial.CountryListModel;

/**
 * Created by bharatghimire on 24/8/16.
 */

public class LoaderCallbacks implements LoaderManager.LoaderCallbacks<CountryListModel> {

    @Override
    public Loader<CountryListModel> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<CountryListModel> loader, CountryListModel countryListModel) {

    }

    @Override
    public void onLoaderReset(Loader<CountryListModel> loader) {

    }
}
