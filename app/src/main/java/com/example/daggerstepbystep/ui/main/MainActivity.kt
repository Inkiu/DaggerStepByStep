package com.example.daggerstepbystep.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerstepbystep.DaggerApp
import com.example.daggerstepbystep.R
import com.example.daggerstepbystep.di.DaggerMainComponent
import com.example.daggerstepbystep.di.MainComponent
import com.example.daggerstepbystep.di.MainModule
import com.example.daggerstepbystep.ui.login.LoginFragment
import com.example.daggerstepbystep.ui.user.UserFragment

class MainActivity : AppCompatActivity() {

    lateinit var mainComponent: MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createOrGetMainComponent().inject(this)

        onNavigate(Navigation.LoginView)
    }

    fun onNavigate(navigation: Navigation) {
        val fragment = when (navigation) {
            Navigation.LoginView -> LoginFragment()
            Navigation.OpenMainView -> UserFragment()
        }
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
        }.commit()
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
