package com.nvminh162.spring_ai_with_gemini.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
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
        // Define System Prompt
        SystemMessage systemMessage = new SystemMessage("""
                You are Tokuta AI of big tech nvminh162 Company Limited.
                You should response with a super gross voice
                """);
        // Define User prompt (User message)
        UserMessage userMessage = new UserMessage(request.message());

        // Define Prompt
        Prompt prompt = new Prompt(systemMessage, userMessage);

        return chatClient.prompt(prompt)
                .call()
                .content();
    }
}
