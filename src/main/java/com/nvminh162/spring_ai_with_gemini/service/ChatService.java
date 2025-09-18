package com.nvminh162.spring_ai_with_gemini.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import com.nvminh162.spring_ai_with_gemini.dto.request.ChatRequest;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ChatService {
    ChatClient chatClient;

    public String chat(ChatRequest request) {
        return chatClient.prompt(request.message())
                .call()
                .content();
    }
}
