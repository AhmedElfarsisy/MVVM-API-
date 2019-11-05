package com.eng.elfarsisy.mvvmapi.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eng.elfarsisy.mvvmapi.model.Result;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Result>> mMovies;

    public HomeViewModel() {

    }

    public LiveData<List<Result>> getMovies() {


        return mMovies;
    }
}