package com.example.appmotivation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
    }
    override fun onClick(v: View) {
        if (v.id == R.id.button_new){
            handleNewPhrase()
        }

    }

    private fun handleNewPhrase(){

    }

  private fun setListeners(){
      binding.buttonNew.setOnClickListener(this)
  }


}