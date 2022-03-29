package llp.itbdesarrollo.xerawodapp.model

import android.widget.TimePicker
import java.time.format.DateTimeFormatter
import java.util.*

data class WodModel(val tipowod: TipoWod, val dificultad: DificultadWod, val rondas: Int, val tiempo: Int, val numRep: Int, val descripcion: EjercicioWodModel)


//sealed del wod
sealed class DificultadWod() {
    object Inicial:DificultadWod()
    object Media:DificultadWod()
    object Avanzada:DificultadWod()
    object Experto:DificultadWod()
}

sealed class TipoWod() {
    object RFT:DificultadWod()
    object AMRAP:DificultadWod()
    object EMOM:DificultadWod()
}
//override fun tiempo(hourOfDay:Int, minute:Int){
 // listener($hourOfDay:$minute)
//}