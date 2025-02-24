package es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.viewmodel.HomeViewModel
import es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.viewmodel.HomeViewModelFactory

@Composable
fun HomeScreen(viewModel: HomeViewModel){
    val state = viewModel.practiceStateFlow.collectAsState()
    when (val stateValue = state.value)
    {
        is HomeState.Loading -> LoadingComposable()
        is HomeState.Failure -> FailureComposable()
        is HomeState.Success -> SuccessComposable(stateValue.practiceData.name)
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
fun SuccessComposable(name: String) {
    Box(modifier = Modifier.fillMaxSize()){
        Text(modifier = Modifier.align(Alignment.Center), text = name)
    }
}

@Composable
fun FailureComposable() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(modifier = Modifier.align(Alignment.Center), text = "An error occurred!")
    }
}


@Preview(showBackground = true)
@Composable
fun LoadingComposablePreview() {
    LoadingComposable()
}


@Preview(showBackground = true)
@Composable
fun SuccessComposablePreview() {
    SuccessComposable("Success preview")
}

@Preview(showBackground = true)
@Composable
fun FailureComposablePreview() {
    FailureComposable()
}
