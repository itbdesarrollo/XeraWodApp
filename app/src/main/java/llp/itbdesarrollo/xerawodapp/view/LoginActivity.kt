package llp.itbdesarrollo.xerawodapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import llp.itbdesarrollo.xerawodapp.R
import llp.itbdesarrollo.xerawodapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    //Definir variable de Firebase Analytics
    private lateinit var mFirebaseAnalytics: FirebaseAnalytics
    //Vincular la vista
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_XeraWodApp)
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)
        //Vincular la vista con el objeto ViewBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Vincular la vista con el objeto DataBinding

        //binding = ActivityLoginBinding.inflate(layoutInflater)
        //Bloque de envío de eventos a Firebase Analytics
        mFirebaseAnalytics = Firebase.analytics
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("msgBox", "Integración con Firebase correcta")
        mFirebaseAnalytics.logEvent("InitScreen", bundle)

        //quitar el actionbar
        supportActionBar?.hide()

        Setup()
    }

    private fun Setup() {
        title = "Autenticación"
        //Acceder al botón de registro

        binding.btnRegister.setOnClickListener {
          /*
          * antes de todo esto debo comprobar si cuando se pulsa el botón registrar, el usuario ya está logueado y registrado
          *           ya que si lo está entonces no necesita ir a crear nueva cta. entonces le informaré de ello y le
          * llevaré a la pantalla principal de la app que es la del main
          * ADEMÁS SI EL USER YA SE LOGUEÓ, EL SISTEMA DEBERÍA LLEVARLO DIRECTO AL MAIN SIN PASAR POR AQUÍ
          *
           */

            //Envío a la pantalla de registro
            //val act: String = "RegisterActivity"
           // showActivity(act)
            startActivity(Intent(this, RegisterActivity::class.java))
            /*

            */
        }

        //Acceder al botón de login
        binding.btnLogin.setOnClickListener {
            var errores = "Se ha producido un error de autenticación"
            if (binding.etxEmailUser.text.isNotEmpty() && binding.etxPassword.text.isNotEmpty()) {
                //Acceso a Firebase
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    binding.etxEmailUser.text.toString(),
                    binding.etxPassword.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        //showDataUser(it.result?.user?.email?: "", ProviderType.BASIC)

                        showScreenPrincipal(it.result?.user?.email ?: "")
                    } else {

                        alertError(errores)
                    }
                }
            } else {
                alertError(errores)
            }
        }
    }

    //función de alerta de error al acceder 
    private fun alertError(errores: String) {
        val errorAuth = AlertDialog.Builder(this)
        errorAuth.setTitle("Error de acceso")
        errorAuth.setMessage(errores)
        errorAuth.setPositiveButton("Aceptar", null)
        val strDialog: AlertDialog = errorAuth.create()
        strDialog.show()
    }

    //función mostrar datos de usuario
    private fun showDataUser(email: String, provider: ProviderType) {
        //Crear intent para pasar a la pantalla de login
        val loginIntent = Intent(this, RegisterActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        //Iniciar el intent
        startActivity(loginIntent)
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

    //función mostrar una activity
    private fun showActivity(name_activ: String) {
        //Crear intent para pasar a la pantalla de actividad recibida
        val loginIntent = Intent(this, name_activ::class.java).apply {
        //si necesita otro parámetro, lo añado luego
        //putExtra("email", email)

        }
        //Iniciar el intent
        startActivity(loginIntent)
        //finish()
    }
/*
    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
    }*/
override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }



}