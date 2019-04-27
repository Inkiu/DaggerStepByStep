package com.example.daggerstepbystep.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.daggerstepbystep.DaggerApp
import com.example.daggerstepbystep.R
import com.example.daggerstepbystep.di.main.DaggerMainComponent
import com.example.daggerstepbystep.di.main.MainComponent
import com.example.daggerstepbystep.di.main.MainModule
import com.example.daggerstepbystep.model.User
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    lateinit var mainComponent: MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createOrGetMainComponent().inject(this)

        presenter.onCreate()
    }

    override fun onBindUser(user: User) {
        Toast.makeText(this, user.address, Toast.LENGTH_SHORT).show()
    }

    private fun createOrGetMainComponent(): MainComponent {
        if (!::mainComponent.isInitialized) {
            mainComponent = DaggerMainComponent.builder()
                .mainModule(MainModule(this))
                .userComponent(DaggerApp.get(this).userComponent)
                .build()
        }
        return mainComponent
    }
}
