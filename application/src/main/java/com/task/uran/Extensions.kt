package com.task.uran

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import com.task.uran.di.GlideApp

infix fun ViewGroup.inflate(layout: Int) =
    LayoutInflater.from(context).inflate(layout, this, false)

infix fun ImageView.load(url: String) =
    GlideApp.with(this)
        .load(url)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.ic_broken_image_white)
        )
        .into(this)


