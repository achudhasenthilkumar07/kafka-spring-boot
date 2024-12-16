package com.kafka.poc.dto;


public record ResponseDTO(String message, Object data, Integer status) {
}
