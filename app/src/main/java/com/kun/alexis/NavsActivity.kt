package com.kun.alexis

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.ai.client.generativeai.Chat
import com.kun.alexis.ui.theme.AlexisTheme

class NavsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bottom()
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun Bottom(){

    var searchQuery by remember {
        mutableStateOf(TextFieldValue(text = ""))
    }

    Scaffold(

        content = {
            Column {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
//
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LazyColumn {

                        item {

                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxSize()
                                    .fillMaxHeight(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {


                                Card(
                                    colors = CardDefaults.cardColors(Color.Red),
                                    shape = RoundedCornerShape(5.dp),
                                    modifier = Modifier

                                        .fillMaxWidth()
                                        .fillMaxSize()



                                    //                    elevation = CardDefaults.cardElevation(10.dp)

                                ) {

                                    Column(
                                        modifier = Modifier
                                            .padding(17.dp)
                                    ) {
                                        Text(
                                            text = "Location",
                                            fontFamily = FontFamily.Monospace,
                                            fontSize = 11.sp,
                                            color = Color.White,
                                            modifier = Modifier
                                                .padding(bottom = 4.dp)
                                        )
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                androidx.compose.material3.Icon(
                                                    imageVector = Icons.Default.LocationOn,
                                                    contentDescription = "Location icon",
                                                    tint = Color.White,
                                                    modifier = Modifier.size(16.dp)
                                                )
                                                Spacer(
                                                    modifier = Modifier
                                                        .width(4.dp)
                                                )

                                                Text(
                                                    text = "New York, USA",
                                                    fontFamily = FontFamily.Monospace,
                                                    fontSize = 11.sp,
                                                    color = Color.White,
                                                    textAlign = TextAlign.Center
                                                )
                                                androidx.compose.material3.Icon(
                                                    imageVector = Icons.Default.KeyboardArrowDown,
                                                    contentDescription = "Filter Icon",
                                                    tint = Color.White
                                                )
                                            }
                                            Box(
                                                modifier = Modifier
                                                    .size(20.dp)
                                                    .background(
                                                        Color.White.copy(alpha = 0.4f),
                                                        shape = RoundedCornerShape(2.dp)
                                                    )
                                            ) {
                                                androidx.compose.material3.Icon(
                                                    imageVector = Icons.Default.Notifications,
                                                    contentDescription = "Notification Icon",
                                                    tint = Color.White,
                                                    modifier = Modifier
                                                        .size(16.dp)
                                                )
                                            }
                                        }
                                        Spacer(
                                            modifier = Modifier
                                                .height(16.dp)
                                        )

                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                        ) {
                                            TextField(
                                                value = searchQuery,
                                                onValueChange = { searchQuery = it },
                                                singleLine = true,
                                                label = { Text(text = "Search") }
                                            )
                                            Box(
                                                modifier = Modifier
                                                    .size(40.dp)
                                                    .background(
                                                        Color.White,
                                                        shape = RoundedCornerShape(2.dp)
                                                    )
                                            ) {
                                                androidx.compose.material3.IconButton(
                                                    onClick = { },
                                                    modifier = Modifier
                                                        .size(50.dp)
                                                ) {
                                                    androidx.compose.material3.Icon(
                                                        imageVector = Icons.Default.Search,
                                                        contentDescription = "Filter Icon",
                                                        tint = Color.Red
                                                    )
                                                }
                                            }
                                        }

                                        Spacer(
                                            modifier = Modifier
                                                .height(16.dp)
                                        )

                                    }
                                }
                            }

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            {
                                Text(
                                    text = "#SpecialForYou",
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 11.sp,
                                )

                                Text(
                                    text = "See All",
                                    modifier = Modifier,
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 11.sp,
                                    color = Color.Red,
                                )

                            }
                            Spacer(
                                modifier = Modifier
                                    .height(5.dp)
                            )


                            Row(horizontalArrangement = Arrangement.SpaceBetween)
                            {

                                Card(
                                    colors = CardDefaults.cardColors(Color.Red),
                                    shape = RoundedCornerShape(5.dp),
                                    modifier = Modifier
                                        .padding(10.dp)
                                        .height(70.dp)
                                        .padding(100.dp),

                                    elevation = CardDefaults.cardElevation(10.dp)

                                ) {
                                    Text(
                                        text = "Get Special Offer",
                                        modifier = Modifier,
                                        fontFamily = FontFamily.Monospace,
                                        fontSize = 11.sp,
                                        color = Color.White,
                                    )

                                }
                            }
                            Spacer(
                                modifier = Modifier
                                    .height(5.dp)
                            )


                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            {
                                Text(
                                    text = "Category",
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Black
                                )

                                Text(
                                    text = "See All",
                                    modifier = Modifier,
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 11.sp,
                                    color = Color.Red,
                                )

                                Spacer(
                                    modifier = Modifier
                                        .height(5.dp)
                                )

                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                //                verticalAlignment = Alignment.Top,
                                horizontalArrangement = Arrangement.SpaceAround
                            )
                            {

                                Image(
                                    painter = painterResource(id = R.drawable.clothes),
                                    contentDescription = "Clothes icon",
                                    modifier = Modifier
                                        .size(75.dp)
                                        .clip(CircleShape)
                                        .background(Color.Red)
                                        .border(5.dp, Color.Gray, CircleShape)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.electronics),
                                    contentDescription = "Electronics icon",
                                    modifier = Modifier
                                        .size(75.dp)
                                        .clip(CircleShape)
                                        .background(Color.Red)
                                        .border(5.dp, Color.Gray, CircleShape)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.shoes),
                                    contentDescription = "Shoes icon",
                                    modifier = Modifier
                                        .size(75.dp)
                                        .clip(CircleShape)
                                        .background(Color.Red)
                                        .border(5.dp, Color.Gray, CircleShape)
                                )
                                Image(
                                    painter = painterResource(id = R.drawable.watch),
                                    contentDescription = "watch icon",
                                    modifier = Modifier
                                        .size(75.dp)
                                        .clip(CircleShape)
                                        .background(Color.Red)
                                        .border(5.dp, Color.Gray, CircleShape)
                                )

                            }

                            Spacer(modifier = Modifier
                                .height(10.dp))

                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                            )
                            {
                                Text(
                                    text = "Flash Sale",
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Black
                                )
                            }

                            Spacer(modifier = Modifier
                                .height(15.dp))


                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                            ){
                                Button(onClick = { /*TODO*/ },
                                    shape = RoundedCornerShape(10.dp),
                                    border = BorderStroke(1.dp, Color.Red),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.White,
                                        contentColor = Color.Black,
                                    ),
                                    modifier = Modifier
                                        .padding(2.dp),
                                )
                                {
                                    Text(text = "All",
                                        fontFamily = FontFamily.SansSerif,
                                        fontSize = 15.sp)
                                }
                                Button(onClick = { /*TODO*/ },
                                    shape = RoundedCornerShape(10.dp),
                                    border = BorderStroke(1.dp, Color.Red),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.White,
                                        contentColor = Color.Black,
                                    ),
                                    modifier = Modifier
                                        .padding(2.dp),
                                )
                                {
                                    Text(text = "Newest",
                                        fontFamily = FontFamily.SansSerif,
                                        fontSize = 15.sp)
                                }

                                Button(onClick = { /*TODO*/ },
                                    shape = RoundedCornerShape(10.dp),
                                    border = BorderStroke(1.dp, Color.Red),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.White,
                                        contentColor = Color.Black,
                                    ),
                                    modifier = Modifier
                                        .padding(2.dp),
                                )
                                {
                                    Text(text = "Popular",
                                        fontFamily = FontFamily.SansSerif,
                                        fontSize = 15.sp)
                                }

                                Button(onClick = { /*TODO*/ },
                                    shape = RoundedCornerShape(10.dp),
                                    border = BorderStroke(1.dp, Color.Red),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.White,
                                        contentColor = Color.Black,
                                    ),
                                    modifier = Modifier
                                        .padding(2.dp),
                                )
                                {
                                    Text(text = "Clothes",
                                        fontFamily = FontFamily.SansSerif,
                                        fontSize = 15.sp)
                                }

                            }





                        }
                    }




                }
            }

        },


        bottomBar = {BottomBar()}

    )
}

@Composable
fun BottomBar() {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(elevation = 10.dp) {
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"")
        },
            label = { Text(text = "Home") }, selected = (selectedIndex.value == 0), onClick = {
                selectedIndex.value = 0
            })


        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Favorite,"")
        },
            label = { Text(text = "Favorite") }, selected = (selectedIndex.value == 1), onClick = {
                selectedIndex.value = 1
            })
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Person, "")
        },
            label = { Text(text = "Profile") }, selected = (selectedIndex.value == 2), onClick = {
                selectedIndex.value = 2
            })
    }
}