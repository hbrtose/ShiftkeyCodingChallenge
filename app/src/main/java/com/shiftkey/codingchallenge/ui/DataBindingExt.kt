package com.shiftkey.codingchallenge.ui

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("android:visibility")
fun View.setVisibility(value: Boolean) {
    isVisible = value
}