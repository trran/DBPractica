package es.usj.mastertsa.rperalta.dbpractica.practicas.domain

import kotlinx.coroutines.flow.Flow

interface PracticeRepository {
    fun getPracticeData(): Flow<PracticeData>
    suspend fun addPracticeData(practiceData: PracticeData)
    suspend fun deletePracticeData()
    suspend fun updatePracticeData(practiceData: PracticeData)
}