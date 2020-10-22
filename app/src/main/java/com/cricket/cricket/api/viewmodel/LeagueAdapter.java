package com.cricket.cricket.api.viewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cricket.cricket.api.R;
import com.cricket.cricket.api.controller.LeaguesController;

import com.cricket.cricket.api.model.LeagueModel;

import java.util.List;

public class LeagueAdapter extends RecyclerView.Adapter<LeagueAdapter.ViewHolder> {
    private List<LeagueModel.result> countryUtils;

    public LeagueAdapter(LeaguesController context, List countryUtils) {
//        this.context = (Context) context;
        this.countryUtils = countryUtils;
    }

    public LeagueAdapter() {
        //clone
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //LAGI DITO SI ACTIVTY MAIN O YUNG LAMAN NG UI MO WALA DPT DUN RECYCLVER VIEW
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_images_data, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final LeagueModel.result leagueList = countryUtils.get(position);


        holder.leagueName.setText(leagueList.getLeagueName());
        holder.countryName.setText(leagueList.getCountryKey());



    }


    @Override
    public int getItemCount() {
        return countryUtils.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //VARIABLE PARA MABASA
        public TextView leagueName;
        public TextView countryName;

        public ViewHolder(View itemView) {
            super(itemView);
            leagueName = itemView.findViewById(R.id.league_name);
            countryName = itemView.findViewById(R.id.country_name_display);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }
}