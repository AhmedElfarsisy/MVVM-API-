package com.eng.elfarsisy.mvvmapi.modelview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.eng.elfarsisy.mvvmapi.model.Result;
import com.eng.elfarsisy.mvvmapi.repository.HomeRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<Result>> mMovies=new MutableLiveData<>();

    public HomeViewModel() {

    }

    public void init() {
        if (mMovies != null) {
            return;
        }
        HomeRepository homeRepository = HomeRepository.getInstance();
        mMovies = homeRepository.getHomeMovie();
    }

    public LiveData<List<Result>> getMovies() {

        return mMovies;
    }
}
