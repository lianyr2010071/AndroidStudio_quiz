package com.example.quizLianyRahman2010071.App
import com.example.quizLianyRahman2010071.Model.MahasiswaModel
import com.example.quizLianyRahman2010071.Model.ResponModel
import retrofit2.Call
import retrofit2.http.*
interface ApiService {
    @FormUrlEncoded
    @POST("mahasiswa/save")
    fun saveBarang(
        @Body data: MahasiswaModel,
    ):Call<ResponModel>
    @GET("mahasiswa")
    fun getMahasiswa():Call<ResponModel>
}

