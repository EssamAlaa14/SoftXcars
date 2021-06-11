package com.example.carsrestful.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carsrestful.R;
import com.example.carsrestful.model.Cars;
import com.squareup.picasso.Picasso;

import java.util.List;

//RecyclerView Adapter
public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.CarsViewHolder> {
    //Properties to be used to show Cars
    private List<Cars> carsList;
    private int rowLayout; //layout for each item inside the carsList
    private Context context;

    public CarsAdapter(List<Cars> carsList, int rowLayout, Context context) {
        this.carsList = carsList;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    //Nested Class of ViewHolder to hold car items
    public static class CarsViewHolder extends RecyclerView.ViewHolder{
        //Data to be shown for each car item
        LinearLayout linearLayout;
        TextView brand;
        TextView constructionYear;
        TextView isUsed;
        ImageView carImage;
        public CarsViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.cars_linear);
            brand = itemView.findViewById(R.id.brand_text);
            constructionYear = itemView.findViewById(R.id.year_text);
            isUsed = itemView.findViewById(R.id.isused_text);
            carImage = itemView.findViewById(R.id.car_image);
        }
    }

    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new CarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position) {
        String imageUrl = carsList.get(position).getImageUrl();
        Picasso.with(context)
                .load(imageUrl)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(holder.carImage);
        holder.brand.setText(carsList.get(position).getBrand());
        holder.isUsed.setText(carsList.get(position).getUsed().toString());
        holder.constructionYear.setText(carsList.get(position).getConstructionYear());
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }


}
