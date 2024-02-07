package com.example.colormyviews

import android.content.res.Resources.Theme
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(
            binding.main,
            binding.boxOneText,
            binding.boxTwoText,
            binding.boxThreeText,
            binding.boxFourText,
            binding.boxFiveText,
            binding.redButton,
            binding.greenButton,
            binding.yellowButton,
        )

        for (item in clickableViews) {
            item.setOnClickListener {
                makeColored(it)
            }
        }
    }

    private fun makeColored(view: View?) {
        when (view?.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            R.id.box_three_text -> view.setBackgroundColor(resources.getColor(android.R.color.holo_green_light))
            R.id.box_four_text -> view.setBackgroundColor(resources.getColor(android.R.color.holo_green_dark))
            R.id.box_five_text -> view.setBackgroundColor(resources.getColor(android.R.color.holo_green_light))

            R.id.red_button -> view.setBackgroundColor(resources.getColor(R.color.my_red))
            R.id.green_button -> view.setBackgroundColor(resources.getColor(R.color.my_green))
            R.id.yellow_button -> view.setBackgroundColor(resources.getColor(R.color.my_yellow))

            else -> view?.setBackgroundColor(Color.LTGRAY)
        }
    }
}