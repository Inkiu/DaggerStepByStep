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
import kotlinx.android.synthetic.main.fragemnt_detail.*
import javax.inject.Inject

class DetailFragment: Fragment(), DetailContract.View {

    @Inject
    lateinit var presenter: DetailContract.Presenter

    lateinit var detailComponent: DetailComponent

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        createOrGetComponent()
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

    private fun createOrGetComponent(): DetailComponent {
        if (!::detailComponent.isInitialized) {
            detailComponent = (requireActivity() as MainActivity).mainComponent.
                plus(DetailModule(this))
            detailComponent.inject(this)
        }
        return detailComponent
    }
}