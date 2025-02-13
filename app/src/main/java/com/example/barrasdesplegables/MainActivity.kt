package com.example.barrasdesplegables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
Surface(color = MaterialTheme.colorScheme.primary, modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp).fillMaxWidth()) {
    Text(
        text = "Hello $name!",
        modifier = modifier.padding(26.dp)
    )
}

}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    BarrasDesplegablesTheme {
        MyApp()
    }
}