package com.shiftkey.codingchallenge.ui.list

import android.os.Bundle
import android.view.View
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.shiftkey.codingchallenge.BR
import com.shiftkey.codingchallenge.R
import com.shiftkey.codingchallenge.databinding.FragmentListBinding
import com.shiftkey.codingchallenge.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding>(R.layout.fragment_list) {

    private val viewModel by viewModels<ListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val shiftsAdapter = ShiftsAdapter {
            findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailsFragment(it))
        }
        binding?.let {
            it.setVariable(BR.viewModel, viewModel)
            it.shiftsNestedScroll.setOnScrollChangeListener { view, scX, scY, oldX, oldY ->
                if (scY == (view as NestedScrollView).getChildAt(0).measuredHeight - view.measuredHeight) {
                    viewModel.update()
                }
            }
            it.shiftsRecycler.adapter
            it.shiftsRecycler.adapter = shiftsAdapter
        }
        viewModel.shifts.observe(viewLifecycleOwner) {
            shiftsAdapter.submitList(shiftsAdapter.currentList + it)
        }
    }
}