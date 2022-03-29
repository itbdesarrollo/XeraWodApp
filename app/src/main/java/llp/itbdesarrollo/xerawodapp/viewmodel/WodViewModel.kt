package llp.itbdesarrollo.xerawodapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import llp.itbdesarrollo.xerawodapp.model.WodModel
import llp.itbdesarrollo.xerawodapp.model.WodCreatorModel
import java.util.Random
import java.util.RandomAccess

//Crear la clase que extiende de ViewModel
class WodViewModel : ViewModel() {
    //implementar el patron livedata con el patrón observable


    //crear la instrucción que conecta el viewmodel con el modelo
    val wodmodel = MutableLiveData<WodModel>()

    //llamada al método que genera un WOD
    fun randomWod(){
        var objRandom = Random()
        var currentWod = objRandom.nextInt(50)
        //intrucción que modifica o muta el modelo
        //esto es lo que avisa a mi activity de que hay cambios
        //wodmodel.postValue(currentWod)
    }
}