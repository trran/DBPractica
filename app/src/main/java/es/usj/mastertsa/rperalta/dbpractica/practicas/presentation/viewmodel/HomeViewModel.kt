package es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.viewmodel

import android.view.PixelCopy.request
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.view.HomeState
import es.usj.mastertsa.rperalta.dbpractica.practicas.usecases.AddPracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.usecases.DeletePracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.usecases.GetPracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.usecases.UpdatePracticeData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getPracticeData: GetPracticeData,
    private val addPracticeData: AddPracticeData, private
    val updatePracticeData: UpdatePracticeData, private
    val deletePracticeData: DeletePracticeData) : ViewModel() {

    private val practiceMutableStateFlow: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.Loading)
    val practiceStateFlow: StateFlow<HomeState> = practiceMutableStateFlow

    init
            {
                viewModelScope.launch {
                    delay(3000) //Simulating network request
                    val practiceData = getPracticeData.getPracticeData()
                   practiceMutableStateFlow.emit(HomeState.Success(practiceData))
                }
            }


    fun addData(practiceData: PracticeData) {
        addPracticeData.addPracticeData(practiceData)
    }
    fun updateData(practiceData: PracticeData) {
        updatePracticeData.updatePracticeData(practiceData)
    }
    fun deleteData() {
        deletePracticeData.deletePracticeData()
    }
}