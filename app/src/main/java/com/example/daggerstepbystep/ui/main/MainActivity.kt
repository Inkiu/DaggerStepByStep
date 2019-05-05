package com.example.daggerstepbystep.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerstepbystep.DaggerApp
import com.example.daggerstepbystep.R
import com.example.daggerstepbystep.di.main.MainComponent
import com.example.daggerstepbystep.ui.login.LoginActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    @Inject
    lateinit var mainComponent: MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        presenter.onCreate()

        floatingButton.setOnClickListener {
            presenter.onLogout()
        }
    }

    override fun onNavigate(navigation: Navigation) {
        when (navigation) {
            is Navigation.OpenLogin -> {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    override fun onRestartApp() {
        DaggerApp.get(this).restartApp(this)
    }
}
