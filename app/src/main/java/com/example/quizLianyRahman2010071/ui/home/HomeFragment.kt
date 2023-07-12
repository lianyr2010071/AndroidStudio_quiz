package com.example.quizLianyRahman2010071.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizLianyRahman2010071.Adapter.AdapterMahasiswa
import com.example.quizLianyRahman2010071.App.ApiConfig
import com.example.quizLianyRahman2010071.Model.MahasiswaModel
import com.example.quizLianyRahman2010071.Model.ResponModel
import com.example.quizLianyRahman2010071.R
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {
    lateinit var rvMahasiswa: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        init(view)
        getMahasiswa()
        return view
    }

    private var listMahasiswa: ArrayList<MahasiswaModel> = ArrayList()

    fun getMahasiswa(){
        ApiConfig.instanceRetrofit.getMahasiswa().enqueue(object :
            retrofit2.Callback<ResponModel> {

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val res = response.body()!!
                listMahasiswa = res.mahasiswa
                displayMahasiswa()
            }
            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                Toast.makeText(requireActivity(), "Error :"+t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    fun displayMahasiswa() {
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvMahasiswa.adapter = AdapterMahasiswa(requireActivity(), listMahasiswa)
        rvMahasiswa.layoutManager = layoutManager
    }

    fun init(view: View) {
        rvMahasiswa=view.findViewById(R.id.recyler_view)
    }
}