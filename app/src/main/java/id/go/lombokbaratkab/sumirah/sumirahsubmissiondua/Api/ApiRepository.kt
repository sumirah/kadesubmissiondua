package id.go.lombokbaratkab.sumirah.sumirahsubmissiondua.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiRepository {
    val BASE_URL = "https://www.thesportsdb.com"
    val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
}