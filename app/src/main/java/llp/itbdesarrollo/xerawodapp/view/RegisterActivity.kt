package llp.itbdesarrollo.xerawodapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import llp.itbdesarrollo.xerawodapp.R
import llp.itbdesarrollo.xerawodapp.databinding.ActivityLoginBinding
import llp.itbdesarrollo.xerawodapp.databinding.ActivityRegisterBinding
import llp.itbdesarrollo.xerawodapp.model.ToolbarSecundario

//Crear un enum para el proveedor BASIC = autenticación básica por email y contraseña
enum class ProviderType {
    BASIC
}

class RegisterActivity : AppCompatActivity() {
    //Definir variable de Firebase Analytics
    private lateinit var mFirebaseAnalytics: FirebaseAnalytics
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //Vincular la vista con el objeto Binding
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //llamar a la función que implementa el toolbar
         ToolbarSecundario().showToolbarSec(this, true)
        /*
          * código previo que implementaba el toolbar
          * //Crear el objeto de tipo Toolbar
        val objToolbar : Toolbar = findViewById(R.id.toolbar)
        //establecer el soporte para el action bar con el objeto Toolbar
        setSupportActionBar(objToolbar)
        //Dar titulo al Toolbar
        supportActionBar?.title = "Actividad Registro"
        //configurar botón volver a la pantalla anterior
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
          *
          *
         */

        //Bloque de envío de eventos a Firebase Analytics
        mFirebaseAnalytics = Firebase.analytics
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("msgBox", "Integración con Firebase correcta")
        mFirebaseAnalytics.logEvent("InitScreen", bundle)

        registerProcess()
    }
    private fun registerProcess() {
        binding.btnRegisterAcc.setOnClickListener() {
            var errores = "Se ha producido un error en el registro"
            if (binding.tvEmailUser.text.isNotEmpty() && binding.tvProveedor.text.isNotEmpty()) {
                //Acceso a Firebase
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.tvEmailUser.text.toString(),
                    binding.tvProveedor.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showScreenPrincipal(binding.tvEmailUser.text.toString())
                    } else {

                        alertError(errores)
                    }
                }
            } else {
                alertError(errores)
            }
        }

        //lógica de botón CANCELAR
        binding.btnCancelReg.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            //Volver a la pantalla anterior
            onBackPressed()
        }

        //lógica botón Volver del Toolbar vuelve a la actividad de login
        binding.icVolver.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }



    }

    //función mostrar pantalla principal MainActivity
    private fun showScreenPrincipal(email: String) {
        //Crear intent para pasar a la pantalla principal
        val loginIntent = Intent(this, MainActivity::class.java).apply {
            putExtra("email", email)

        }
        //Iniciar el intent
        startActivity(loginIntent)
    }

    //función de alerta de error al acceder
    private fun alertError(errores: String) {
        val errorAuth = AlertDialog.Builder(this)
        errorAuth.setTitle("Error de registro")
        errorAuth.setMessage(errores)
        errorAuth.setPositiveButton("Aceptar", null)
        val strDialog: AlertDialog = errorAuth.create()
        strDialog.show()
    }

 }