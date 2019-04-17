package com.example.daggerstepbystep.ui.main.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daggerstepbystep.R
import com.example.daggerstepbystep.di.main.MainUserComponent
import com.example.daggerstepbystep.di.main.MainUserModule
import com.example.daggerstepbystep.model.User
import com.example.daggerstepbystep.ui.main.MainActivity
import com.example.daggerstepbystep.ui.main.MainContract
import kotlinx.android.synthetic.main.framgnet_main_user.*
import javax.inject.Inject

class MainUserFragment : Fragment(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    lateinit var mainUserComponent: MainUserComponent

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.framgnet_main_user, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createOrGetMainUserComponent().inject(this)
        presenter.onCreate()
    }

    override fun onBindUser(user: User) {
        userInfo.text = user.toString()
    }

    override fun onBindToken(token: String) {
        accessToken.text = token
    }

    private fun createOrGetMainUserComponent(): MainUserComponent {
        if (!::mainUserComponent.isInitialized) {
            mainUserComponent = (requireActivity() as MainActivity)
                .mainComponent
                .plus(MainUserModule(this))
        }
        return mainUserComponent
    }
}