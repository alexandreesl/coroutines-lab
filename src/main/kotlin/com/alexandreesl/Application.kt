package com.alexandreesl

import com.alexandreesl.examples.BasicExample
import com.alexandreesl.examples.ContextExample
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import mu.KotlinLogging

object Application {

    private val logger = KotlinLogging.logger {}

    @JvmStatic
    fun main(args: Array<String>) {

        runBlocking {

          val basicExample =  BasicExample()

          basicExample.runExample()

          val contextExample =  ContextExample()

          contextExample.runExample()

        }

    }

}