import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.wtf.sootheapp.R


@Composable
fun NavBar(modifier: Modifier = Modifier){
    NavigationBar(
        contentColor = MaterialTheme.colorScheme.surface,
        modifier = modifier)
    {
        NavigationBarItem(
            icon = {
                Icon(imageVector = Icons.Default.Home, contentDescription ="null" )
            } ,
            label = {
                Text(text = stringResource(id = R.string.bottom_navigation_home))
            },
            selected = false,
            onClick = { }
        )

        NavigationBarItem(
            selected = false, onClick = { },
            icon = {
                Icon(imageVector = Icons.Default.AccountCircle,
                    contentDescription = "null")
            },
            label = {
                Text(text = stringResource(id = R.string.bottom_navigation_profile))
            }

        )
    }

}


@Composable
fun AppNavRail(modifier: Modifier = Modifier){
    NavigationRail(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier.padding(start = 8.dp, end = 8.dp ))
    {
        Column(Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                selected = false,
                onClick = { },
                icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "null" ) },
                label = {
                    Text(text = stringResource(id = R.string.bottom_navigation_home))
                }
            )

            NavigationRailItem(
                selected = false,
                onClick = { },
                icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "null" ) },
                label = {
                    Text(text = stringResource(id = R.string.bottom_navigation_profile))
                }
            )
        }
    }
}