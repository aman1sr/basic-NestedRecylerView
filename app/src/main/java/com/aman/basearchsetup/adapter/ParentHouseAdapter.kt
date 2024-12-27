package com.aman.basearchsetup.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aman.basearchsetup.databinding.ItemRowParentBinding
import com.aman.basearchsetup.model.got.GOTResponseItem

class ParentHouseAdapter: ListAdapter<GOTResponseItem,ParentHouseAdapter.ParentViewHolder>(diffUtil) {

    object diffUtil : DiffUtil.ItemCallback<GOTResponseItem>(){
        override fun areItemsTheSame(oldItem: GOTResponseItem, newItem: GOTResponseItem): Boolean {
         return (oldItem.slug == newItem.slug)
        }
        override fun areContentsTheSame(
            oldItem: GOTResponseItem,
            newItem: GOTResponseItem
        ): Boolean {
            return (oldItem == newItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
       val view = ItemRowParentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val houseItem = getItem(position)
        holder.bind(houseItem)
    }

    inner class ParentViewHolder(view: ItemRowParentBinding): RecyclerView.ViewHolder(view.root){
        private val adapter = ChildMemberAdapter()
        val txtHouseName = view.txtHouseName

        init {
            // Set up child RecyclerView only once
            view.rvChild.layoutManager = LinearLayoutManager(view.root.context, LinearLayoutManager.HORIZONTAL, false)
            view.rvChild.adapter = adapter
        }

        fun bind(houseItem: GOTResponseItem) {
            txtHouseName.text = houseItem.name
            adapter.submitList(houseItem.members) // Update list in the adapter
        }
    }
}