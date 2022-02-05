package com.headyapps.libertybaptist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.headyapps.libertybaptist.ui.theme.LibertyBaptistTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibertyBaptistTheme {
               Scaffold(

                   topBar = {TopBar(
                       // When menu is clicked open the
                       // drawer in coroutine scope
                       onMenuClicked = {

                       })},
                   drawerContent = {MyDrawer()}

               ) {

               }

            }
        }
    }
}
@Composable
fun TopBar(onMenuClicked: () -> Unit) {

    // TopAppBar Composable
    TopAppBar(
        // Provide Title
        title = {
            Text(text = "Liberty Baptist Church", color = Color.White)
        },
        // Provide the navigation Icon (Icon on the left to toggle drawer)
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",

                // When clicked trigger onClick
                // Callback to trigger drawer open
                modifier = Modifier.clickable(onClick = onMenuClicked),
                tint = Color.White
            )
        },
        // background color of topAppBar
        backgroundColor = Color(0xFF7C4DFF)
    )
}

@Preview(showBackground = true)
@Composable
fun MyDrawer (){
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center


        ){

            Image(
                painter = painterResource(R.drawable.logo_header_lbc),
                contentDescription = "avatar",
                contentScale = ContentScale.Crop,            // crop the image if it's not a square
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(10))                       // clip to the circle shape
                    .border(4.dp, Color.DarkGray, RoundedCornerShape(10))   // add a border (optional)
            )

            Text(text = "User Name", modifier = Modifier.padding(5.dp), fontFamily = FontFamily.Monospace)
        }

        DrawerRow(name = "Home", icon = R.drawable.ic_menu_home)
        DrawerRow(name = "Notifications", icon = R.drawable.ic_menu_notifications)
        DrawerRow(name = "Bible", icon = R.drawable.ic_menu_bible)
        DrawerRow(name = "Blog", icon = R.drawable.ic_menu_blog)
        DrawerRow(name = "Media", icon = R.drawable.ic_menu_video)
        DrawerRow(name = "Events", icon = R.drawable.ic_menu_calender)
        Divider(color = Color.Black, thickness = 1.dp)
        DrawerRow(name = "Settings", icon = R.drawable.ic_menu_settings)
        DrawerRow(name = "About", icon = R.drawable.ic_menu_about)




    }
}

@Composable
fun DrawerRow(name: String, icon: Int){
    Row(
        modifier = Modifier
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,

    ){

        Image(painter = painterResource(icon),
            contentDescription = "Icon Home",
            modifier = Modifier
                .size(15.dp)
        )
        Text(text = name, modifier = Modifier.padding(10.dp))
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LibertyBaptistTheme {
        Greeting("Android")
    }
}
