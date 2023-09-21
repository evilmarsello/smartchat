package com.smartchat.conversai.ui.composition

import android.util.Log
import android.view.View
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.smartchat.conversai.databinding.AdmobNativeBinding
import com.smartchat.conversai.databinding.SmallAdmobNativeBinding

@Composable
fun MediumNativeAd(adId:String,
                   modifier: Modifier = Modifier){
    AndroidViewBinding(factory = AdmobNativeBinding::inflate){
        val adView = root.also { adview ->
            adview.bodyView = this.adBody
            adview.callToActionView = this.adCallToAction
            adview.headlineView = this.adHeadline
            adview.iconView = this.adAppIcon
        }

        val adLoader = AdLoader.Builder(adView.context, adId)
            .forNativeAd {  nativeAd ->

                nativeAd.advertiser?.let{advertiser ->
                    this.adAdvertiser.text = advertiser

                }
                nativeAd.body?.let {body ->
                    this.adBody.text = body
                }
                nativeAd.callToAction?.let {callToAction ->
                    this.adCallToAction.text = callToAction
                }
                nativeAd.headline?.let {headLine ->
                    this.adHeadline.text = headLine
                }
                nativeAd.icon?.let {icon ->
                    this.adAppIcon.setImageDrawable(icon.drawable)
                }
                adView.setNativeAd(nativeAd)
            }.withAdListener(object : AdListener(){
                override fun onAdLoaded() {
                    Log.d("log_ads","Native ad loaded")
                    super.onAdLoaded()
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    Log.d("log_ads","Native ad failed to load: $p0")
                    super.onAdFailedToLoad(p0)
                }
            }).build()
        adLoader.loadAd(AdRequest.Builder().build())

    }
}

@Composable
fun SmallNativeAd(adId:String,
                  modifier: Modifier = Modifier) {
    AndroidViewBinding(factory = SmallAdmobNativeBinding::inflate) {
        val adView = root.also { adview ->
            adview.bodyView = this.secondary
            adview.callToActionView = this.cta
            adview.headlineView = this.primary
            adview.iconView = this.icon
            adview.starRatingView = this.ratingBar
        }
        val adContainer = this.nativeAdView

        val adLoader = AdLoader.Builder(adView.context, adId)
            .forNativeAd { nativeAd ->
                nativeAd.advertiser?.let {
                }
                nativeAd.body?.let { body ->
                    this.secondary.text = body
                }
                nativeAd.callToAction?.let { callToAction ->
                    this.cta.text = callToAction
                }
                nativeAd.headline?.let { headLine ->
                    this.primary.text = headLine
                }
                nativeAd.icon?.let { icon ->
                    this.icon.setImageDrawable(icon.drawable)
                }
                nativeAd.starRating?.let { stars ->
                    this.ratingBar.numStars = stars.toInt()
                }


                adView.setNativeAd(nativeAd)
            }.withAdListener(object : AdListener() {
                override fun onAdLoaded() {
                    Log.d("log_ads", "Native ad loaded")
                    super.onAdLoaded()
                    adContainer.visibility = View.VISIBLE
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    Log.d("log_ads", "Native ad failed to load: $p0")
                    super.onAdFailedToLoad(p0)
                    adContainer.visibility = View.GONE
                }
            }).build()
        adLoader.loadAd(AdRequest.Builder().build())
    }
}