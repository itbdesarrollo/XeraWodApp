package llp.itbdesarrollo.xerawodapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import llp.itbdesarrollo.xerawodapp.R
import llp.itbdesarrollo.xerawodapp.databinding.FragmentHistoricoBinding


class HistoricoFragment : BaseFragment<FragmentHistoricoBinding>(R.layout.fragment_historico) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //inicializar binding
        _binding = FragmentHistoricoBinding.bind(view)

        //a partir de aquí se pued usar codigo para implementar lógica
    }
}