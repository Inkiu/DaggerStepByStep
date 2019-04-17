package com.example.daggerstepbystep.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerstepbystep.DaggerApp
import com.example.daggerstepbystep.R
import com.example.daggerstepbystep.data.DataManager
import com.example.daggerstepbystep.di.main.DaggerMainComponent
import com.example.daggerstepbystep.di.main.MainComponent
import com.example.daggerstepbystep.di.main.MainModule
import com.example.daggerstepbystep.model.User
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mainComponent: MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createOrGetMainComponent().inject(this)
    }

    private fun createOrGetMainComponent(): MainComponent {
        if (!::mainComponent.isInitialized) {
            mainComponent = DaggerMainComponent.builder()
                .mainModule(MainModule(this))
                .applicationComponent(DaggerApp.get(this).applicationComponent)
                .build()
        }
        return mainComponent
    }
}
