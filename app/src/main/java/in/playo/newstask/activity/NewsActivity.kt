package `in`.playo.newstask.activity

import `in`.playo.newstask.R
import `in`.playo.newstask.adapter.NewsAdapter
import `in`.playo.newstask.apputils.Constants
import `in`.playo.newstask.models.NewsArticleResponse
import `in`.playo.newstask.rest.`class`.ApiClient
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class NewsActivity:AppCompatActivity() {

    var newsAdapter: NewsAdapter? = null
    var viewPager: ViewPager? = null
    var newsArticleResponse: NewsArticleResponse? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        initViewPager()
    }

    fun initViewPager() {
        viewPager=findViewById(R.id.viewpager)
        getNewsArticles()
    }

    fun setViewPagerAdapter() {
        if (newsArticleResponse?.articles != null) {
            newsAdapter = NewsAdapter(
                this, supportFragmentManager,
                newsArticlesList = newsArticleResponse?.articles?: mutableListOf()
            )

            viewPager?.adapter = newsAdapter
        }
    }

    fun getNewsArticles() {
        val apiInterface = ApiClient().create().getNewsAtricles("techcrunch", Constants.API_KEY)
        apiInterface.enqueue(object : Callback<NewsArticleResponse> {
            override fun onResponse(
                call: Call<NewsArticleResponse>?,
                response: Response<NewsArticleResponse>?
            ) {
                newsArticleResponse = response?.body()
                System.out.println(response?.body()?.totalResults);
                setViewPagerAdapter()
            }

            override fun onFailure(call: Call<NewsArticleResponse>, t: Throwable) {
                Toast.makeText(this@NewsActivity, t.message, Toast.LENGTH_SHORT)
            }
        })
    }
}