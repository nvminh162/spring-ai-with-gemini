package com.nvminh162.spring_ai_with_gemini.controller;

import org.springframework.web.bind.annotation.RestController;

import com.nvminh162.spring_ai_with_gemini.dto.request.ChatRequest;
import com.nvminh162.spring_ai_with_gemini.service.ChatService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ChatController {
    ChatService chatService;

    @PostMapping("/chat")
    String chat(@RequestBody ChatRequest request) {

        return chatService.chat(request);
    }

}
