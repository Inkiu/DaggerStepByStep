package com.example.daggerstepbystep.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerstepbystep.R
import com.example.daggerstepbystep.ui.main.MainActivity
import com.example.daggerstepbystep.ui.main.Navigation
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginContract.View {
    @Inject
    lateinit var presenter: LoginContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
//        createOrGetLoginComponent().inject(this)
        setContentView(R.layout.activity_login)

        btnLoginSubmit.setOnClickListener {
            presenter.onSubmit(editUserId.text.toString(), editPassword.text.toString())
        }
    }

    override fun onNavigate(navigation: Navigation) {
        if (navigation is Navigation.OpenMainView) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onError(error: LoginContract.ErrorType) {

    }

//    private fun createOrGetLoginComponent(): LoginComponent {
//        if (!::loginComponent.isInitialized) {
//            loginComponent = DaggerApp.get(this).appComponent
//                .plus(LoginModule(this))
//        }
//        return loginComponent
//    }
}