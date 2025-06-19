package com.example.appmotivation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appmotivation.repository.PhraseRepository
import com.example.appmotivation.constants.AppConstants
import com.example.appmotivation.R
import com.example.appmotivation.databinding.ActivityPhrasesBinding
import com.example.appmotivation.helper.SecurityPreferences


class PhrasesActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPhrasesBinding
    private lateinit var securityPreferences: SecurityPreferences
    private val phraseRepository = PhraseRepository()

    // variável criada aqui pois será utilizada por mais de 1 método, por isso o escopo precisa ser ampliado
    // foi atribuida uma constante por ser uma informação sensível
    private var filter = AppConstants.Phrases.ALL


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
        // metodos criados para modularizar o funcionamento do app
        setListeners()
        getUserName()

        //metodo chamado aqui, antes de refreshPhrase para que o filtro de "All" já venha selecionado
        // assim como o filtro já inicia com "all"
        handleFilter(R.id.imageView_icAll)
        refreshPhrase()
    }


    override fun onClick(v: View) {
        // lista criada para armazenar o evento de clique dos filtros de frases.Junção do grupo de elementos
        // que estou tratando
        val listId = listOf(
            R.id.imageView_icAll, R.id.imageView_icSmile, R.id.imageView_icSunny
        )

        if (v.id == R.id.button_new) {
            refreshPhrase()

            // else criado para receber a logica caso algum item da lista de filtros seja clicado.
        } else if (v.id in listId) {
            handleFilter(v.id)

        }

    }

    private fun refreshPhrase() {
        // lidar com gerador de frases
        binding.textViewFrases.text = phraseRepository.getPhrases(filter)
    }

    private fun handleFilter(id: Int) {
        // metodo criado para lidar com a categoria da frase selecionada

        // quando o ic para filtragem era selecionado, e depois outro selecionado, o anterior não era
        // desmarcado.Por isso é preciso "setar" a cor por meio da chamada abaixo
        binding.imageViewIcAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
        binding.imageViewIcSmile.setColorFilter(ContextCompat.getColor(this, R.color.white))
        binding.imageViewIcSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))


        when (id) {
            R.id.imageView_icAll -> {
                filter = AppConstants.Phrases.ALL
                binding.imageViewIcAll.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.Yeloow))
            }

            R.id.imageView_icSmile -> {
                filter = AppConstants.Phrases.SMILE
                binding.imageViewIcSmile.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.Yeloow
                    )
                )
            }

            R.id.imageView_icSunny -> {
                filter = AppConstants.Phrases.SUNNY
                binding.imageViewIcSunny.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.Yeloow
                    )
                )

            }
        }

    }

    private fun setListeners() {
        // metodo  criada para chamada de eventos de clique

        binding.buttonNew.setOnClickListener(this)
        binding.imageViewIcAll.setOnClickListener(this)
        binding.imageViewIcSunny.setOnClickListener(this)
        binding.imageViewIcSmile.setOnClickListener(this)
    }

    private fun getUserName() {
        // função para recuperação de intents
        val nome = securityPreferences.getString(AppConstants.Key.PERSON_NAME)
        binding.textViewName.text = nome

    }
}