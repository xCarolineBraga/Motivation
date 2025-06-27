package com.example.appmotivation.repository

import com.example.appmotivation.constants.AppConstants
import kotlin.random.Random

data class Phrase(val description: String, val category: Int)

class PhraseRepository {

    //Por ser uma informação sensivel, foram criadas constantes.
    private val all = AppConstants.Phrases.ALL
    private val happy = AppConstants.Phrases.SMILE
    private val sunny = AppConstants.Phrases.SUNNY

    // variável criada para receber a lista de frases

    private val listPhrase: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", happy),
        Phrase("Coisas grandes são feitas de um monte de coisinhas.", happy),
        Phrase("Se houver risco de felicidade, arrisque-se", happy),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", happy),
        Phrase("Quando está mais escuro, vemos mais estrelas!", happy),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny),
        Phrase("É sobre viver os sonhos e não os medos!", sunny),
        Phrase("Ter luz não é sobre brilhar, é sobre iluminar!", sunny),
        Phrase("Direção é mais importante que velocidade.", sunny),
        Phrase("Você perde todas as chances que você não aproveita.", sunny),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny),
        Phrase("Se você acredita, faz toda a diferença.", sunny),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny),

        Phrase("Sin saber que era imposible, siguió adelante y lo hizo.", happy),
        Phrase("Las cosas grandes están hechas de muchas cosas pequeñas.", happy),
        Phrase("Si arriesgas la felicidad, arriésgate", happy),
        Phrase("No estás derrotado cuando pierdes, ¡estás derrotado cuando te rindes!",happy),
        Phrase("¡Cuando está más oscuro, vemos más estrellas!",happy),
        Phrase("La locura es repetir lo mismo una y otra vez y esperar un resultado diferente.",happy),
        Phrase("No pares cuando estés cansado, detente cuando hayas terminado",happy),
        Phrase("¿Qué puedes hacer ahora mismo que tenga el mayor impacto en tu éxito?",happy),
        Phrase("La mejor manera de predecir el futuro es inventarlo.",sunny),
        Phrase("¡Se trata de vivir tus sueños, no tus miedos!",sunny),
        Phrase("Tener luz no se trata de brillar, ¡se trata de iluminar!",sunny),
        Phrase("La dirección es más importante que la velocidad.",sunny),
        Phrase("Pierdes cada oportunidad que no aprovechas.",sunny),
        Phrase("El fracaso es el condimento que le da sabor al éxito.",sunny),
        Phrase("Hasta que no nos comprometamos, ¡habrá dudas!",sunny),
        Phrase("Si no sabes a dónde quieres ir, cualquier camino servirá.",sunny),
        Phrase("Si crees, hace toda la diferencia.",sunny),
        Phrase("Hay que correr riesgos, porque el mayor peligro es no arriesgar nada.",sunny),

        Phrase("Not knowing it was impossible, he went ahead and did it.",happy),
        Phrase("Big things are made of a lot of little things.",happy),
        Phrase("If there's a risk to happiness, take it.",happy),
        Phrase("You're not defeated when you lose, you're defeated when you give up!",happy),
        Phrase("When it's darkest, we see the most stars!",happy),
        Phrase("Insanity is doing the same thing over and over again and expecting a different result.",happy),
        Phrase("Don't stop when you're tired, stop when you're done.",happy),
        Phrase("What can you do right now that will have the greatest impact on your success?",happy),
        Phrase("The best way to predict the future is to invent it.",sunny),
        Phrase("It's about living your dreams, not your fears!",sunny),
        Phrase("Having the light isn't about shining, it's about illuminating!",sunny),
        Phrase("Direction is more important than speed.",sunny),
        Phrase("You miss every chance you don't take.",sunny),
        Phrase("Failure is the condiment that gives success its flavor.",sunny),
        Phrase("Until we're committed, there will be hesitation!",sunny),
        Phrase("If you don't know where you want to go, any path will do.",sunny),
        Phrase("If you believe, it makes all the difference.",sunny),
        Phrase("Risks must be taken, because the greatest danger is not risking anything!",sunny),
    )

    // metodo criado para criar um range das frases
    fun getPhrases(filter:Int): String {

        val filtered = listPhrase.filter { it.category == filter || filter == all }
        val rand = Random.nextInt(filtered.size)
        return filtered[rand].description
    }

}