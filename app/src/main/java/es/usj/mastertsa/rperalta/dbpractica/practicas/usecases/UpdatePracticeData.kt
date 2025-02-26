package es.usj.mastertsa.rperalta.dbpractica.practicas.usecases

import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeRepository

class UpdatePracticeData(private val practiceRepository: PracticeRepository) {
    suspend fun updatePracticeData(practiceData: PracticeData) {
        return practiceRepository.updatePracticeData(practiceData)
    }
}