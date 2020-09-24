package com.alexandreesl

import com.alexandreesl.examples.BasicExample
import com.alexandreesl.examples.ContextExample
import com.alexandreesl.examples.FlowExample
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging

object Application {

    private val logger = KotlinLogging.logger {}

    @JvmStatic
    fun main(args: Array<String>) {

        runBlocking {

            val basicExample = BasicExample()

            basicExample.runExample()

            val contextExample = ContextExample()

            contextExample.runExample()

            val flowExample = FlowExample()

            flowExample.runExample()

        }

    }

}