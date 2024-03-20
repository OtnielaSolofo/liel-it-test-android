package solofo.otniela.test_mobile_android

import retrofit2.http.GET
import solofo.otniela.test_mobile_android.Models.Bank

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiService {
    @GET("banks.json")
    suspend fun getBanks(): List<Bank>
}


val retrofit = Retrofit.Builder()
    .baseUrl("https://cdf-test-mobile-default-rtdb.europe-west1.firebasedatabase.app/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val apiService = retrofit.create(ApiService::class.java)