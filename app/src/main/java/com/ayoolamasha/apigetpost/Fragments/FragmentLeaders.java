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

import com.ayoolamasha.apigetpost.Adapters.LeadersAdapter;
import com.ayoolamasha.apigetpost.Model.LeadersModel;
import com.ayoolamasha.apigetpost.NetworkCall.ApiClient;
import com.ayoolamasha.apigetpost.NetworkCall.ApiClientInterface;
import com.ayoolamasha.apigetpost.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentLeaders extends Fragment{
    private Context context;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<LeadersModel> leadersModelList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leader_recycler, container, false);
        viewSetup(view);
        getLeaders();
        setRecyclerView();
        return view;
    }

    private void viewSetup(View view){
        context = getActivity();
        recyclerView = view.findViewById(R.id.leaderRecycler);

    }

    private void setRecyclerView(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        adapter = new LeadersAdapter(context, leadersModelList);
        recyclerView.setAdapter(adapter);
    }

    private void getLeaders(){
        ApiClientInterface apiClientInterface = ApiClient.getClient().create(ApiClientInterface.class);
        Call<List<LeadersModel>> listCall = apiClientInterface.getHours();
        listCall.enqueue(new Callback<List<LeadersModel>>() {
            @Override
            public void onResponse(Call<List<LeadersModel>> call, Response<List<LeadersModel>> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    leadersModelList = response.body();
                }

            }

            @Override
            public void onFailure(Call<List<LeadersModel>> call, Throwable t) {
                Toast.makeText(context, "Unable to fetch data", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
