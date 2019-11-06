package com.eng.elfarsisy.mvvmapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.eng.elfarsisy.mvvmapi.R;
import com.eng.elfarsisy.mvvmapi.model.Result;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    Context mcontext;
    List<Result> mData;

    public HomeAdapter() {
    }

    public HomeAdapter(Context mcontext, List<Result> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.home_movie_item, parent, false);

        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.movieName.setText(mData.get(position).getTitle());
        Glide.with(mcontext).load("https://image.tmdb.org/t/p/w500/" + mData.get(position).getBackdropPath()).into(holder.moviePoster);

    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {

        ImageView moviePoster;
        TextView movieName;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePoster = itemView.findViewById(R.id.movieImage);
            movieName = itemView.findViewById(R.id.movieName);

        }
    }
}
