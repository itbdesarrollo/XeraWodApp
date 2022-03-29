package llp.itbdesarrollo.xerawodapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
//Clase creada para reciclar código en el binding
open class BaseFragment<T: ViewBinding>(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId){
    //declarar binding
    protected var _binding: T? = null
    protected val binding get() = _binding!!

    //liberar binding
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}