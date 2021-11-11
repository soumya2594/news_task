package `in`.playo.newstask.activity

import `in`.playo.newstask.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.schedule

class SplashActivity:AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        delayTime();
    }

    fun delayTime(){
        Timer().schedule(2000) {
            gotoNavigationScreen()
        }
    }


    private fun gotoNavigationScreen() {
        val intent = Intent(this, NewsActivity::class.java)
        startActivity(intent)
    }

}