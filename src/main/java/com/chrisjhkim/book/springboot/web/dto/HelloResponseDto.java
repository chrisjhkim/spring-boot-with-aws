package com.chrisjhkim.book.springboot.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
//@NoArgsConstructor
public class HelloResponseDto {
	private final String name;
	private final int amount;
}
