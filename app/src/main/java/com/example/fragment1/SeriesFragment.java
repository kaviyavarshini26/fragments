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

import java.util.ArrayList;
import java.util.List;

public class SeriesFragment extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass2> seriesList;
    Adapter2 adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        initData();
        return inflater.inflate(R.layout.fragment_series, viewGroup, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();
    }

    private void initData() {
        seriesList = new ArrayList<>();
        seriesList.add(new ModelClass2(R.drawable.daredevil,"Daredevil","2.5/5","good"));
        seriesList.add(new ModelClass2(R.drawable.heartstopper,"HeartStopper","3.5/5","all"));
        seriesList.add(new ModelClass2(R.drawable.squad,"Squad","4.5/5","kamalhassan"));
        seriesList.add(new ModelClass2(R.drawable.strangerthings,"StrangerThings","1.5/5","dhanush"));
        seriesList.add(new ModelClass2(R.drawable.wednesday,"Wednesday","1.5/5","dhanush"));
    }

    private void initRecyclerView(){
        recyclerView= getView().findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter= new Adapter2(seriesList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}