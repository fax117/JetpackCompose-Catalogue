package com.mx.jetpackcomposecatalog

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mx.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    var myText by remember { mutableStateOf("Fabricio") }
                    //MyTextFieldStateHoisted(myText) {myText = it}
                    MyProgressBar()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCatalogTheme {
        MyIcon()
    }
}

@Composable
fun MyProgressBar(modifier: Modifier = Modifier) {
    Column(
        modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Green, strokeWidth = 7.dp)
        LinearProgressIndicator(
            modifier.padding(top = 32.dp),
            color = Color.Blue,
            trackColor = Color.Magenta
        )
    }
}

@Composable
fun MyIcon(modifier: Modifier = Modifier) {
    Icon(imageVector = Icons.TwoTone.Star, contentDescription = "Ejemplo", tint = Color.Red)

}

@Composable
fun MyImageAdvanced(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Ejemplo",
            modifier
                .clip(CircleShape)
                .border(5.dp, Color.Red, CircleShape)
        )
    }
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Ejemplo",
        alpha = 0.9f
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldStateHoisted(name: String, onValueChanged: (String) -> Unit) {
    TextField(value = name, onValueChange = { onValueChanged(it) })
}

@Composable
fun MyButton(modifier: Modifier = Modifier) {
    var enabled by remember {
        mutableStateOf(true)
    }

    Column(
        modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = {
                Log.i("Fabricio", "Esto es un ejemplo")
                enabled = false
            }, enabled = enabled, colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta, contentColor = Color.Blue
            ), border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Hola")
        }

        OutlinedButton(
            onClick = {
                Log.i("Fabricio", "Esto es un ejemplo")
                enabled = false
            }, modifier.padding(top = 8.dp), colors = ButtonDefaults.buttonColors(
                contentColor = Color.Blue, containerColor = Color.Magenta
            )
        ) {
            Text(text = "Hola")
        }

        TextButton(onClick = {
            Log.i("Fabricio", "Esto es un ejemplo")
            enabled = false
        }) {
            Text(text = "Hola")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldOutlined(modifier: Modifier = Modifier) {
    var myText by remember { mutableStateOf("") }
    Column(modifier.fillMaxSize()) {
        OutlinedTextField(
            value = myText,
            onValueChange = { myText = it },
            modifier.padding(24.dp),
            label = { Text(text = "Holiwis") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Magenta, unfocusedBorderColor = Color.Blue
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvanced(modifier: Modifier = Modifier) {
    var myText by remember { mutableStateOf("Fabricio") }

    Column(modifier.fillMaxSize()) {
        TextField(value = myText, onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        }, label = { Text(text = "Introduce tu nombre") })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    var myText by remember { mutableStateOf("Fabricio") }
    TextField(value = myText, onValueChange = { myText = it })
}


@Composable
fun MyText(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Esto es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )
        Text(
            text = "Esto es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
        Text(
            text = "Esto es un ejemplo", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.LineThrough, TextDecoration.Underline
                    )
                )
            )
        )
        Text(text = "Esto es un ejemplo", fontSize = 36.sp)
    }
}