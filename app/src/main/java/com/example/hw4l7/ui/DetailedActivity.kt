package com.example.hw4l7.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.hw4l7.R
import com.example.hw4l7.data.ViewedProductDaoImpl
import com.example.hw4l7.domain.model.Cart
import com.example.hw4l7.presenter.detailed.DetailedPresenter
import com.example.hw4l7.presenter.detailed.DetailedView
import kotlinx.android.synthetic.main.activity_detailed.*
import moxy.ktx.moxyPresenter

class DetailedActivity : BaseActivity(), DetailedView {

    private val presenter by moxyPresenter {
        DetailedPresenter(
            ViewedProductDaoImpl(sharedPreferences)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val product = intent?.getParcelableExtra<Cart>(PRODUCT_TAG) ?: return
        Glide
            .with(ivDetailedImage.context)
            .load(product.imageUrl)
            .error(R.mipmap.ic_launcher)
            .into(ivDetailedImage)
        tvDetailedTitle.text = product.product.name
        tvDetailedPrice.text = product.product.calcDiscountPrice().toString()
        presenter.onProductShow(product)
    }

    companion object {
        const val PRODUCT_TAG = "PRODUCT_TAG"
    }

    val AppCompatActivity.sharedPreferences: SharedPreferences
        get() = getSharedPreferences("data", MODE_PRIVATE)
}