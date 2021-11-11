package `in`.playo.newstask.rest.interfaces

import `in`.playo.newstask.models.NewsArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    @GET("v2/top-headlines")
    fun getNewsAtricles(@Query("sources")sources:String?,@Query("apiKey")apiKey:String?): Call<NewsArticleResponse>


}