package com.example.rabbitmq_producer_poc.controller

import com.example.rabbitmq_producer_poc.service.ProduceMessageService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProduceMessageController(private val produceMessageService: ProduceMessageService) {

    @PostMapping("/produce")
    fun produceMessage(@RequestParam message: String): String {
        return produceMessageService.produceMessage(message)
    }
}

