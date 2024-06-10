package com.example.rabbitmq_producer_poc.rabbitmq

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ConfigureRabbitMq {

    companion object {
        const val QUEUE_NAME = "myQueue"
        const val EXCHANGE_NAME = "myTopicExchange"
        const val ROUTING_KEY = "myRoutingKey.#"
    }

    @Bean
    fun createQueue(): Queue {
        return Queue(QUEUE_NAME, false)
    }

    @Bean
    fun exchange(): TopicExchange {
        return TopicExchange(EXCHANGE_NAME)
    }

    @Bean
    fun binding(queue: Queue, exchange: TopicExchange): Binding {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY)
    }

    @Bean
    fun container(connectionFactory: ConnectionFactory): SimpleMessageListenerContainer {
        val container = SimpleMessageListenerContainer()
        container.connectionFactory = connectionFactory
        return container
    }
}
