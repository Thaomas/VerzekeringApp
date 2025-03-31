package com.verzekeringapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.verzekeringapp.R
import com.verzekeringapp.ui.adapters.PolicyRCVAdapter.ViewHolder
import com.verzekeringapp.views.PolicyDetail

class PolicyRCVAdapter(private val list : List<PolicyDetail>): RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rcv_policies, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.policyNameTextView.text = item.name
        holder.descriptionTextView.text = item.description
        holder.customerNameTextView.text = item.customerName
        holder.insurerNameTextView.text = item.insurerName
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val customerNameTextView : TextView = itemView.findViewById(R.id.CustomerTextView)
        val insurerNameTextView: TextView = itemView.findViewById(R.id.InsurerTextView)
        val policyNameTextView: TextView = itemView.findViewById(R.id.PolicyNameTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.DescriptionTextView)
    }

}