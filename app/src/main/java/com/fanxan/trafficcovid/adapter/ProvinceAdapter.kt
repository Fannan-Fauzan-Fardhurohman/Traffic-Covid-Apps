package com.fanxan.trafficcovid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fanxan.trafficcovid.R
import com.fanxan.trafficcovid.model.ProvinceResponse
import kotlinx.android.synthetic.main.item_row.view.*

class ProvinceAdapter (private var list:ArrayList<ProvinceResponse>):
    RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>() {
    inner class ProvinceViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(province: ProvinceResponse) {
            with(itemView) {
                tvName.text = province.attributes.province
                tvPositive.text = province.attributes.positive.toString()
                tvRecover.text = province.attributes.recover.toString()
                tvDeath.text = province.attributes.death.toString()

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
//        TODO("Not yet implemented")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)
        return ProvinceViewHolder(view)
    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
//        TODO("Not yet implemented")
        holder.bind(list[position])
    }
}