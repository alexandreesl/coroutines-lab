package com.alexandreesl.examples

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ClosedReceiveChannelException
import mu.KotlinLogging

class ChannelExample {

    private val logger = KotlinLogging.logger {}

    suspend fun runExample() {

        val channel = Channel<Int>()

        CoroutineScope(Dispatchers.IO).launch {
            for (item in 1..10) {
                // delay to represent IO
                delay(2000)
                logger.info { "Sending: $item" }
                channel.send(item)
            }
            // closing the channel, we are done
            channel.close()
        }

        val deferred = CoroutineScope(Dispatchers.IO).async {
            try {
                while (true) {
                    val received = channel.receive()
                    logger.info { "Received: $received" }
                }
            } catch (e: ClosedReceiveChannelException) {
                // this happens when the channel is closed
            }
            //signalling the process has ended
            true
        }

        deferred.await()

    }


}