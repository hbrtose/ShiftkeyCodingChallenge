package com.shiftkey.codingchallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<Binding : ViewDataBinding>(
    @LayoutRes private val layout: Int
) : Fragment(layout) {

    var binding: Binding? = null
        private set

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = DataBindingUtil.inflate<Binding>(inflater, layout, container, false).let {
            binding = it
            it.lifecycleOwner = this
            it.root
        }
        return view
    }
}
