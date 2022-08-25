package com.shiftkey.codingchallenge.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shiftkey.codingchallenge.BR
import com.shiftkey.codingchallenge.R
import com.shiftkey.codingchallenge.domain.model.ShiftDto

class ShiftsAdapter(private val onItemClick: (ShiftDto) -> Unit) : ListAdapter<ShiftDto, ShiftsAdapter.ShiftViewHolder>(ShiftDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShiftViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_shift,
            parent,
            false
        )
        return ShiftViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShiftViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ShiftViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(viewHolderData: ShiftDto) {
            binding.setVariable(BR.itemViewData, viewHolderData)
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                onItemClick(viewHolderData)
            }
        }
    }
}

object ShiftDiffCallback : DiffUtil.ItemCallback<ShiftDto>() {
    override fun areItemsTheSame(oldItem: ShiftDto, newItem: ShiftDto): Boolean = oldItem.shiftId == newItem.shiftId
    override fun areContentsTheSame(oldItem: ShiftDto, newItem: ShiftDto): Boolean = oldItem == newItem
}