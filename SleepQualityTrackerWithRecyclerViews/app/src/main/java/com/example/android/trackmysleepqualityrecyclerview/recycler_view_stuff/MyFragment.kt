package com.example.android.trackmysleepqualityrecyclerview.recycler_view_stuff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.trackmysleepqualityrecyclerview.R
import com.example.android.trackmysleepqualityrecyclerview.databinding.MyFragmentBinding

class MyFragment : Fragment() {
    private lateinit var binding: MyFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.my_fragment, container, false)

        binding.lifecycleOwner = this


        // Linear layouts
//        val adapter = MyAdapter()
//        binding.myRecyclerView.adapter = adapter
//        adapter.data = (1..10000).map { MyCard("pokemon-$it", "Pikachu-$it") }

//        val adapter2 = MyAdapter2()
//        binding.myRecyclerView.adapter = adapter2
//        adapter2.submitList((1..10000).map { MyCard("pokemon-$it", "Infernape-$it") })

        val adapter3 = MyAdapter3(MyItemListener {
            Toast.makeText(requireContext(), it.title, Toast.LENGTH_SHORT).show()
        })
        binding.myRecyclerView.adapter = adapter3
        adapter3.submitList((1..10000).map { MyCard("pokemon-$it", "Greninja-$it") })

        // Grid layouts
        val gridLayoutManger = GridLayoutManager(requireActivity(), 2)
        binding.myRecyclerView.layoutManager = gridLayoutManger


        return binding.root
    }
}