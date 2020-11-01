package com.squishy.gridpractice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squishy.gridpractice.R
import com.squishy.gridpractice.models.Model

class MyGridAdapter(var ctx: Context, var items: ArrayList<Model>) : RecyclerView.Adapter<MyGridAdapter.ViewHolder>() {

    open class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {}
    class GridViewHolder(view: View) : ViewHolder(view) {
        var gridImage : ImageView = view.findViewById(R.id.cell_grid_img)
        var header: TextView = view.findViewById(R.id.cell_grid_txt_header)
        var footer: TextView = view.findViewById(R.id.cell_grid_txt_footer)
    }
    class HeaderViewHolder(view: View) : ViewHolder(view) {
        var header: TextView = view.findViewById(R.id.cell_header_txt)

    }
    class InfoViewHolder(view: View) : ViewHolder(view) {
        var info : TextView = view.findViewById(R.id.cell_info_txt)
    }

    override fun getItemViewType(position: Int): Int {
        return items.get(position).type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        when (viewType) {
            0 -> return GridViewHolder(LayoutInflater.from(ctx).inflate(R.layout.cell_model, parent, false))
            1 -> return HeaderViewHolder(LayoutInflater.from(ctx).inflate(R.layout.cell_header, parent, false))
            2 -> return InfoViewHolder(LayoutInflater.from(ctx).inflate(R.layout.cell_info, parent, false))
            else -> return GridViewHolder(LayoutInflater.from(ctx).inflate(R.layout.cell_model, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is GridViewHolder) {
            if (!items[position].active) {
                holder.gridImage.alpha = 0.5f
                holder.footer.alpha =0.5f
                holder.header.alpha =0.5f
            } else {
                holder.gridImage.alpha = 1f
                holder.footer.alpha =1f
                holder.header.alpha =1f
            }
            holder.header.text = items[position].header
            holder.footer.text = items[position].footer
        } else if ( holder is HeaderViewHolder) {
            holder.header.text = items[position].header
        } else if (holder is InfoViewHolder) {
            holder.info.text = items[position].header
        }
    }

}