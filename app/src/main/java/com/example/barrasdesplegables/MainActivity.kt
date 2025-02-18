package com.example.barrasdesplegables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barrasdesplegables.ui.theme.BarrasDesplegablesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BarrasDesplegablesTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier
){
    var mostrandoPantallaPrevia by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if(mostrandoPantallaPrevia){
            PantallaPrevia(onContinueClicked = {mostrandoPantallaPrevia=false})
        }else{
            Greetings()
        }
    }
}

@Composable
fun PantallaPrevia(onContinueClicked: () -> Unit ,modifier: Modifier = Modifier ){

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenido!"
        )
        Button(
            modifier = modifier.padding(24.dp),
            onClick = onContinueClicked
        ) {
            Text(
                text = "Continuar"
            )
        }
    }
}

@Composable
private fun Greetings(modifier: Modifier = Modifier,
              nombreColumnas: List<String> = List(1000) {"$it"}){
    LazyColumn(
        modifier = modifier.padding(vertical = 4.dp)
    ) {
        items(items = nombreColumnas){
            nombreColumnas -> Greeting(name = nombreColumnas)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    // Variable de estado del boton.
    var expanded = rememberSaveable { mutableStateOf(false) }

    val extraPadding = if(expanded.value) 48.dp else 0.dp

Surface(color = MaterialTheme.colorScheme.primary, modifier = modifier
    .padding(vertical = 4.dp, horizontal = 8.dp)) {
    Row(modifier = modifier.padding(26.dp,26.dp,26.dp,26.dp+extraPadding)) {
        Text(
            text = "Hello $name!",
            modifier = modifier.weight(1f).align(alignment = Alignment.CenterVertically)
        )
        ElevatedButton(onClick = {expanded.value = !expanded.value}) {
            if(!expanded.value){
                Text(text = "Mostrar +")
            }else{
                Text(text = "Mostrar -")
            }

        }
    }
}

}

@Preview(showBackground = true, widthDp = 350, heightDp = 350)
@Composable
fun PreviewPantallaCarga(){
    BarrasDesplegablesTheme{
        PantallaPrevia(onContinueClicked = {})
    }
}

@Preview(showBackground = true, widthDp = 350)
@Composable
fun GreetingsPreview() {
    BarrasDesplegablesTheme {
        Greetings()
    }
}

@Preview(showBackground = true, widthDp = 350)
@Composable
fun MyAppPreview() {
    BarrasDesplegablesTheme {
        MyApp(modifier = Modifier.fillMaxSize())
    }
}