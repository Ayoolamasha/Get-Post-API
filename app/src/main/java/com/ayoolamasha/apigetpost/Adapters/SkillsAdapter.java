package com.ayoolamasha.apigetpost.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ayoolamasha.apigetpost.Model.SkillsModel;
import com.ayoolamasha.apigetpost.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.ViewHolder> {
    private Context context;
    private List<SkillsModel> skillsModelList;

    public SkillsAdapter(Context context, List<SkillsModel> skillsModelList) {
        this.context = context;
        this.skillsModelList = skillsModelList;
    }

    @NonNull
    @Override
    public SkillsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_layout_skill, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillsAdapter.ViewHolder holder, int position) {
        SkillsModel skillsModel = skillsModelList.get(position);
        String placeholder = skillsModel.getScore() + R.string.skills_rating_side_text + skillsModel.getCountry();
        holder.skillName.setText(skillsModel.getName());
        holder.skillReview.setText(placeholder);
        Picasso.with(context).load(skillsModel.getBadgeUrl())
                .centerCrop()
                .placeholder(R.drawable.skilliqqtrimmed)
                .error(R.drawable.ic_baseline_warning_24)
                .into(holder.skillBadgeUrl);

    }

    @Override
    public int getItemCount() {
        return skillsModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView skillBadgeUrl;
        private TextView skillName, skillReview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            skillBadgeUrl = itemView.findViewById(R.id.skillImageView);
            skillName = itemView.findViewById(R.id.skillName);
            skillReview = itemView.findViewById(R.id.skillRating);
        }
    }
}