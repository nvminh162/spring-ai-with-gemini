package com.nvminh162.spring_ai_with_gemini.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nvminh162.spring_ai_with_gemini.dto.request.ChatRequest;
import com.nvminh162.spring_ai_with_gemini.dto.response.BillItemResponse;
import com.nvminh162.spring_ai_with_gemini.dto.response.ExpenseInfoResponse;
import com.nvminh162.spring_ai_with_gemini.dto.response.FilmInfoResponse;
import com.nvminh162.spring_ai_with_gemini.service.ChatService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ChatController {
    ChatService chatService;

    @PostMapping("/chat")
    String chat(@RequestBody ChatRequest request) {
        return chatService.chat(request);
    }

    @PostMapping("/chat-structure-data-list")
    List<FilmInfoResponse> chatWithStructureDataList(@RequestBody ChatRequest request) {
        return chatService.chatWithStructureDataList(request);
    }

    @PostMapping("/chat-structure-data-entity")
    ExpenseInfoResponse chatWithStructureDataEntity(@RequestBody ChatRequest request) {
        return chatService.chatWithStructureDataEntity(request);
    }

    @PostMapping("/chat-with-image")
    public String chatWithImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("message") String message) {
        return chatService.chatWithImage(file, message);
    }

    @PostMapping("/chat-with-image-struct-data-list")
    public List<BillItemResponse> chatWithImageStructureDataList(
            @RequestParam("file") MultipartFile file,
            @RequestParam("message") String message) {
        return chatService.chatWithImageStructureDataList(file, message);
    }

    @PostMapping("/chat-with-memory")
    String chatWithMemory(@RequestBody ChatRequest request) {
        return chatService.chatWithMemory(request);
    }
}
