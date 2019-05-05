package com.example.daggerstepbystep.ui.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daggerstepbystep.R
import com.example.daggerstepbystep.di.main.detail.DetailComponent
import com.example.daggerstepbystep.di.main.detail.DetailModule
import com.example.daggerstepbystep.di.main.info.InfoComponent
import com.example.daggerstepbystep.model.User
import com.example.daggerstepbystep.model.UserDetail
import com.example.daggerstepbystep.ui.main.MainActivity
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragemnt_detail.*
import javax.inject.Inject

class DetailFragment: Fragment(), DetailContract.View {

    @Inject
    lateinit var presenter: DetailContract.Presenter

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragemnt_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onCreate()
    }

    override fun onBindInfo(userDetail: UserDetail) {
        userDetailTextView.text = userDetail.detail
    }
}