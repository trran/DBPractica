package es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.view

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.feature.CustomButton
import es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.viewmodel.HomeViewModel
import es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.viewmodel.HomeViewModelFactory
import android.content.Context
import androidx.compose.ui.platform.LocalContext

@Composable
fun HomeScreen(viewModel: HomeViewModel){
    val state = viewModel.practiceStateFlow.collectAsState()

    when (val stateValue = state.value)
    {
        is HomeState.Loading -> LoadingComposable()
        is HomeState.Failure -> FailureComposable()
        is HomeState.Success -> SuccessComposable(viewModel)
    }
}

@Composable
fun LoadingComposable() {
    Box(modifier = Modifier.fillMaxSize()){
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
                .size(48.dp)
        )
    }
}

@Composable
fun SuccessComposable(viewModel: HomeViewModel) {
    val context = LocalContext.current
    var textFieldValue by remember { mutableStateOf(viewModel.getData()) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        OutlinedTextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            modifier = Modifier
                .fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomButton(text = "ADD DATA") {
                viewModel.addData(PracticeData(textFieldValue))
                textFieldValue = viewModel.getData()
                Toast.makeText(context, "Added!", Toast.LENGTH_SHORT).show()
            }
            CustomButton(text = "UPDATE DATA") {
                viewModel.updateData(PracticeData(textFieldValue))
                textFieldValue = viewModel.getData()
                Toast.makeText(context, "Updated!", Toast.LENGTH_SHORT).show()
            }
            CustomButton(text = "DELETE DATA") {
                viewModel.deleteData()
                textFieldValue = viewModel.getData()
                Toast.makeText(context, "Deleted!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()){
        Text(modifier = Modifier.align(Alignment.Center), text = textFieldValue)
    }
}

@Composable
fun FailureComposable() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(modifier = Modifier.align(Alignment.Center), text = "An error occurred!")
    }
}

@Composable
fun PracticasScreen(viewModel: HomeViewModel) {

}


@Preview(showBackground = true)
@Composable
fun LoadingComposablePreview() {
    LoadingComposable()
}

@Preview(showBackground = true)
@Composable
fun FailureComposablePreview() {
    FailureComposable()
}
