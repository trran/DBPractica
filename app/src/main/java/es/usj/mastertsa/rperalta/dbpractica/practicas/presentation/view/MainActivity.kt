package es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.feature.CustomButton
import es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.viewmodel.HomeViewModel
import es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.viewmodel.HomeViewModelFactory
import es.usj.mastertsa.rperalta.dbpractica.ui.theme.DBPracticaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface {
                val factory = HomeViewModelFactory(this)
                val viewModel= factory.create(HomeViewModel::class.java)
                HomeScreen(viewModel = viewModel)
            }
        }
    }
}