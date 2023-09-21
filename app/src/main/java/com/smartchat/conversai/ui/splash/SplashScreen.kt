package com.smartchat.conversai.ui.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.smartchat.conversai.ConversAIApp
import com.smartchat.conversai.R
import com.smartchat.conversai.common.findActivity
import com.smartchat.conversai.ui.upgrade.PurchaseHelper
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateToStartChat: () -> Unit,
    purchaseHelper: PurchaseHelper
) {
    val context = LocalContext.current
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2000
        )
    )
    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(2000)
        navigateToStartChat()
    }
    LaunchedEffect(key1 = true) {
        startAnimation = true
        val application = context.findActivity()?.application as ConversAIApp
        var needShowAds = true

        purchaseHelper.checkPurchase {
            needShowAds = it.not() //           application.needShowAds = needShowAds
        }

        delay(4500)
        // Show the app open ad.
        if (needShowAds) {
            context.findActivity()?.let {
                application.showAdIfAvailable(
                    it,
                    object : ConversAIApp.OnShowAdCompleteListener {
                        override fun onShowAdComplete() {
                            navigateToStartChat()
                        }
                    })
            }
        }else{
            navigateToStartChat()
        }

    }

    SplashDesign(alpha = alphaAnimation.value)
}

@Composable
fun SplashDesign(alpha: Float) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .size(200.dp)
                .alpha(alpha = alpha),
            painter = painterResource(id = R.drawable.app_icon),
            contentDescription = stringResource(R.string.app_icon),
        )
    }
}

