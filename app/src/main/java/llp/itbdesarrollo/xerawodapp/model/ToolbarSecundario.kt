package llp.itbdesarrollo.xerawodapp.model

import androidx.appcompat.app.AppCompatActivity
import llp.itbdesarrollo.xerawodapp.R

class ToolbarSecundario {
    //ésta función recibe 3 parámetros: 1 activity, 1 String para el título, 1 booleano que representa la acción de volver en un botón
    fun showToolbarSec(actividad: AppCompatActivity, btnVolver: Boolean) {
       actividad.setSupportActionBar(actividad.findViewById(R.id.toolbarSecondUp))
        //lógica del título
        actividad.supportActionBar?.setTitle(R.string.title_frag_register)
        //activar botón volver según booleano
        actividad.supportActionBar?.setDisplayHomeAsUpEnabled(btnVolver)
    }
}