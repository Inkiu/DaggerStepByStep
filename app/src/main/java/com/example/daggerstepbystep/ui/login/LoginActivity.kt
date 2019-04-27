package com.example.daggerstepbystep.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerstepbystep.DaggerApp
import com.example.daggerstepbystep.R
import com.example.daggerstepbystep.di.app.login.LoginComponent
import com.example.daggerstepbystep.di.app.login.LoginModule
import com.example.daggerstepbystep.ui.main.MainActivity
import com.example.daggerstepbystep.ui.main.Navigation
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginContract.View {
    @Inject
    lateinit var presenter: LoginContract.Presenter

    lateinit var loginComponent: LoginComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)
        createOrGetLoginComponent().inject(this)

        btnLoginSubmit.setOnClickListener {
            presenter.onSubmit(editUserId.text.toString(), editPassword.text.toString())
        }
    }

    override fun onNavigate(navigation: Navigation) {
        if (navigation is Navigation.OpenMainView) {
            DaggerApp.get(this).buildUserComponent()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onError(error: LoginContract.ErrorType) {

    }

    private fun createOrGetLoginComponent(): LoginComponent {
        if (!::loginComponent.isInitialized) {
            loginComponent = DaggerApp.get(this).appComponent
                .plus(LoginModule(this))
        }
        return loginComponent
    }
}