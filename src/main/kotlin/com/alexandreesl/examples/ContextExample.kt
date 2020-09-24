package com.alexandreesl.examples

import kotlinx.coroutines.delay
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.withContext
import mu.KotlinLogging

class ContextExample {

    private val logger = KotlinLogging.logger {}

    suspend fun runExample() {

        val context1 = newSingleThreadContext("MyOwnThread1")
        val context2 = newSingleThreadContext("MyOwnThread2")

        withContext(context1) {

            logger.info { "I am a coroutine, I am running on ${Thread.currentThread().name}" }

            withContext(context2) {

                logger.info { "I am also a coroutine, I am running on ${Thread.currentThread().name}" }
                delay(3000)

            }

            logger.info { "I am the previous coroutine, I am running on ${Thread.currentThread().name}" }

            delay(3000)

        }

    }

}