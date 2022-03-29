package llp.itbdesarrollo.xerawodapp.view

import android.content.ContentValues
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils.replace
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View.inflate
import android.widget.Toast
import android.widget.Toolbar
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.resources.Compatibility.Api21Impl.inflate
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.view.GravityCompat
import androidx.core.view.drawToBitmap
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import llp.itbdesarrollo.xerawodapp.R
import llp.itbdesarrollo.xerawodapp.R.drawable.ic_baseline_menu_open_50
import llp.itbdesarrollo.xerawodapp.databinding.ActivityLoginBinding
import llp.itbdesarrollo.xerawodapp.databinding.ActivityMainBinding
import llp.itbdesarrollo.xerawodapp.view.fragments.CrearWodFragment
import llp.itbdesarrollo.xerawodapp.view.fragments.HistoricoFragment
import llp.itbdesarrollo.xerawodapp.view.fragments.UltimoWodFragment
import llp.itbdesarrollo.xerawodapp.viewmodel.WodViewModel

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    //implementar acción del botón menú
    private lateinit var toogle: ActionBarDrawerToggle

    private lateinit var drawer: DrawerLayout
    private lateinit var navigation: NavigationView
    private lateinit var tool: androidx.appcompat.widget.Toolbar
    //declarar variable para manejar el objeto ViewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        drawer = binding.drawerMain
        navigation = binding.navView
        tool = binding.appPrincipal.toolbarUp

        //Mostrar un fragment por defecto al inicio de la aplicación
        showFragmentDefault()

        //Llamar al control de botones
        showFragment()
        //Establecer la barra de actividad de la aplicación
        setSupportActionBar(tool)

        //instanciar objeto de menú
        /*
        *   Sincronizar el icono de menú y el panel de navegación
        *   el toogle necesita varios parámetros un activity
        *   drawerlayout y strings para apertura y cierre del navigation
 */

        toogle = ActionBarDrawerToggle(
            this,
            binding.drawerMain,
            tool,
            R.string.str_nav_drawer_open,
            R.string.str_nav_drawer_close
        )

        /*
        *  Falta que el drawerMain y el toogle escuchen de forma síncrona
*/
           binding.drawerMain.addDrawerListener(toogle)
           // callNavView()


        navigation.setNavigationItemSelectedListener(this)
    }//fin onCreate

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //llamar a la función que lanza los fragments
        itemSeleccionado(item)
        return true
    }

    private fun itemSeleccionado(item: MenuItem) {
        with(binding){
             when(item.itemId) {
                    //meter aquí lo que hará cada vez que se pulse en un item del menú
                    R.id.nav_ultimo -> {
                        //var titulo = R.string.title_frag_ultimo
                        //actionBar?.setTitle(R.string.title_frag_ultimo)
                        Log.d("db_errores", "He llegado a la llamada al frag desde opcion ultimo del menu lateral")
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragmentContainerView, UltimoWodFragment())
                            commit()
                            supportActionBar?.setTitle(R.string.title_frag_ultimo)
                        }

                    }
                    R.id.nav_crear -> {
                        Log.d(ContentValues.TAG, "He llegado a la llamada al frag desde opcion crear del menu lateral")
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragmentContainerView, CrearWodFragment())
                            commit()
                            supportActionBar?.setTitle(R.string.title_frag_crear)

                        }

                    }

                    R.id.nav_historico -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragmentContainerView, HistoricoFragment())
                            commit()
                            supportActionBar?.setTitle(R.string.title_frag_hist)
                        }

                    }

                    R.id.nav_home -> {
                        supportFragmentManager.beginTransaction().apply {
                            replace(R.id.fragmentContainerView, UltimoWodFragment())
                            commit()
                            supportActionBar?.setTitle(R.string.title_frag_ultimo)
                        }

                    }


                }
                //Controlar el comportamiento del menu
                drawerMain.closeDrawer(GravityCompat.START)
                true
            }

        }

    private fun showFragmentDefault() {

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, UltimoWodFragment())
                commit()
                supportActionBar?.setTitle(R.string.title_frag_ultimo)
            }

        }

    private fun showFragment() {
        //control de botones
        with(binding) {
            barBottom.btnUltimo.setOnClickListener {
                supportFragmentManager.beginTransaction().apply {
                    replace(llp.itbdesarrollo.xerawodapp.R.id.fragmentContainerView, UltimoWodFragment())
                    commit()
                    supportActionBar?.setTitle(R.string.title_frag_ultimo)
                }

            }
            //call botón Crear
            barBottom.btnCrear.setOnClickListener {
                Log.d(ContentValues.TAG, "He llegado a la llamada al frag desde boton crear")
                supportFragmentManager.beginTransaction().apply {
                    replace(llp.itbdesarrollo.xerawodapp.R.id.fragmentContainerView, CrearWodFragment())
                    commit()
                    supportActionBar?.setTitle(R.string.title_frag_crear)
                }

            }
            //call botón Histórico
            barBottom.btnHistorico.setOnClickListener {
                supportFragmentManager.beginTransaction().apply {
                    replace(llp.itbdesarrollo.xerawodapp.R.id.fragmentContainerView, HistoricoFragment())
                    commit()
                    supportActionBar?.setTitle(R.string.title_frag_hist)
                }

            }
            //Volver a la pantalla inicial al presionar el botón atrás
            fun onBackPressed() {
                super.onBackPressed()
                showFragmentDefault()
            }

        }
    }

    override fun onCreateOptionsMenu(menu2: Menu): Boolean {
        menuInflater.inflate(R.menu.icons_menu_toolbar, menu2)
        supportActionBar?.setTitle(R.string.app_name)
        return true
    }
/*
    private fun callNavView() {
        with(binding){
            appPrincipal.toolbarUp.setOnClickListener {
                //Controlar el comportamiento del menu
                drawerMain.openDrawer(GravityCompat.END)
                true
            }
        }
    }
*/


    //función que escucha al botón menú
    override fun onOptionsItemSelected(item_m2: MenuItem): Boolean {
        with(binding){
            when(item_m2.itemId) {
                //meter aquí lo que hará cada vez que se pulse en un item del cuenta
                R.id.it_account -> {
                    //debería llamar a un fragment o activity donde se muestre los datos del user y sean modificables
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, CrearWodFragment())
                        commit()
                        supportActionBar?.setTitle(R.string.title_frag_crear)
                    }

                }

            }
            //Controlar el comportamiento del menu

            true
        }
            return super.onOptionsItemSelected(item_m2)
    }
/*
SI LOS AÑADO ME DESCOJONA EL ICONO, POR LO QUE LOS QUITO HE PROBADO LA CONFIG EN HORIZONTAL Y FUNCA OK ASÍ QUE NO ME HACEN FALTA
    //Se añaden métodos para estados de cambio en la pantalla
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toogle.onConfigurationChanged(newConfig)
    }

    //sincronizar el estado del botó menu
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toogle.syncState()
    }
*/
}//clase
