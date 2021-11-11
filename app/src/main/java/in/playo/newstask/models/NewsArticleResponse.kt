package `in`.playo.newstask.models

import java.io.Serializable

class NewsArticleResponse :Serializable {

    var status:String?=null
    var totalResults:Int?=null
    var articles:MutableList<Articles>?=null
}