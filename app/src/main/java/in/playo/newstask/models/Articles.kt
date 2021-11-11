package `in`.playo.newstask.models

import java.io.Serializable

class Articles : Serializable {

   // var source: MutableList<Source>? = null
    var author: String? = null
    var title: String? = null
    var description: String? = null
    var url:String?=null
    var urlToImage:String?=null
    var publishedAt:String?=null
    var content:String?=null
}
