package com.eng.elfarsisy.mvvmapi.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eng.elfarsisy.mvvmapi.R;
import com.eng.elfarsisy.mvvmapi.adapter.HomeAdapter;
import com.eng.elfarsisy.mvvmapi.model.Result;
import com.eng.elfarsisy.mvvmapi.modelview.HomeViewModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView homeRecycler;
    private HomeAdapter homeAdapter;
    List<Result> topRated;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(getActivity()).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeRecycler = root.findViewById(R.id.home_recycler);
        topRated = new ArrayList<>();
        homeViewModel.init();
        homeViewModel.getMovies().observe(getActivity(), new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                Toast.makeText(getActivity(), "changed noticed", Toast.LENGTH_SHORT).show();
                 topRated=results;
                homeAdapter.notifyDataSetChanged();
            }
        });
        setUpRecycler();
        return root;
    }

    private void setUpRecycler() {
        Toast.makeText(getActivity(), "recycler set", Toast.LENGTH_SHORT).show();
        homeAdapter = new HomeAdapter(getActivity(),topRated);
        homeRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        homeRecycler.setAdapter(homeAdapter);
        Toast.makeText(getActivity(), "recycler seted", Toast.LENGTH_SHORT).show();


    }
}