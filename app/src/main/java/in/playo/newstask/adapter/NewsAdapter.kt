package `in`.playo.newstask.adapter

import `in`.playo.newstask.R
import `in`.playo.newstask.activity.WebViewActivity
import `in`.playo.newstask.apputils.Constants
import `in`.playo.newstask.models.Articles
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.squareup.picasso.Picasso


class NewsAdapter(
    private val context: Context,
    var fragmentManager: FragmentManager,
    var newsArticlesList: MutableList<Articles>
) : PagerAdapter() {

    override fun getCount(): Int {
        return newsArticlesList.size ?: 0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflater.inflate(R.layout.viewpager_newsarticle, container, false)
        val iv_imageview=itemView.findViewById<ImageView>(R.id.iv_imageview)
        val tv_author=itemView.findViewById<TextView>(R.id.tv_author)
        val tv_description=itemView.findViewById<TextView>(R.id.tv_description)
        val tv_title=itemView.findViewById<TextView>(R.id.tv_title)
        val tv_seefull=itemView.findViewById<TextView>(R.id.tv_seefull)
        tv_seefull.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra(Constants.DATA, newsArticlesList.get(position).url)
            intent.putExtra(Constants.TITLE, newsArticlesList.get(position).title)
            context.startActivity(intent)
        })
       if(newsArticlesList.get(position).urlToImage!=null) {
           Picasso.get()
               .load(newsArticlesList.get(position).urlToImage)
               .into(iv_imageview)
       }
        if(newsArticlesList.get(position).author!=null){
            tv_author.setText(newsArticlesList.get(position).author)
        }
        if(newsArticlesList.get(position).title!=null){
            tv_title.setText(newsArticlesList.get(position).title)
        }
        if(newsArticlesList.get(position).description!=null){
            tv_description.setText(newsArticlesList.get(position).description)
        }
        (container as ViewPager).addView(itemView)
        return itemView
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as LinearLayout)
    }

}