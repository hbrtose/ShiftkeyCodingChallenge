package com.shiftkey.codingchallenge.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.shiftkey.codingchallenge.BR
import com.shiftkey.codingchallenge.R
import com.shiftkey.codingchallenge.databinding.FragmentDetailBinding
import com.shiftkey.codingchallenge.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    private val viewModel by viewModels<DetailsViewModel>()
    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.setVariable(BR.viewModel, viewModel)
        viewModel.setDto(args.dto)
    }
}