package llp.itbdesarrollo.xerawodapp.model

import com.google.firebase.firestore.auth.User

data class WodGeneradoModel(val idWodGen: String, val idUser: User, val wodCreator: WodCreatorModel)
/*
*   Estos serán los objetos que se usen generalmente para mostrar al usuario, es decir
*   el histórico construye en base a esto (múltiples registros en bd)
*   el último wod se construye en base a ésto (último registro en BD)
*   el nuevo wod se persiste con este modelo (nuevo registro en BD)
 */