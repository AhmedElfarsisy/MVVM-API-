package com.eng.elfarsisy.mvvmapi.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eng.elfarsisy.mvvmapi.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView homeRecycler;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeRecycler=root.findViewById(R.id.home_recycler);
        setUpRecycler();
        return root;
    }

    private void setUpRecycler() {
homeRecycler.setLayoutManager(new GridLayoutManager(getActivity(),2));


    }
}