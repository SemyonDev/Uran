package com.task.uran

import android.view.LayoutInflater
import android.view.ViewGroup

infix fun ViewGroup.inflate(layout: Int) =
    LayoutInflater.from(context).inflate(layout, this, false)