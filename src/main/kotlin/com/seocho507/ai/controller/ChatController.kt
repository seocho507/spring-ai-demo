package com.seocho507.ai.controller

import com.seocho507.ai.service.OpenAiChatService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RequestMapping("/api/v1")
@RestController
class ChatController(
    private val openAiChatService: OpenAiChatService,
) {

    @PostMapping("/chat", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun chat(@RequestBody request: String): Flux<String> {
        return openAiChatService.chat(request)
    }
}