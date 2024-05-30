package com.kun.alexis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kun.alexis.ui.theme.AlexisTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Page()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Page() {

    var name by remember {
        mutableStateOf(TextFieldValue(text = ""))
    }

    Column {
        Card(
            colors = CardDefaults.cardColors(Color.Red),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .padding(10.dp)
                .height(70.dp)
                .padding(100.dp),

            elevation = CardDefaults.cardElevation(10.dp)

        ){
            OutlinedTextField(value = name,
                onValueChange ={name=it},
                label = { Text(text = "Email") },
                )

        }
    }




}




