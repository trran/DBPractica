package es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.usj.mastertsa.rperalta.dbpractica.practicas.data.repository.PracticeDataRepositoryImpl
import es.usj.mastertsa.rperalta.dbpractica.practicas.usecases.AddPracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.usecases.DeletePracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.usecases.GetPracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.usecases.UpdatePracticeData

class HomeViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val practiceDataRepositoryImpl = PracticeDataRepositoryImpl()
        return HomeViewModel(
            getPracticeData = GetPracticeData(practiceDataRepositoryImpl),
            addPracticeData = AddPracticeData(practiceDataRepositoryImpl),
            deletePracticeData = DeletePracticeData(practiceDataRepositoryImpl),
            updatePracticeData = UpdatePracticeData(practiceDataRepositoryImpl)
        ) as T
    }
}