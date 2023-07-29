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
import com.abdelhadi.vesrion_1_app.ClassHelper.*;
import com.abdelhadi.vesrion_1_app.ClassHelper.*;
import java.util.ArrayList;

public class MostViewedAdpater extends RecyclerView.Adapter<MostViewedAdpater.MostViewedViewHolder> {

    ArrayList<MostViewedHelperClass> mostViewedLocations;

    public MostViewedAdpater(ArrayList<MostViewedHelperClass> mostViewedLocations) {
        this.mostViewedLocations = mostViewedLocations;
    }

    public static class MostViewedViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout;
        TextView textView ,textView2;


        public MostViewedViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.background_gradient_most);
            textView = itemView.findViewById(R.id.mosts_title);
            textView2 =itemView.findViewById(R.id.mosts_des);
        }
    }




    @NonNull
    @Override
    public MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewd_card_design, parent, false);
        MostViewedViewHolder mostViewedViewHolder = new MostViewedViewHolder(view);
        return mostViewedViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull MostViewedViewHolder holder, int position) {
        MostViewedHelperClass helperClass = mostViewedLocations.get(position);

        holder.textView.setText(helperClass.getTitl());
        holder.textView2.setText(helperClass.getDesc());
        holder.relativeLayout.setBackground(helperClass.getRelativeLayout());
    }
    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

}