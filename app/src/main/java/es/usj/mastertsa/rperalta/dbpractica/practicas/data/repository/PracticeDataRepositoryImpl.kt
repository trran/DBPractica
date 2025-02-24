package es.usj.mastertsa.rperalta.dbpractica.practicas.data.repository

import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeRepository

class PracticeDataRepositoryImpl: PracticeRepository  {

    override fun getPracticeData(): PracticeData {
        return PracticeData("Práctica 03")
    }

    override fun addPracticeData(practiceData: PracticeData) {
        TODO("Not yet implemented")
    }

    override fun deletePracticeData() {
        TODO("Not yet implemented")
    }

    override fun updatePracticeData(practiceData: PracticeData) {
        TODO("Not yet implemented")
    }

}