package com.example.quizLianyRahman2010071.Adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizLianyRahman2010071.Model.MahasiswaModel
import com.example.quizLianyRahman2010071.R
import kotlin.collections.ArrayList

class AdapterMahasiswa(var activity: Activity, var data: ArrayList<MahasiswaModel>): RecyclerView.Adapter<AdapterMahasiswa.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNobp =
            view.findViewById<TextView>(R.id.tvnobp)
        val tvNama = view.findViewById<TextView>(R.id.tvnama)
        val tvJurusan =
            view.findViewById<TextView>(R.id.tvjurusan)
        val tvAlamat =
            view.findViewById<TextView>(R.id.tvalamat)


    }
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): Holder {
        context = parent.context
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rcv_mahasiswa, parent, false)
        return Holder(view)
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int)
    {
        val a = data[position]
        holder.tvNobp.text = a.nobp
        holder.tvNama.text = a.nama
        holder.tvJurusan.text = a.jurusan
        holder.tvAlamat.text = a.alamat

    }
    override fun getItemCount(): Int {
        return data.size
    }
}
