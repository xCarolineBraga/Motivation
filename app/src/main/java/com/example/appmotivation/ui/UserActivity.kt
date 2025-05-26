package com.example.appmotivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appmotivation.AppConstants
import com.example.appmotivation.R
import com.example.appmotivation.databinding.ActivityUserBinding
import com.example.appmotivation.helper.SecurityPreferences

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    private lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        securityPreferences = SecurityPreferences(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setListeners()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun handleSave() {
        val nome = binding.editTextName.text.toString()

        if (nome.isNotEmpty()){

            securityPreferences.storeString(AppConstants.Key.PERSON_NAME,nome)
            //salvando o nome

            val intent = Intent(this,PhrasesActivity::class.java)
            startActivity(intent)
            finish()


        }else{
            Toast.makeText(this,R.string.name_notification,Toast.LENGTH_SHORT).show()
        }
    }

    private fun setListeners() {
        binding.buttonSave.setOnClickListener(this)
    }
}