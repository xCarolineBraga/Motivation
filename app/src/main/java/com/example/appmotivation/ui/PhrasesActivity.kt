package com.example.appmotivation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appmotivation.PhraseRepository
import com.example.appmotivation.constants.AppConstants
import com.example.appmotivation.R
import com.example.appmotivation.databinding.ActivityPhrasesBinding
import com.example.appmotivation.helper.SecurityPreferences


class PhrasesActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPhrasesBinding
    private lateinit var securityPreferences: SecurityPreferences
    private var phraseRepository = PhraseRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPhrasesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        securityPreferences = SecurityPreferences(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setListeners()
        getUserName()
        refreshPhrase()
    }


    override fun onClick(v: View) {
        if (v.id == R.id.button_new) {
            handleNewPhrase()
        }

    }

    private fun refreshPhrase(){
       binding.textViewFrases.text =  phraseRepository.getPhrases()
    }

    private fun handleNewPhrase() {
        // lidar com gerador de frases


    }

    private fun setListeners() {
        // função criada para chamada de eventos de clique
        binding.buttonNew.setOnClickListener(this)
    }

    private fun getUserName() {
        // função para recuperação de intents
       val nome = securityPreferences.getString(AppConstants.Key.PERSON_NAME)
        binding.textViewName.text = nome

    }
}