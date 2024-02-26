package com.example.allaboutviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.allaboutviews.databinding.MyFragmentBinding

class MyFragment : Fragment() {
    private lateinit var binding: MyFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.my_fragment, container, false)

        binding.lifecycleOwner = this

        val viewModelFactory = MyViewModelFactory()
        val viewModel = ViewModelProvider(this, viewModelFactory)[MyViewModel::class.java]

        binding.myViewModel = viewModel

        val adapter = MyRecyclerViewAdapter()
        binding.myRecyclerView.adapter = adapter

        viewModel.comments.observe(viewLifecycleOwner) {
            adapter.submitList(it ?: emptyList())
        }

        return binding.root
    }
}