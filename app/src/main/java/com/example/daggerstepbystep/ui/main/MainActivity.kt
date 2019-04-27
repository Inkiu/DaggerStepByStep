package com.example.daggerstepbystep.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.daggerstepbystep.DaggerApp
import com.example.daggerstepbystep.R
import com.example.daggerstepbystep.di.main.DaggerMainComponent
import com.example.daggerstepbystep.di.main.MainComponent
import com.example.daggerstepbystep.di.main.MainModule
import com.example.daggerstepbystep.ui.login.LoginActivity
import com.example.daggerstepbystep.ui.user.InfoFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    lateinit var mainComponent: MainComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!validateMainComponent()) {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }
        inflateFragment()
    }

    private fun inflateFragment() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, InfoFragment())
        }.commit()
    }

    private fun validateMainComponent(): Boolean {
        return if (!::mainComponent.isInitialized) {
            val component = createMainComponent()
            if (component != null) {
                mainComponent = component
                mainComponent.inject(this)
            }
            return component != null
        } else true
    }

    private fun createMainComponent(): MainComponent? {
        val userComponent = DaggerApp.get(this).requireUserComponent()
        return if (userComponent == null) null
        else {
            DaggerMainComponent.builder()
                .mainModule(MainModule(this))
                .userComponent(userComponent)
                .build()
        }
    }
}
