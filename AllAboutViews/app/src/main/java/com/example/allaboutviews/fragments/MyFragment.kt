package com.example.allaboutviews.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.allaboutviews.recyclerview.MyRecyclerViewAdapter
import com.example.allaboutviews.databinding.MyFragmentBinding
import com.example.allaboutviews.view_model.MyViewModel
import com.example.allaboutviews.view_model.MyViewModelFactory

class MyFragment : Fragment() {
    private lateinit var binding: MyFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MyFragmentBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        val viewModelFactory = MyViewModelFactory()
        val viewModel = ViewModelProvider(this, viewModelFactory)[MyViewModel::class.java]

        binding.myViewModel = viewModel

        val adapter = MyRecyclerViewAdapter(this)
        binding.myRecyclerView.adapter = adapter

        viewModel.comments.observe(viewLifecycleOwner) {
            adapter.submitList(it ?: emptyList())
        }

        viewModel.fetchCommentsError.observe(viewLifecycleOwner) {
            it?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
            viewModel.doneProcessingFetchCommentsError()
        }

        return binding.root
    }
}