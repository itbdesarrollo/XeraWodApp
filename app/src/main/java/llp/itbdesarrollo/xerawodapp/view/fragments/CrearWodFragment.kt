package llp.itbdesarrollo.xerawodapp.view.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import llp.itbdesarrollo.xerawodapp.R
import llp.itbdesarrollo.xerawodapp.databinding.FragmentCrearWodBinding
import llp.itbdesarrollo.xerawodapp.databinding.FragmentUltimoWodBinding


/*al tener una clase para reciclar código en los fragment, se hereda de ella y continuo
* pide una subclase de Binding por ello se pasa la subclase ActivityCrearWodBinding
*   se pasa el id de layout
 */
class CrearWodFragment : BaseFragment<FragmentCrearWodBinding>(R.layout.fragment_crear_wod) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCrearWodBinding.bind(view)
        Log.d(TAG, "He llegado al onViewCreated")
        //CREO EL ARRAY
        //val datos = arrayOf("uno", "dos", "tres", "cuatro")

        /*
        AHORA PRUEBO A CARGAR EL SPINNER DESDE LA BD PARA VER SI LO HACE, PARA ELLO
        REUTILIZO EL CÓDIGO QUE USÉ ANTES, PERO ESTA VEZ NO USO MUTABLELISTOF, SINO ARRAYOF
         **************************DESDE AQUÍ ***********************************************

         */
        //obtener instancia de conexión a bd
        val db1 = FirebaseFirestore.getInstance()

        Log.d("db_errores", "Mutable list")

        Log.d("db_errores", "que contiene esto: $db1")
        //variable de concatenación para los resultados
        var resultado: String? = ""

        //abrir colección de datos que se llama SpTipo, o SpDificultad que es la que intento recuperar
        // dentro tiene una lista de docs con id dif1 - dif2 ---  y todos con descripcion
        binding.btnCrearWod.setOnClickListener {
        //intento ultimo porque paso si no funciona

          db1.collection("SpDificultad").document("dif5").get().addOnSuccessListener {
            
                binding.tvTipo.setText(it.get("descripcion") as String?)

            }


 /*           db1.collection("SpDificultad").document("dif2").get().addOnSuccessListener {

                binding.tvTipo.setText(it.get("descripcion") as String?)

            }
*/
            //DENTRO DEL EVENTO ONCLIC DEL BOTÓN CREAR WOD, HE AGREGADO LA LÓGICA PARA CARGAR EL SPINNER
        }


        /*
        ******************HASTA AQUÍ ES NUEVO CODIGO PARA PROBAR CARGAR DESDE BD *********
         */



            //PRUEBO CON UN EVENTO EN UN TV Y VA OK
            binding.tvTiempo.setOnClickListener {
                binding.tvTiempo.text = binding.etDatoTiempo.text.toString()
            }
            //aquí estaba el bloque logica del spinner que la paso a dentro del metodo onsuccsesssListeer
/*
            //añado un listener más tengo que probar si ok
        binding.spinDatoTipo.setOnClickListener {
                resultado = binding.spinDatoTipo.selectedItem.toString()
                Toast.makeText(activity, "Has seleccionado $resultado", Toast.LENGTH_SHORT).show()
            }
*/
    }


}