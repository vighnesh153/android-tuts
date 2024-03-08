package com.example.allaboutviews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.allaboutviews.databinding.CustomViewsFragmentBinding

class CustomViewsFragment : Fragment() {
    private lateinit var binding: CustomViewsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CustomViewsFragmentBinding.inflate(inflater, container, false)

//        binding.lifecycleOwner = this

        return binding.root
    }
}