package com.seocho507.ai.client

import org.springframework.ai.chat.client.ChatClient
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class ChatAssistant(
    private val modelBuilder: ChatClient.Builder,
) {

    private val chatClient: ChatClient = modelBuilder
        .defaultSystem(
            """
                hello
            """
        )
//        .defaultFunctions("")
        .build()

    fun chat(userMessageContent: String): Flux<String> {
        return chatClient.prompt()
            .user(userMessageContent)
            .stream()
            .content()
    }
}