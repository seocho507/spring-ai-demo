package com.seocho507.ai.service

import com.seocho507.ai.client.ChatAssistant
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class OpenAiChatServiceImpl(
    private val chatAssistant: ChatAssistant
) : OpenAiChatService {
    override fun chat(request: String): Flux<String> {
        return chatAssistant.chat(request)
    }
}