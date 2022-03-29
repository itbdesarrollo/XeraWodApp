package llp.itbdesarrollo.xerawodapp.model

data class EjercicioWodModel(val idEj: String, val descripcion: String, val grupoMuscular: GrupoMuscular, val rangoRepeticion: RangoRepeticion)

//sealed del EjercicioWod
sealed class GrupoMuscular() {

    object Abdomen:GrupoMuscular()
    object Espalda:GrupoMuscular()
    object Hombro:GrupoMuscular()
    object Pecho:GrupoMuscular()
    object Pierna:GrupoMuscular()
    object PiernaEspalda:GrupoMuscular()
    object PiernaHombro:GrupoMuscular()
    object PiernaPecho:GrupoMuscular()
    object PiernaPechoHombro:GrupoMuscular()
    object PechoHombro:GrupoMuscular()
}

sealed class RangoRepeticion() {
    object SuperAlto:RangoRepeticion()
    object Alto:RangoRepeticion()
    object Medio:RangoRepeticion()
    object Bajo:RangoRepeticion()
}