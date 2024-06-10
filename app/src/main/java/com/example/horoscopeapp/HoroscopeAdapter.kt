package com.example.horoscopeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HoroscopeAdapter(private val dataSet: List<Horoscope>) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    // Este método se llama para crear nuevas celdas,
    // y se crear las justas para mostrar en pantalla,
    // Ya que intentará reciclar las que no se vean
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_horoscope, parent, false)

        return HoroscopeViewHolder(view)
    }

    // Este método simplemente es para decir cuantos elementos queremos mostrar
    override fun getItemCount(): Int {
        return dataSet.size
    }

    // Este método se llama cada vez que se va a visualizar una celda,
    // y lo utilizaremos para mostrar los datos de esa celda
    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        val horoscope = dataSet[position]
        holder.textView.text = horoscope.name

    }

}

// Esta clase se encarga de guardarnos la vista y no tener que inflarla de nuevo
class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView

    init {
        textView = view.findViewById(R.id.nameTextView)
    }
}