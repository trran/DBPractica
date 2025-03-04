package es.usj.mastertsa.rperalta.dbpractica.practicas.usecases

import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeRepository

class DeletePracticeData(private val practiceRepository: PracticeRepository) {
    suspend fun deletePracticeData() {
        return practiceRepository.deletePracticeData()
    }
}