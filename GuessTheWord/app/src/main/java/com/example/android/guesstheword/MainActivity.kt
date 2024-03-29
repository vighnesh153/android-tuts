package com.example.android.guesstheword

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

/**
 * Creates an Activity that hosts all of the fragments in the app
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        Timber.i("MainActivity.onCreate called")
    }

}
