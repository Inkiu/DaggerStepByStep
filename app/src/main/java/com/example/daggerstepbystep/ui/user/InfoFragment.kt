package com.example.daggerstepbystep.ui.user

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.daggerstepbystep.R
import com.example.daggerstepbystep.model.User
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_info.*
import javax.inject.Inject

class InfoFragment: Fragment(), InfoContract.View {

    @Inject
    lateinit var presenter: InfoContract.Presenter

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userInfo.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_infoFragment_to_detailFragment)
        }
        presenter.onCreate()
    }

    override fun onBindInfo(user: User) {
        userInfo.text = user.name
        accessToken.text = user.address
    }
}