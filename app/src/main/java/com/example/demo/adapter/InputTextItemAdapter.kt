package com.example.demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.R
import kotlinx.android.synthetic.main.item_layout.view.*

class InputTextItemAdapter (private val mDataSet : List<String> ) :
    RecyclerView.Adapter<InputTextItemAdapter.InputViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, postion: Int): InputViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return InputViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: InputViewHolder, postion: Int) {
        viewHolder.bindPlace(mDataSet[postion])
    }

    override fun getItemCount() = mDataSet.size

    class InputViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bindPlace(value: String) {
             view.tvName.text = value
        }
    }
}