package project.com.espressotutorial;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bharatghimire on 19/8/16.
 */

public class CountryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<String> list;
    Activity mActivity;

    public CountryAdapter(List<String> list, Activity mActivity) {
        this.list = list;
        this.mActivity = mActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.countryitem, parent, false);
        return new CountryHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CountryHolder countryHolder= (CountryHolder) holder;
        countryHolder.mTextViewCountry.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CountryHolder extends RecyclerView.ViewHolder{

        TextView mTextViewCountry;
        public CountryHolder(View itemView) {
            super(itemView);
            mTextViewCountry= (TextView) itemView.findViewById(R.id.textview_country);
        }
    }

}
