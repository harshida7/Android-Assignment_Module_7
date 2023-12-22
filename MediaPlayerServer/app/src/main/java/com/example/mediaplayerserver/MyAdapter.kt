package com.example.mediaplayerserver


import android.content.Context
import android.content.Intent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView


class MyAdapter(var context: Context,var list: List<Model>):RecyclerView.Adapter<MyViewDashboard>()
{
    lateinit var apiinterface: Apiinterface

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewDashboard
    {
        var  layoutInflater= LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.design_song_list,parent,false)
        return MyViewDashboard(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewDashboard , position: Int)
    {

        holder.textSongnm.setText(list.get(position).song_name)
        holder.textSingernm.setText(list.get(position).singer_name)
        Picasso.get().load(list.get(position).song_img).into(holder.imageview)

        holder.itemView.setOnClickListener{

            holder.itemView.setOnClickListener {

                var i = Intent(context,FullScreenActivity::class.java)
                i.putExtra("mypos",position)
                i.putExtra("songname",list.get(position).song_name)
                i.putExtra("singernm",list.get(position).singer_name)
                i.putExtra("img",list.get(position).song_img)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(i)


            }


        }

    }
}
class MyViewDashboard(Itemview:View):RecyclerView.ViewHolder(Itemview)
{
    var textSongnm: TextView = Itemview.findViewById(R.id.txtsong_name)
    var textSingernm: TextView = Itemview.findViewById(R.id.txtsinger_name)
    var imageview: CircleImageView = Itemview.findViewById(R.id.img1)

}