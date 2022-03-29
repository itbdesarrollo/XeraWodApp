package llp.itbdesarrollo.xerawodapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import llp.itbdesarrollo.xerawodapp.R

//pantalla que se debe cargar antes de que se abra la app
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.drawable.drw_splashscreen)
        //startActivity(Intent(this, MainActivity::class.java))
        //llamo a la activity de login tras el splash
        //startActivity(Intent(this, LoginActivity::class.java))
    }
}