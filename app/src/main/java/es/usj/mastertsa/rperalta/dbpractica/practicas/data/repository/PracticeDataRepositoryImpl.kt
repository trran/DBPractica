package es.usj.mastertsa.rperalta.dbpractica.practicas.data.repository

import es.usj.mastertsa.rperalta.dbpractica.practicas.data.locastore.PracticeDataSharedPreferences
import es.usj.mastertsa.rperalta.dbpractica.practicas.data.locastore.PracticeDataStore
import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PracticeDataRepositoryImpl(private val dataStore: PracticeDataStore): PracticeRepository {
    override fun getPracticeData(): Flow<PracticeData> {
        return dataStore.getDataStoreData().map { practiceName ->
            PracticeData(practiceName)
        }
    }

    override suspend fun addPracticeData(practiceData: PracticeData) {
        dataStore.addDataStoreData(practiceData.name)
    }

    override suspend fun deletePracticeData() {
        dataStore.deleteDataStoreData()
    }

    override suspend fun updatePracticeData(practiceData: PracticeData) {
        dataStore.updateDataStoreData(practiceData.name)
    }
}