package dev.silas.rsocketsample

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Flux
import java.time.Duration

@Controller
class CountingController {

    @MessageMapping("counter")
    fun createInts(request: StartRequest): Flux<Int> =
        Flux.range(0,request.howMany)
            .delayElements(Duration.ofSeconds(1))

    data class StartRequest(
        val howMany: Int
    )
}