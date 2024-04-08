package kz.rdd

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.animation.DecelerateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.splashscreen.SplashScreenViewProvider
import kz.rdd.core.ui.theme.AppTheme
import kz.rdd.core.utils.ext.checkIsNeedLocalizing
import kz.rdd.core.utils.ext.getLocale
import kz.rdd.core.utils.ext.setLocale
import kz.rdd.main.start.GlobalViewModel
import kz.rdd.main.start.StartNavigationScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<GlobalViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
//        installSplashScreen().run {
//            setOnExitAnimationListener {
//                it.animateSplashScreenExit {
//                    enableEdgeToEdge(
//                        statusBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT)
//                    )
//                }
//            }
//            setKeepOnScreenCondition {
//                viewModel.keepScreenWhenCondition()
//            }
//        }
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT),
        )
        super.onCreate(savedInstanceState)

        val languageCode = viewModel.userStore.language.code
        if (checkIsNeedLocalizing(languageCode)) {
            setLocale(languageCode)
            recreate()
        }

        setContent {
            val locale = getLocale()
            LaunchedEffect(locale) {
                viewModel.setLocaleChanged(locale)
            }
            AppTheme(
                currentLocale = locale
            ) {
                StartNavigationScreen(viewModel)
            }
        }
    }

    private fun SplashScreenViewProvider.animateSplashScreenExit(
        onEnd: () -> Unit,
    ) {
        view.animate()
            .setListener(object : AnimatorListener {
                override fun onAnimationStart(animation: Animator) = Unit
                override fun onAnimationCancel(animation: Animator) = Unit
                override fun onAnimationRepeat(animation: Animator) = Unit
                override fun onAnimationEnd(animation: Animator) {
                    this@animateSplashScreenExit.remove()
                    onEnd()
                }
            })
            .alpha(0f)
            .setInterpolator(DecelerateInterpolator())
            .setDuration(200)
            .start()
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }
    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }
}
