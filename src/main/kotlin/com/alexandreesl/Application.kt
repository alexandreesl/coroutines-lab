package com.alexandreesl

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

object Application {

    private val logger = KotlinLogging.logger {}

    @JvmStatic
    fun main(args: Array<String>) {


        val deferred = CoroutineScope(IO).async {
            logger.info { "running on ${Thread.currentThread().name}" }
            delay(2000)
            123
        }

        runBlocking {

            logger.info { "running on ${Thread.currentThread().name}" }

            val resp = deferred.await()

            logger.info { "the result is $resp" }

        }



    }

}