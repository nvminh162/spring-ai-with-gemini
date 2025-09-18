package com.nvminh162.spring_ai_with_gemini.dto.response;

public record BillItemResponse(String itemName, String unit, Integer quantity, Double price, Double subTotal) {}
