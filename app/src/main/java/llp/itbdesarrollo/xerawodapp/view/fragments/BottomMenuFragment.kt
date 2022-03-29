package llp.itbdesarrollo.xerawodapp.view.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.FragmentManager
import llp.itbdesarrollo.xerawodapp.R
import llp.itbdesarrollo.xerawodapp.databinding.FragmentBottomMenuBinding

class BottomMenuFragment : BaseFragment<FragmentBottomMenuBinding>(R.layout.fragment_bottom_menu) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //inicializar binding
        _binding = FragmentBottomMenuBinding.bind(view)

        //a partir de aquí se pued usar codigo para implementar lógica

    }


    }
