package `in`.playo.newstask.rest.`class`

import `in`.playo.newstask.rest.interfaces.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {

    var BASE_URL = "https://newsapi.org/"
    private var retrofit: Retrofit? = null

    fun create() : ApiInterface {

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit.create(ApiInterface::class.java)

    }
}