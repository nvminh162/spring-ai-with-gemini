package com.nvminh162.spring_ai_with_gemini.dto.response;

// record type: dùng để đơn giản hoá class chỉ để chứa dữ liệu (không cần tạo getter setter)
public record ExpenseInfoResponse(String category, String itemName, Double amount) {}
