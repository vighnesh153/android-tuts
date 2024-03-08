package com.example.allaboutviews.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.allaboutviews.R;
import com.example.allaboutviews.databinding.ComposeViewFragmentContainerBinding;

public class MyComposeViewJavaFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle saveInstanceBundle
    ) {
        ComposeViewFragmentContainerBinding binding =
                ComposeViewFragmentContainerBinding
                        .inflate(inflater, container, false);

        getChildFragmentManager()
                .beginTransaction()
                .replace(R.id.composeViewFragmentContainer, new MyComposeViewKotlinFragment())
                .commitNow();

        return binding.getRoot();
    }
}
