package com.cricket.cricket.api.viewmodel;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cricket.cricket.api.R;
import com.cricket.cricket.api.controller.H2HController;
import com.cricket.cricket.api.model.H2HModel;


import java.util.List;

public class H2HAdapter extends RecyclerView.Adapter<H2HAdapter.ViewHolder> {
    List<H2HModel.Result.H2H> h2hUtils;
    TableLayout tableLayout;
    Context context;
    public class ViewHolder extends RecyclerView.ViewHolder {
        //VARIABLE PARA MABASA
        TextView homeTeam;
        TextView awayTeam;
        TextView homeFinalScore;
        TextView awayFinalScore;
//        TableRow tableRow;
        TextView leagueName;
//        TextView statusInfo;
//        TextView startDate;
//        TextView endedDate;
        public ViewHolder(View itemView) {
            super(itemView);

//            tableLayout = itemView.findViewById(R.id.table_layout);
//            tableRow = new TableRow(itemView.getContext());
            homeTeam = itemView.findViewById(R.id.home_team);
            awayTeam = itemView.findViewById(R.id.away_team);
            homeFinalScore = itemView.findViewById(R.id.home_final_score);
            awayFinalScore = itemView.findViewById(R.id.away_final_score);
            leagueName = itemView.findViewById(R.id.league_name);

//            homeTeam = itemView.findViewById(R.id.home_team);
//            awayTeam = itemView.findViewById(R.id.away_team);
//            homeFinalScore = itemView.findViewById(R.id.home_final_score);
//            awayFinalScore = itemView.findViewById(R.id.away_final_score);
//            leagueName = itemView.findViewById(R.id.league_name);
            //statusInfo = itemView.findViewById(R.id.status_info);
//            startDate = itemView.findViewById(R.id.start_date);
//            endedDate = itemView.findViewById(R.id.ended_date);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }


    public H2HAdapter(H2HController context, List h2hUtils) {
        this.h2hUtils = h2hUtils;
        this.context = context;
    }

    public H2HAdapter() {
        //clone
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //LAGI DITO SI ACTIVTY MAIN O YUNG LAMAN NG UI MO WALA DPT DUN RECYCLVER VIEW
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_h2h, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {

        H2HModel.Result.H2H h2hListed = h2hUtils.get(position);
        holder.homeTeam.setText(h2hListed.getEventHomeTeam());
        holder.awayTeam.setText(h2hListed.getEventAwayTeam());
        holder.homeFinalScore.setText(h2hListed.getEventHomeFinalResult());
        holder.awayFinalScore.setText(h2hListed.getEventAwayFinalResult());
        holder.leagueName.setText(h2hListed.getLeagueName());
//        System.out.println("listed: "+ h2hUtils);
//        holder.tableRow.
//        holder.homeTeam.setText(h2hListed.getEventHomeTeam());
//        holder.homeTeam.setTextSize(10);
//        holder.homeTeam.setWidth(200);
//        holder.tableRow.addView(holder.homeTeam);
//        holder.awayTeam.setText(h2hListed.getEventAwayTeam() );
//        holder.awayTeam.setTextSize(10);
//        holder.awayTeam.setWidth(200);
//        holder.tableRow.addView(holder.awayTeam);
//        holder.homeFinalScore.setText(h2hListed.getEventHomeFinalResult() );
//        holder.homeFinalScore.setTextSize(10);
//        holder.homeFinalScore.setWidth(200);
//        holder.tableRow.addView(holder.homeFinalScore);
//        holder.awayFinalScore.setText(h2hListed.getEventAwayFinalResult() );
//        holder.awayFinalScore.setTextSize(10);
//        holder.awayFinalScore.setWidth(200);
//        holder.tableRow.addView(holder.awayFinalScore);
//        holder.leagueName.setText(h2hListed.getLeagueName() );
//        holder.leagueName.setTextSize(10);
//        holder.leagueName.setWidth(200);
//        holder.tableRow.addView(holder.leagueName);
//        holder.tableLayout.addView(holder.tableRow);

    //ipasok mo model mo dito

        //h2hListed.getEventHomeTeam(),h2hListed.getEventAwayTeam(),h2hListed.getEventHomeFinalResult(),h2hListed.getEventAwayFinalResult()
        //                ,h2hListed.getLeagueName()
//        autoMaticTable("HT","AT","HF","AF","LN");
//        autoMaticTable("HT","AT","HF","AF","LN",h2hListed.getEventHomeTeam(),h2hListed.getEventAwayTeam(),h2hListed.getEventHomeFinalResult(),h2hListed.getEventAwayFinalResult()
//                ,h2hListed.getLeagueName());


    }

//        holder.statusInfo.setText(h2hListed.getEventStatusInfo() );
//        holder.startDate.setText(h2hListed.getEventDateStart() );
//        holder.endedDate.setText(h2hListed.getEventDateStop() );
    //dito na gusto mo declare mga animation at pagttwag intent
    @Override
    public int getItemCount() {
        return h2hUtils.size();
    }
//    private void autoMaticTable(String HeaderHt, String Headerat ,String Headerhf, String Headeraf, String Headerln,
//                                String homeTeam, String awayTeam ,String homeFinal, String awayFinal, String leagueName){
//
//
//        TableRow.LayoutParams textViewParam = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.MATCH_PARENT,1f);
//        TableRow trHead = new TableRow(context);
//        TableLayout.LayoutParams tableRowParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
//        tableRowParams.setMargins(2, 3, 2, 10);
//        trHead.setGravity(Gravity.CENTER);
//        trHead.setBackgroundResource(R.drawable.row_border);
//        trHead.setLayoutParams(tableRowParams);
//
//
////        TextView Headerht = new TextView(context);
////        Headerht.setText(HeaderHt);
////        Headerht.setTextColor(Color.BLACK);
////        Headerht.setLayoutParams(textViewParam);
////        Headerht.setGravity(Gravity.CENTER);
////        Headerht.setTextSize(11);
////        trHead.addView(Headerht);
//
//        TextView ht = new TextView(context);
//        ht.setText(homeTeam);
//        ht.setTextColor(Color.BLACK);
//        ht.setLayoutParams(textViewParam);
//        ht.setGravity(Gravity.CENTER);
//        ht.setTextSize(12);
//        trHead.addView(ht);
//
//        TextView at = new TextView(context);
//        at.setText(awayTeam);
//        at.setTextColor(Color.BLACK);
//        at.setLayoutParams(textViewParam);
//        at.setGravity(Gravity.CENTER);
//        ht.setTextSize(12);
//        trHead.addView(at);
//
//
//        TextView hf = new TextView(context);
//        hf.setText(homeFinal);
//        hf.setTextColor(Color.BLACK);
//        hf.setLayoutParams(textViewParam);
//        hf.setGravity(Gravity.CENTER);
//        ht.setTextSize(12);
//        trHead.addView(hf);
//
//
//        TextView af= new TextView(context);
//        af.setText(awayFinal);
//        af.setTextColor(Color.BLACK);
//        af.setLayoutParams(textViewParam);
//        af.setGravity(Gravity.CENTER);
//        ht.setTextSize(12);
//        trHead.addView(af);
//
//
//        TextView ln = new TextView(context);
//        ln.setText(leagueName);
//        ln.setTextColor(Color.BLACK);
//        ln.setGravity(Gravity.CENTER);
//        ln.setLayoutParams(textViewParam);
//        ht.setTextSize(12);
//        trHead.addView(ln);
//
//
//
//        tableLayout.addView(trHead);
//
//    }



}
