package es.usj.mastertsa.rperalta.dbpractica.practicas.usecases

import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeRepository

class GetPracticeData(private val practiceRepository: PracticeRepository )  {
    fun getPracticeData(): PracticeData {
        return practiceRepository.getPracticeData()
    }
}