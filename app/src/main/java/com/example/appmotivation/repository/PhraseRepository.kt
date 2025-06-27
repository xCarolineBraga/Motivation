package com.example.appmotivation.repository

import com.example.appmotivation.constants.AppConstants
import kotlin.random.Random

data class Phrase(val description: String, val category: Int, val language: String)

class PhraseRepository {

    //Por ser uma informação sensivel, foram criadas constantes.
    private val all = AppConstants.Phrases.ALL
    private val happy = AppConstants.Phrases.SMILE
    private val sunny = AppConstants.Phrases.SUNNY

    private val langPt = AppConstants.LANGUAGE.PORTUGUESE
    private val langEn = AppConstants.LANGUAGE.ENGLISH
    private val langEs = AppConstants.LANGUAGE.SPANISH

    // variável criada para receber a lista de frases

    private val listPhrase: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", happy, langPt),
        Phrase("Coisas grandes são feitas de um monte de coisinhas.", happy, langPt),
        Phrase("Se houver risco de felicidade, arrisque-se", happy, langPt),
        Phrase(
            "Você não é derrotado quando perde, você é derrotado quando desiste!",
            happy,
            langPt
        ),
        Phrase("Quando está mais escuro, vemos mais estrelas!", happy, langPt),
        Phrase(
            "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
            happy,
            langPt
        ),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy, langPt),
        Phrase(
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
            happy,
            langPt
        ),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny, langPt),
        Phrase("É sobre viver os sonhos e não os medos!", sunny, langPt),
        Phrase("Ter luz não é sobre brilhar, é sobre iluminar!", sunny, langPt),
        Phrase("Direção é mais importante que velocidade.", sunny, langPt),
        Phrase("Você perde todas as chances que você não aproveita.", sunny, langPt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny, langPt),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny, langPt),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny, langPt),
        Phrase("Se você acredita, faz toda a diferença.", sunny, langPt),
        Phrase(
            "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!",
            sunny,
            langPt
        ),

        Phrase("Sin saber que era imposible, siguió adelante y lo hizo.", happy, langEs),
        Phrase("Las cosas grandes están hechas de muchas cosas pequeñas.", happy, langEs),
        Phrase("Si arriesgas la felicidad, arriésgate", happy, langEs),
        Phrase(
            "No estás derrotado cuando pierdes, ¡estás derrotado cuando te rindes!",
            happy,
            langEs
        ),
        Phrase("¡Cuando está más oscuro, vemos más estrellas!", happy, langEs),
        Phrase(
            "La locura es repetir lo mismo una y otra vez y esperar un resultado diferente.",
            happy,
            langEs
        ),
        Phrase("No pares cuando estés cansado, detente cuando hayas terminado", happy, langEs),
        Phrase(
            "¿Qué puedes hacer ahora mismo que tenga el mayor impacto en tu éxito?",
            happy,
            langEs
        ),
        Phrase("La mejor manera de predecir el futuro es inventarlo.", sunny, langEs),
        Phrase("¡Se trata de vivir tus sueños, no tus miedos!", sunny, langEs),
        Phrase("Tener luz no se trata de brillar, ¡se trata de iluminar!", sunny, langEs),
        Phrase("La dirección es más importante que la velocidad.", sunny, langEs),
        Phrase("Pierdes cada oportunidad que no aprovechas.", sunny, langEs),
        Phrase("El fracaso es el condimento que le da sabor al éxito.", sunny, langEs),
        Phrase("Hasta que no nos comprometamos, ¡habrá dudas!", sunny, langEs),
        Phrase("Si no sabes a dónde quieres ir, cualquier camino servirá.", sunny, langEs),
        Phrase("Si crees, hace toda la diferencia.", sunny, langEs),
        Phrase(
            "Hay que correr riesgos, porque el mayor peligro es no arriesgar nada.",
            sunny,
            langEs
        ),

        Phrase("Not knowing it was impossible, he went ahead and did it.", happy, langEn),
        Phrase("Big things are made of a lot of little things.", happy, langEn),
        Phrase("If there's a risk to happiness, take it.", happy, langEn),
        Phrase(
            "You're not defeated when you lose, you're defeated when you give up!",
            happy,
            langEn
        ),
        Phrase("When it's darkest, we see the most stars!", happy, langEn),
        Phrase(
            "Insanity is doing the same thing over and over again and expecting a different result.",
            happy,
            langEn
        ),
        Phrase("Don't stop when you're tired, stop when you're done.", happy, langEn),
        Phrase(
            "What can you do right now that will have the greatest impact on your success?",
            happy,
            langEn
        ),
        Phrase("The best way to predict the future is to invent it.", sunny, langEn),
        Phrase("It's about living your dreams, not your fears!", sunny, langEn),
        Phrase("Having the light isn't about shining, it's about illuminating!", sunny, langEn),
        Phrase("Direction is more important than speed.", sunny, langEn),
        Phrase("You miss every chance you don't take.", sunny, langEn),
        Phrase("Failure is the condiment that gives success its flavor.", sunny, langEn),
        Phrase("Until we're committed, there will be hesitation!", sunny, langEn),
        Phrase("If you don't know where you want to go, any path will do.", sunny, langEn),
        Phrase("If you believe, it makes all the difference.", sunny, langEn),
        Phrase(
            "Risks must be taken, because the greatest danger is not risking anything!",
            sunny,
            langEn
        ),
    )


    fun getPhrases(filter: Int, language: String): String {
        //verificação se a lingua selecionada no sistema está de acorda com a tradução de frases que
        // possuo. Caso nã esteja, foi definido uma lingua padrão.

        var langFilter = language.lowercase()
        if (language !in listOf(langEn, langPt, langEs)) {
            langFilter = AppConstants.LANGUAGE.PORTUGUESE
        }

// metodo criado para criar um range das frases
        val filtered =
            listPhrase.filter { (it.category == filter || filter == all) && it.language == langFilter }
        val rand = Random.nextInt(filtered.size)
        return filtered[rand].description
    }

}