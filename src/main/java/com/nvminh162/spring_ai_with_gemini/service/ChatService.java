package com.nvminh162.spring_ai_with_gemini.service;

import java.util.List;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.content.Media;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

import com.nvminh162.spring_ai_with_gemini.dto.request.ChatRequest;
import com.nvminh162.spring_ai_with_gemini.dto.response.BillItemResponse;
import com.nvminh162.spring_ai_with_gemini.dto.response.ExpenseInfoResponse;
import com.nvminh162.spring_ai_with_gemini.dto.response.FilmInfoResponse;

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

        public List<FilmInfoResponse> chatWithStructureDataList(ChatRequest request) {
                SystemMessage systemMessage = new SystemMessage("""
                                You are Tokuta AI of big tech nvminh162 Company Limited.
                                You should response with a super gross voice
                                """);
                UserMessage userMessage = new UserMessage(request.message());
                Prompt prompt = new Prompt(systemMessage, userMessage);
                return chatClient.prompt(prompt)
                                .call()
                                .entity(new ParameterizedTypeReference<List<FilmInfoResponse>>() {
                                });
        }

        public ExpenseInfoResponse chatWithStructureDataEntity(ChatRequest request) {
                SystemMessage systemMessage = new SystemMessage("""
                                You are Tokuta AI of big tech nvminh162 Company Limited.
                                You should response with a super gross voice
                                """);
                UserMessage userMessage = new UserMessage(request.message());
                Prompt prompt = new Prompt(systemMessage, userMessage);
                return chatClient.prompt(prompt)
                                .call()
                                .entity(ExpenseInfoResponse.class);
        }

        public String chatWithImage(MultipartFile file, String message) {
                String contentType = file.getContentType();
                if (contentType == null) {
                        contentType = "application/octet-stream"; // Default MIME type
                }
                Media media = Media.builder()
                                .mimeType(MimeTypeUtils.parseMimeType(contentType))
                                .data(file.getResource())
                                .build();

                ChatOptions chatOptions = ChatOptions.builder()
                                .temperature(0D) // 1D - Mức sáng tạo nhất -> độ chính xác thấp
                                .build();

                return chatClient.prompt()
                                .options(chatOptions)
                                .system("""
                                                You are Tokuda AI
                                                """)
                                .user(promptUserSpec -> promptUserSpec
                                                .media(media)
                                                .text(message))
                                .call()
                                .content();
        }

        public List<BillItemResponse> chatWithImageStructureDataList(MultipartFile file, String message) {
                String contentType = file.getContentType();
                if (contentType == null) {
                        contentType = "application/octet-stream"; // Default MIME type
                }
                Media media = Media.builder()
                                .mimeType(MimeTypeUtils.parseMimeType(contentType))
                                .data(file.getResource())
                                .build();

                ChatOptions chatOptions = ChatOptions.builder()
                                .temperature(0D) // 1D - Mức sáng tạo nhất -> độ chính xác thấp
                                .build();

                return chatClient.prompt()
                                .options(chatOptions)
                                .system("""
                                                You are Tokuda AI
                                                """)
                                .user(promptUserSpec -> promptUserSpec
                                                .media(media)
                                                .text(message))
                                .call()
                                .entity(new ParameterizedTypeReference<List<BillItemResponse>>() {
                                });
        }
}
