package com.example.daggerstepbystep.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerstepbystep.DaggerApp
import com.example.daggerstepbystep.R
import com.example.daggerstepbystep.di.detail.DetailComponent
import com.example.daggerstepbystep.di.detail.DetailModule
import com.example.daggerstepbystep.di.main.MainModule
import com.example.daggerstepbystep.model.UserDetail
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), DetailContract.View {

    @Inject
    lateinit var presenter: DetailContract.Presenter

    lateinit var detailComponent: DetailComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        createOrGetMainComponent().inject(this)
    }

    override fun onBindDetail(userDetail: UserDetail) {
        userDetailTextView.text = userDetail.detail
    }

    private fun createOrGetMainComponent(): DetailComponent {
        if (!::detailComponent.isInitialized) {
            detailComponent = DaggerApp.get(this)
                .applicationComponent
                .plus(DetailModule(this))
        }
        return detailComponent
    }
}
