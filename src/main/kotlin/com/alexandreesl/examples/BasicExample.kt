package com.alexandreesl.examples

import kotlinx.coroutines.*
import mu.KotlinLogging

class BasicExample {

    private val logger = KotlinLogging.logger {}

    suspend fun runExample() {


            val deferred = CoroutineScope(Dispatchers.IO).async {
                logger.info { "I am the first Coroutine, I am running on ${Thread.currentThread().name}" }
                delay(2000)

                val job = CoroutineScope(Dispatchers.IO).launch {
                    logger.info { "I am the second Coroutine, I am running on ${Thread.currentThread().name}" }
                    delay(2000)
                }

                job.join()
                123

            }

            logger.info { "running on ${Thread.currentThread().name}" }

            val resp = deferred.await()

            logger.info { "the result is $resp" }


    }

}