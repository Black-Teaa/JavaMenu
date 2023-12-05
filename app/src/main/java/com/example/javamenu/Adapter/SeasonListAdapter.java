package com.example.javamenu.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.javamenu.Activity.Detail_Activity;
import com.example.javamenu.R;
import com.example.javamenu.domain.FoodDomain;

import java.util.ArrayList;

public class SeasonListAdapter extends RecyclerView.Adapter<SeasonListAdapter.ViewHolder> {

    ArrayList<FoodDomain> itemSeason;
    Context context;

    public SeasonListAdapter(ArrayList<FoodDomain> itemSeason) {
        this.itemSeason = itemSeason;
    }
    @NonNull
    @Override
    public SeasonListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_holder_season_list, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SeasonListAdapter.ViewHolder holder, int position) {
        holder.titleFirst.setText(itemSeason.get(position).getTitle());
        holder.totalPrice.setText("$ " + itemSeason.get(position).getPrice());
        holder.cal.setText(itemSeason.get(position).getEnergy() + " Кал");
        holder.time.setText(itemSeason.get(position).getTime() + " Мин");
        holder.ingred.setText(itemSeason.get(position).getIngredients());

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(itemSeason.get(position).getPicUrl(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new GranularRoundedCorners(30,30,30,30))
                .into(holder.picFirst);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), Detail_Activity.class);
                intent.putExtra("object", itemSeason.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemSeason.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleFirst, totalPrice, cal, time,ingred;
        ImageView picFirst;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ingred = itemView.findViewById(R.id.ingredients);
            titleFirst = itemView.findViewById(R.id.title_first_list);
            picFirst = itemView.findViewById(R.id.pic_on_firstlist);
            totalPrice = itemView.findViewById(R.id.price_on_first_list);
            cal = itemView.findViewById(R.id.cal_onfirs_list);
            time = itemView.findViewById(R.id.time_on_firstlist);
        }
    }
}