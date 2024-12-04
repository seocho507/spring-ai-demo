package com.seocho507.ai.service

import reactor.core.publisher.Flux

interface OpenAiChatService {
    fun chat(request: String): Flux<String>
}