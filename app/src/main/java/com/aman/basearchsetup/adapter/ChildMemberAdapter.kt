package com.aman.basearchsetup.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aman.basearchsetup.R
import com.aman.basearchsetup.databinding.ItemRowChildBinding
import com.aman.basearchsetup.model.got.Member

class ChildMemberAdapter: ListAdapter<Member, ChildMemberAdapter.ChildViewHolder>(diffCallback) {

    object diffCallback : DiffUtil.ItemCallback<Member>(){
        override fun areItemsTheSame(oldItem: Member, newItem: Member): Boolean {
           return (oldItem.name == newItem.name)
        }

        override fun areContentsTheSame(oldItem: Member, newItem: Member): Boolean {
            return  (oldItem == newItem)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildMemberAdapter.ChildViewHolder {
        val view = ItemRowChildBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ChildViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildMemberAdapter.ChildViewHolder, position: Int) {
        val memberName = getItem(position)
        holder.txtName.text = memberName.name
    }
    inner class ChildViewHolder(view: ItemRowChildBinding): RecyclerView.ViewHolder(view.root) {
        val txtName =  view.txtName
    }

}