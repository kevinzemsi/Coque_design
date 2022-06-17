package com.example.coque_design

import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.coque_design.UI.ui.login.LoginViewModel
import com.example.coque_design.UI.ui.login.LoginViewModelFactory
import com.example.coque_design.databinding.ActivityLoginBinding
import com.example.coque_design.databinding.ActivityMainBinding
import com.example.coque_design.db.UtilisateurDatabase
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        val search = menu.findItem(R.id.action_search)
        val searchView: SearchView = search.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d(TAG, "onQueryTextSubmit ${query}")
                val args = bundleOf("image" to query)
                navController.navigate(R.id.imageFragment, args)
                invalidateOptionsMenu()
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d(TAG, "onQueryTextChange ${newText}")
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_search -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}

//    private  lateinit var inputEmail: EditText
//    private  lateinit var inputPassword: EditText
//    private lateinit var buttonconnexion : Button
//    private lateinit var liennouveaucompte : TextView
//
//
//    private lateinit var viewModel: LoginViewModel
//
//    private lateinit var binding: ActivityMainBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//       // var binding = ActivityMainBinding.inflate(layoutInflater)
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//
//        inputEmail = findViewById(R.id.inputEmail)
//        inputPassword = findViewById(R.id.inputPassword)
//        buttonconnexion = findViewById(R.id.buttonconnexion)
//        liennouveaucompte = findViewById(R.id.liennouveaucompte)
//
//        val dao = UtilisateurDatabase.getInstance(application).utilisateurDao()
//        val factory = LoginViewModelFactory()
//        viewModel = ViewModelProvider(this,factory).get(LoginViewModel ::class.java)
//
//
//
//    }
//}