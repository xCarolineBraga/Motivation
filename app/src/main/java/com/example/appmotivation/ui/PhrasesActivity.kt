package com.example.appmotivation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appmotivation.AppConstants
import com.example.appmotivation.R
import com.example.appmotivation.databinding.ActivityPhrasesBinding


class PhrasesActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPhrasesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPhrasesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setListeners()

        var saveName = getName()
        var name1 = binding.textViewName.text.toString()
        name1 = saveName.toString()

    }


    override fun onClick(v: View) {
        if (v.id == R.id.button_new) {
            handleNewPhrase()
        }

    }

    private fun handleNewPhrase() {
        // lidar com gerador de frases

    }

    private fun setListeners() {
        // função criada para chamada de eventos de clique
        binding.buttonNew.setOnClickListener(this)
    }

    private fun getName() {
        // função para recuperação de intents
        intent.extras?.let {
            binding.textViewName.text = it.getString(AppConstants.KEY_NAME)
        }

    }
}