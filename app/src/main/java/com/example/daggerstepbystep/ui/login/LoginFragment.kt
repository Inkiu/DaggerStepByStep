package com.example.daggerstepbystep.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.daggerstepbystep.R
import com.example.daggerstepbystep.di.login.LoginComponent
import com.example.daggerstepbystep.di.login.LoginModule
import com.example.daggerstepbystep.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment : Fragment(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter

    lateinit var loginComponent: LoginComponent

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createOrGetLoginComponent().inject(this)

        btnLoginSubmit.setOnClickListener {
            presenter.onSubmit(editUserId.text.toString(), editPassword.text.toString())
        }
    }

    override fun onError(error: LoginContract.ErrorType) {
        val errorText = when (error) {
            LoginContract.ErrorType.ID_FORMAT -> "ID"
            LoginContract.ErrorType.PASSWORD_INCORRECT -> "PASSWORD"
        }
        Toast.makeText(requireContext(), errorText, Toast.LENGTH_SHORT).show()
    }

    private fun createOrGetLoginComponent(): LoginComponent {
        if (!::loginComponent.isInitialized) {
            loginComponent = (requireActivity() as MainActivity)
                .mainComponent
                .plus(LoginModule(this))
        }
        return loginComponent
    }
}