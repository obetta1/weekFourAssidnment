package com.example.myrecyclerviewsharedelement

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


    class AdapterClass( var contactList : List<DeteilContact>): RecyclerView.Adapter<AdapterClass.ViewHolder>() {

        private lateinit var  mListener :onItemClickListener


        inner class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
            init {
                itemView.setOnClickListener{
                    listener.onItemClick(adapterPosition)
                }
            }

        }

        interface onItemClickListener {

            fun onItemClick(position: Int)
        }
        fun setOnItemClickListener(listener: onItemClickListener){
            mListener  = listener

        }



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterClass.ViewHolder {
            val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.activity_contact, parent, false)
            return ViewHolder(itemView, mListener)
        }

        override fun getItemCount(): Int {
            return contactList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            var curr = contactList[position]

            holder.apply {
                var image_person: ImageView = itemView.findViewById(R.id.image_person)
                var days_left: TextView = itemView.findViewById(R.id.name)

                image_person.setImageResource(curr.image)
                days_left.text = curr.name
            }


        }
    }