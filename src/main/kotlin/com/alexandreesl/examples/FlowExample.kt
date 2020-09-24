package com.alexandreesl.examples

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.newSingleThreadContext
import mu.KotlinLogging
import java.time.LocalDateTime

class FlowExample {

    private val logger = KotlinLogging.logger {}

    suspend fun runExample() {

        val context1 = newSingleThreadContext("MyOwnThread1")

        val result = flow {
            for (number in 1..10) {
                logger.info { "I am processing the number $number at ${LocalDateTime.now()}" }
                delay(2000)
                emit(number)
            }
        }
            .flowOn(context1)
            .filter { it % 2 == 0 }
            .map {
                logger.info { "processing number $it" }
                it
            }
            .reduce { accumulator, value ->
                accumulator + value
            }
        logger.info { "result: $result" }

        (1..5).asFlow().collect {
            logger.info { "item: $it" }
        }

    }

}