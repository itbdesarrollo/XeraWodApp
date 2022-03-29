package llp.itbdesarrollo.xerawodapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import llp.itbdesarrollo.xerawodapp.model.WodCreatorModel
import llp.itbdesarrollo.xerawodapp.model.WodModel

class CrearWodViewModel: ViewModel()  {

    //crear la instrucción que conecta el viewmodel con el modelo
    val wodmodel = MutableLiveData<WodCreatorModel>()
}