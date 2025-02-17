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
fun PantallaPrevia(modifier: Modifier = Modifier){
    var mostrarPantallaPrevia by remember { mutableStateOf(true) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenido!"
        )
        ElevatedButton(
            onClick = {},
            modifier = modifier
        ) {
            Text(
                text = "Continue"
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 350, heightDp = 350)
@Composable
fun PreviewPantallaCarga(){
    BarrasDesplegablesTheme{
        PantallaPrevia()
    }
}


@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    nombreColumnas: List<String> = listOf("Mundo", "Compose")
){
    Column(modifier = modifier.padding(vertical = 4.dp)){
        for(nombre in nombreColumnas){
            Greeting(name = nombre)
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    // Variable de estado del boton.
    val expanded = remember { mutableStateOf(false) }

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

@Preview(showBackground = true, widthDp = 350)
@Composable
fun GreetingPreview() {
    BarrasDesplegablesTheme {
        MyApp()
    }
}