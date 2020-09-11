package com.ayoolamasha.apigetpost.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ayoolamasha.apigetpost.Model.LeadersModel;
import com.ayoolamasha.apigetpost.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LeadersAdapter extends RecyclerView.Adapter<LeadersAdapter.ViewHolder> {

    private Context context;
    private List<LeadersModel> leadersModelList;

    public LeadersAdapter(Context context, List<LeadersModel> leadersModelList) {
        this.context = context;
        this.leadersModelList = leadersModelList;
    }

    @NonNull
    @Override
    public LeadersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_layout_leader, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeadersAdapter.ViewHolder holder, int position) {
        LeadersModel leadersModel = leadersModelList.get(position);
        String placeholder = leadersModel.getHours() + R.string.leaders_rating_side_text + leadersModel.getCountry();
        holder.name.setText(leadersModel.getName());
        holder.review.setText(placeholder);
        Picasso.with(context).load(leadersModel.getBadgeUrl())
                .centerCrop()
                .placeholder(R.drawable.toplearner)
                .error(R.drawable.ic_baseline_warning_24)
                .into(holder.badgeUrl);

    }

    @Override
    public int getItemCount() {
        return leadersModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView badgeUrl;
        private TextView name;
        private TextView review;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            badgeUrl = itemView.findViewById(R.id.leaderBadgeImageView);
            name = itemView.findViewById(R.id.leadersName);
            review = itemView.findViewById(R.id.leadersRating);
        }
    }
}
