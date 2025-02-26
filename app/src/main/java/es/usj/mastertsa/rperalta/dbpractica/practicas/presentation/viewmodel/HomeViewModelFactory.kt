package es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import es.usj.mastertsa.rperalta.dbpractica.practicas.data.locastore.PracticeDataSharedPreferences
import es.usj.mastertsa.rperalta.dbpractica.practicas.data.repository.PracticeDataRepositoryImpl
import es.usj.mastertsa.rperalta.dbpractica.practicas.usecases.AddPracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.usecases.DeletePracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.usecases.GetPracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.usecases.UpdatePracticeData

class HomeViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val practiceDataSharedPreferences = PracticeDataSharedPreferences(context)
        val practiceDataRepositoryImpl = PracticeDataRepositoryImpl(practiceDataSharedPreferences)

        return HomeViewModel(
            getPracticeData = GetPracticeData(practiceDataRepositoryImpl),
            addPracticeData = AddPracticeData(practiceDataRepositoryImpl),
            deletePracticeData = DeletePracticeData(practiceDataRepositoryImpl),
            updatePracticeData = UpdatePracticeData(practiceDataRepositoryImpl)
        ) as T
    }
}
