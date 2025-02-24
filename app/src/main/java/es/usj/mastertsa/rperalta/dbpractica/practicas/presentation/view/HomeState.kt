package es.usj.mastertsa.rperalta.dbpractica.practicas.presentation.view

import es.usj.mastertsa.rperalta.dbpractica.practicas.domain.PracticeData

sealed class HomeState { object Loading : HomeState() data
class Success(val practiceData: PracticeData) : HomeState() data
class Failure(val exception: Throwable) : HomeState() }