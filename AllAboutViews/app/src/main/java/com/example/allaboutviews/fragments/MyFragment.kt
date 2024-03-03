package com.example.allaboutviews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.allaboutviews.databinding.MyFragmentBinding
import com.example.allaboutviews.recyclerview.MyRecyclerViewAdapter
import com.example.allaboutviews.view_model.MyViewModel
import com.example.allaboutviews.view_model.MyViewModelFactory

class MyFragment : Fragment() {
    private lateinit var binding: MyFragmentBinding

    private val viewModel: MyViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }

        val viewModelFactory = MyViewModelFactory(activity.application)
        ViewModelProvider(this, viewModelFactory)[MyViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MyFragmentBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.myViewModel = viewModel

        val adapter = MyRecyclerViewAdapter(this)
        binding.myRecyclerView.adapter = adapter

        viewModel.commentsWithPhotos.observe(viewLifecycleOwner) {
            adapter.submitList(it ?: emptyList())
        }

        return binding.root
    }
}