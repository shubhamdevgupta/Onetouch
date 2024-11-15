package com.androiddev.vastushikar.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androiddev.vastushikar.R
import com.androiddev.vastushikar.utils.extns.fullScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class SplashActivity @Inject constructor() : AppCompatActivity() {

  /*  @Inject
    lateinit var localDB: LocalDB

    @Inject
    lateinit var appPreference: AppPreference
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        fullScreen()
      //  cleanUpDB()
        delayAndLaunchLoginActivity()
    }

    private fun delayAndLaunchLoginActivity() {
        val timer: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(2500)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    val loginIntent = Intent(this@SplashActivity, AuthActivity::class.java)
                    startActivity(loginIntent)
                    finish()
                }
            }
        }
        timer.start()
    }
/*
    private fun cleanUpDB() {
        val loginCount = appPreference.loginCount
        if (11 % loginCount == 0) {
            localDB.deleteAllData()
            appPreference.loginCount = 2
        } else appPreference.loginCount = loginCount + 1
    }*/

}