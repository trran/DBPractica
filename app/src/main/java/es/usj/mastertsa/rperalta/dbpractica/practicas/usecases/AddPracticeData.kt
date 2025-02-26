package es.usj.mastertsa.rperalta.dbpractica.practicas.usecases

import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeRepository

class AddPracticeData(private val practiceRepository: PracticeRepository) {
    suspend fun addPracticeData(practiceData: PracticeData) {
        return practiceRepository.addPracticeData(practiceData)
    }
}