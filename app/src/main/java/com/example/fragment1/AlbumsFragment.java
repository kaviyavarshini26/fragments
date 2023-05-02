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

public class AlbumsFragment extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass1> albumsList;
    Adapter1 adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        initData();
        return inflater.inflate(R.layout.fragment_albums, viewGroup, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();
    }

    private void initData() {
        albumsList = new ArrayList<>();
        albumsList.add(new ModelClass1(R.drawable.bridges,"Bridges","2.5/5","good"));
        albumsList.add(new ModelClass1(R.drawable.englishbeat,"Wa","3.5/5","all"));
        albumsList.add(new ModelClass1(R.drawable.history,"Vikam","4.5/5","kamalhassan"));
        albumsList.add(new ModelClass1(R.drawable.rose,"Rose","1.5/5","dhanush"));
        albumsList.add(new ModelClass1(R.drawable.more,"More","1.5/5","dhanush"));
    }

    private void initRecyclerView(){
        recyclerView= getView().findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter= new Adapter1(albumsList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}