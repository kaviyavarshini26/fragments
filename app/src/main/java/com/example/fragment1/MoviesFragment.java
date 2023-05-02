package com.example.fragment1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MoviesFragment extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> moviesList;
    Adapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        initData();
        return inflater.inflate(R.layout.fragment_movies, viewGroup, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();
    }

    private void initData() {
        moviesList=new ArrayList<>();
        moviesList.add(new ModelClass(R.drawable.beast,"Beast","2.5/5","vijay,poojahede"));
        moviesList.add(new ModelClass(R.drawable.war,"War","3.5/5","all"));
        moviesList.add(new ModelClass(R.drawable.vikram,"Vikam","4.5/5","kamalhassan"));
        moviesList.add(new ModelClass(R.drawable.three,"Three","1.5/5","dhanush"));

    }

    private void initRecyclerView(){
        recyclerView= getView().findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new Adapter(moviesList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}