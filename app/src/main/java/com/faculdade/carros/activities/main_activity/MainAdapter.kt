package com.faculdade.carros.activities.main_activity

import android.support.annotation.DrawableRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.faculdade.carros.R

class MainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = CarFactory.getListDefault()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        return MainHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.holder_main, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainHolder).bind(list[position])
    }

}

class MainHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val textViewTitle = view.findViewById<TextView>(R.id.title)
    private val textViewModel = view.findViewById<TextView>(R.id.model)
    private val textViewYear = view.findViewById<TextView>(R.id.year)
    private val textViewColor = view.findViewById<TextView>(R.id.color)
    private val image = view.findViewById<ImageView>(R.id.imageview)

    private lateinit var car: CarEntity

    init {
        itemView
            .findViewById<View>(R.id.button)
            .setOnClickListener {
                Toast.makeText(textViewModel.context, "Carro clicado: " + car.name, Toast.LENGTH_SHORT).show()
            }
    }

    fun bind(car: CarEntity) {
        this.car = car
        textViewTitle.text = car.name
        textViewModel.text = car.model
        textViewYear.text = car.year
        textViewColor.text = car.color


        image.setImageResource(car.drawable)
    }

}

data class CarEntity(
    val name: String,
    val year: String,
    val model: String,
    val color: String,
    @DrawableRes val drawable: Int
)