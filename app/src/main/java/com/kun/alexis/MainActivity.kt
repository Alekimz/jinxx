package com.kun.alexis

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kun.alexis.ui.theme.AlexisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Alex()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Alex() {
    var searchQuery by remember {
        mutableStateOf(TextFieldValue(text = ""))
    }

    LazyColumn{

        item {

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){


                Card(
                    colors = CardDefaults.cardColors(Color.Red),
                    shape = RoundedCornerShape(5.dp),
                    modifier = Modifier
//                        .padding(10.dp)
//                        .height(70.dp)
                        .fillMaxWidth()
                        .fillMaxSize()
//                        .padding(10.dp),

//                    elevation = CardDefaults.cardElevation(10.dp)

                ){

                    Column(
                        modifier = Modifier
                            .padding(17.dp)
                    ) {
                       Text(
                           text ="Location",
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
                            Row (
                                verticalAlignment = Alignment.CenterVertically
                            ){
                               Icon(
                                   imageVector = Icons.Default.LocationOn ,
                                   contentDescription ="Location icon",
                                   tint = Color.White,
                                   modifier = Modifier.size(16.dp)
                               )
                                Spacer(
                                    modifier = Modifier
                                        .width(4.dp))
                                
                                Text(
                                    text ="New York, USA",
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 11.sp,
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )
                                Icon(
                                    imageVector =Icons.Default.KeyboardArrowDown ,
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
                            ){
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription ="Notification Icon" ,
                                    tint = Color.White,
                                    modifier = Modifier
                                        .size(16.dp)
                                    )
                            }
                        }
                    Spacer(modifier = Modifier
                            .height(16.dp))

                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            TextField(
                                value = searchQuery,
                                onValueChange ={searchQuery = it},
                                singleLine = true,
                                label = {Text(text = "Search")}
                            )
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(
                                        Color.White,
                                        shape = RoundedCornerShape(2.dp)
                                    )){
                                IconButton(
                                    onClick = { },
                                    modifier = Modifier
                                        .size(50.dp)
                                ) {
                                    Icon(imageVector = Icons.Default.Search,
                                        contentDescription ="Filter Icon",
                                        tint = Color.Red)
                                }
                            }
                        }

                        Spacer(modifier =Modifier
                            .height(16.dp))

                        }
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth())
                {
                    Text(
                        text ="#SpecialForYou",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "See All",
                        modifier = Modifier,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 11.sp,
                        color = Color.Red,
                        textAlign = TextAlign.Center
                        )

                }
                Spacer(modifier = Modifier
                .height(5.dp))


            Row (horizontalArrangement = Arrangement.SpaceBetween)
            {

                 Card(
                     colors = CardDefaults.cardColors(Color.Red),
                     shape = RoundedCornerShape(5.dp),
                     modifier = Modifier
                         .padding(10.dp)
                         .height(70.dp)
                         .padding(100.dp),

                     elevation = CardDefaults.cardElevation(10.dp)

                 ){
                     Text(text = "Get Special Offer",
                         modifier= Modifier,
                         fontFamily = FontFamily.Monospace,
                         fontSize = 11.sp,
                         color = Color.White,)

             }
            }
            Spacer(modifier = Modifier
                .height(5.dp))


            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                )
            {
                Text(
                    text ="Category",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Black)

                Text(
                    text = "See All",
                    modifier = Modifier,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 11.sp,
                    color = Color.Red,
                )

                Spacer(modifier = Modifier
                    .height(5.dp))

            }
            Row(modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceAround)
            {

               Image(
                   painter = painterResource(id = R.drawable.clothes),
                   contentDescription = "clothes icon",
                   contentScale = ContentScale.Crop,
                   modifier = Modifier
                       .size(128.dp)
                       .clip(CircleShape)
                       .border(5.dp, Color.Gray, CircleShape))


//                Image(painter = painterResource(id = R.drawable.electronics),
//                    contentDescription = "electronic icon",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .size(128.dp)
//                        .clip(CircleShape)
//                        .border(5.dp, Color.Gray, CircleShape),
//
//                Image(painter = painterResource(id = R.drawable.shoes),
//                    contentDescription = "shoes icon" ,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .size(128.dp)
//                        .clip(CircleShape)
//                        .border(5.dp, Color.Gray, CircleShape),
//
//                Image(painter = painterResource(id = R.drawable.watch),
//                    contentDescription = "watch icon",
//                    modifier = Modifier
//                        .size(128.dp)
//                        .clip(CircleShape)
//                        .border(5.dp, Color.Gray, CircleShape),
//                    contentScale = ContentScale.Crop,
//
//
//                )

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


    

