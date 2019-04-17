package com.example.daggerstepbystep.ui.main.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daggerstepbystep.R
import com.example.daggerstepbystep.model.User
import com.example.daggerstepbystep.ui.main.MainContract
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainUserFragment : Fragment(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.framgnet_main_user, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.onCreate()
    }

    override fun onBindUser(user: User) {
        userInfo.text = user.toString()
    }

    override fun onBindToken(token: String) {
        accessToken.text = token
    }
}