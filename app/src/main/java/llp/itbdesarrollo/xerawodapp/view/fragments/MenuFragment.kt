package llp.itbdesarrollo.xerawodapp.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import llp.itbdesarrollo.xerawodapp.R
import llp.itbdesarrollo.xerawodapp.databinding.FragmentMenuBinding

class MenuFragment : BaseFragment<FragmentMenuBinding>(R.layout.fragment_menu) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //inicializar binding
        _binding = FragmentMenuBinding.bind(view)

        //a partir de aquí se pued usar codigo para implementar lógica
    }
}