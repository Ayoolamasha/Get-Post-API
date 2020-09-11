package com.ayoolamasha.apigetpost.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ayoolamasha.apigetpost.Adapters.SkillsAdapter;
import com.ayoolamasha.apigetpost.Model.SkillsModel;
import com.ayoolamasha.apigetpost.NetworkCall.ApiClient;
import com.ayoolamasha.apigetpost.NetworkCall.ApiClientInterface;
import com.ayoolamasha.apigetpost.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentSkills extends Fragment {
    private List<SkillsModel> skillsModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private Context context;
    private RecyclerView.Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skill_leader_recycler, container, false);
        setUpViews(view);
        getSkills();
        setRecyclerView();
        return view;
    }

    private void setUpViews(View view){
        recyclerView = view.findViewById(R.id.skillRecycler);
        context = getActivity();
    }

    private void setRecyclerView(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new SkillsAdapter(context, skillsModelList);
        recyclerView.setAdapter(adapter);
    }

    private void getSkills(){
        ApiClientInterface apiClientInterface = ApiClient.getClient().create(ApiClientInterface.class);

        Call<List<SkillsModel>> listCall = apiClientInterface.getScores();

        listCall.enqueue(new Callback<List<SkillsModel>>() {
            @Override
            public void onResponse(Call<List<SkillsModel>> call, Response<List<SkillsModel>> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    skillsModelList = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<SkillsModel>> call, Throwable t) {

                Toast.makeText(context, "Unable to fetch data", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
