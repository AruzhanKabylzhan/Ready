package kz.rdd.profile.presentation.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.parcelize.Parcelize
import kz.rdd.core.ui.DestinationController
import kz.rdd.core.ui.LocalDestinationController
import kz.rdd.core.ui.base.Destination
import kz.rdd.core.ui.theme.LocalAppTheme
import kz.rdd.core.ui.widgets.CenteredToolbar

@Parcelize
class AboutDestination : Destination {
    @Composable
    override fun Content(controller: DestinationController) {
        AboutScreen()
    }
}

@Composable
fun AboutScreen(
    controller: DestinationController = LocalDestinationController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalAppTheme.colors.bg1),
    ) {
        CenteredToolbar(
            title = "About",
            titleStyle = LocalAppTheme.typography.l17,
            isNavigationIconVisible = true,
            onNavigationIconClick = controller::navigateBack
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "About Application",
            style = LocalAppTheme.typography.l22,
            color = LocalAppTheme.colors.main,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Mobile marketplace for homemade food with a focus on needs and inclusivity.",
            style = LocalAppTheme.typography.l18,
            color = LocalAppTheme.colors.primaryText,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}