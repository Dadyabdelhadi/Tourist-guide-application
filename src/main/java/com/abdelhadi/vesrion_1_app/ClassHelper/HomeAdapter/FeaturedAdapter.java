package com.abdelhadi.vesrion_1_app.ClassHelper.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abdelhadi.vesrion_1_app.R;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    ArrayList<FeaturedHelperClass> featuredLocations;

    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredLocations) {
        this.featuredLocations = featuredLocations;
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout;
        TextView title, desc;
        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);
            //Hooks
            relativeLayout = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
            desc = itemView.findViewById(R.id.featureds_des);
        }
    }


    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design, parent, false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        FeaturedHelperClass featuredHelperClass = featuredLocations.get(position);
        holder.relativeLayout.setBackground(featuredHelperClass.getRelativeLayout());
        holder.title.setText(featuredHelperClass.getTitl());
        holder.desc.setText(featuredHelperClass.getDescription());
    }
    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }
}
