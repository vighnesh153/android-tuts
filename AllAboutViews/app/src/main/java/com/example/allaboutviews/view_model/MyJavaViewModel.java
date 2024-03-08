package com.example.allaboutviews.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import timber.log.Timber;

public class MyJavaViewModel extends ViewModel {
    private final MutableLiveData<Integer> clicksCountState = new MutableLiveData<>(0);

    public LiveData<Integer> getClicksCountState() {
        return clicksCountState;
    }

    public void increment(Integer amount) {
        Integer incrementAmount = amount == null ? 1 : amount;
        clicksCountState.setValue(clicksCountState.getValue() + incrementAmount);
    }
}
