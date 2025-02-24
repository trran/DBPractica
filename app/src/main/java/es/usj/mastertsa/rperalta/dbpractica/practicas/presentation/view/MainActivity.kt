package es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.viewmodel.HomeViewModel
import es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.viewmodel.HomeViewModelFactory
import es.usj.mastertsa.rperalta.dbpractica.ui.theme.DBPracticaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface {
                val factory = HomeViewModelFactory()
                val viewModel= factory.create(HomeViewModel::class.java)
                HomeScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DBPracticaTheme {
        Greeting("Android")
    }
}