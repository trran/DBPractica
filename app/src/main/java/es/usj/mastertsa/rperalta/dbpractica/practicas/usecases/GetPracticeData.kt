package es.usj.mastertsa.rperalta.dbpractica.practicas.usecases

import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeRepository
import kotlinx.coroutines.flow.Flow

class GetPracticeData(private val practiceRepository: PracticeRepository )  {
    fun getPracticeData(): Flow<PracticeData> {
        return practiceRepository.getPracticeData()
    }
}