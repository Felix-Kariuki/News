package com.example.news.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.news.ui.activities.MainActivity
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class SplashScreen : AppCompatActivity() {

    private var mInterstitialAd: InterstitialAd? = null
    private var TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(this,"ca-app-pub-5201606964951300/3352513614", adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.d(TAG, adError.message)
                    mInterstitialAd = null
                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d(TAG, "Ad was loaded.")
                    mInterstitialAd = interstitialAd
                }
            })

        val time: Long = 1000

        Handler(Looper.myLooper()!!).postDelayed({
            val intent  = Intent(this@SplashScreen, MainActivity::class.java)
            showInterAd()
            startActivity(intent)
            finish()
        },time)
    }

    private fun showInterAd() {
        if (mInterstitialAd!=null){
            mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    super.onAdFailedToShowFullScreenContent(p0)
                }

                override fun onAdShowedFullScreenContent() {
                    super.onAdShowedFullScreenContent()
                }

                override fun onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent()
                    val intent  = Intent(this@SplashScreen, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                override fun onAdImpression() {
                    super.onAdImpression()
                }
            }
            mInterstitialAd?.show(this)
        }else {
            val intent  = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}