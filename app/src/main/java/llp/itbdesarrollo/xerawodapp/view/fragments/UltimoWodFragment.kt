package llp.itbdesarrollo.xerawodapp.view.fragments

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import llp.itbdesarrollo.xerawodapp.R
import llp.itbdesarrollo.xerawodapp.databinding.FragmentUltimoWodBinding

class UltimoWodFragment : BaseFragment<FragmentUltimoWodBinding>(R.layout.fragment_ultimo_wod) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //inicializar binding
        _binding = FragmentUltimoWodBinding.bind(view)
        Log.d("db_errores", "He llegado al onviewcreade del ultimofragment")
        //a partir de aquí se pued usar codigo para implementar lógica
        Log.d("db_errores", "pribando boton")
        val db = FirebaseFirestore.getInstance()
      binding.btnVolverUltimo.setOnClickListener {
          Toast.makeText(activity, "Has pulsado el botón volver", Toast.LENGTH_SHORT).show()
          db.collection("SpDificultad").document("dif1").get().addOnSuccessListener {
              binding.tvDatoDescripcion.setText(it.get("descripcion") as String?)
          }
      }

    }
}