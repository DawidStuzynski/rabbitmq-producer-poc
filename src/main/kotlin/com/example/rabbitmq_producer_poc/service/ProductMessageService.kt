package com.example.rabbitmq_producer_poc.service

import com.example.rabbitmq_producer_poc.rabbitmq.ConfigureRabbitMq
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class ProduceMessageService(private val rabbitTemplate: RabbitTemplate) {

    fun produceMessage(message: String): String {
        rabbitTemplate.convertAndSend(
            ConfigureRabbitMq.EXCHANGE_NAME, "myRoutingKey.messages",
            message
        )
        return "Message($message) has been produced. eeeeeeeeeeeee"
    }
}

