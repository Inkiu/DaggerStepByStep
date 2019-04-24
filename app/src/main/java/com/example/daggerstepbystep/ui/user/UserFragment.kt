package com.example.daggerstepbystep.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daggerstepbystep.R
import com.example.daggerstepbystep.di.user.UserComponent
import com.example.daggerstepbystep.di.user.UserModule
import com.example.daggerstepbystep.model.User
import com.example.daggerstepbystep.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_user.*
import javax.inject.Inject

class UserFragment : Fragment(), UserContract.View {

    @Inject
    lateinit var presenter: UserContract.Presenter

    lateinit var userComponent: UserComponent

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createOrGetUserComponent().inject(this)

        presenter.onCreate()
    }

    override fun onBindUser(user: User) {
        userInfo.text = user.toString()
    }

    override fun onBindAccessToken(token: String) {
        accessToken.text = token
    }

    private fun createOrGetUserComponent(): UserComponent {
        if (!::userComponent.isInitialized) {
            userComponent = (requireActivity() as MainActivity)
                .mainComponent
                .plus(UserModule(this))
        }
        return userComponent
    }
}