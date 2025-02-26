package es.usj.mastertsa.rperalta.dbpractica.practicas.data.repository

import es.usj.mastertsa.rperalta.dbpractica.practicas.data.locastore.PracticeDataSharedPreferences
import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeData
import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeRepository

class PracticeDataRepositoryImpl(private val practiceDataSharedPref:
                                 PracticeDataSharedPreferences): PracticeRepository  {

    override fun getPracticeData(): PracticeData {
        val name = practiceDataSharedPref.getPrefData()
        return PracticeData(name)
    }

    override fun addPracticeData(practiceData: PracticeData) {
       practiceDataSharedPref.addPrefData(practiceData.name)
    }

    override fun deletePracticeData() {
       practiceDataSharedPref.deletePrefData()
    }

    override fun updatePracticeData(practiceData: PracticeData) {
       practiceDataSharedPref.updatePrefData(practiceData.name)
    }

}